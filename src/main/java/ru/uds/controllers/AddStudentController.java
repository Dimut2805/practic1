package ru.uds.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.uds.database.model.ListStudents;

import java.util.List;


public class AddStudentController {
    @FXML
    TextField id;
    @FXML
    TextField surname;
    @FXML
    TextField name;
    @FXML
    VBox vbox;

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    @FXML
    public void addStudent() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("database/hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        session.createSQLQuery("INSERT INTO list_students" +
                "(id, surname, name)" +
                "VALUES ('" + id.getText() + "','" + surname.getText() + "','" + name.getText() + "');").executeUpdate();
        vbox.getChildren().clear();
        List<ListStudents> list = session.createQuery("FROM ListStudents").list();
        for (ListStudents listStudents : list) {
            vbox.getChildren().add(new HBox(
                    new Label(listStudents.getId() + " " + listStudents.getSurname() + " " + listStudents.getName())));
        }
        t.commit();
        factory.close();
        session.close();
    }
}