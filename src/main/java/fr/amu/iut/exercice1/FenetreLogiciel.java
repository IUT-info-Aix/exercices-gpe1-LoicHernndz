package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Conteneur Principal
        BorderPane root = new BorderPane();

        // Menu supérieur
        Menu menu1 = new Menu("File");
        MenuItem menuItem1_2 = new MenuItem("Open");
        MenuItem menuItem1_3 = new MenuItem("Save");
        MenuItem menuItem1_1 = new MenuItem("New");
        MenuItem menuItem1_4 = new MenuItem("Close");
        menu1.getItems().addAll(menuItem1_1,menuItem1_2,menuItem1_3,menuItem1_4);

        Menu menu2 = new Menu("Edit");
        MenuItem menuItem2_1 = new MenuItem("Cut");
        MenuItem menuItem2_2 = new MenuItem("Copy");
        MenuItem menuItem2_3 = new MenuItem("Paste");
        menu2.getItems().addAll(menuItem2_1,menuItem2_2,menuItem2_3);

        Menu menu3 = new Menu("Help");

        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        root.setTop(menuBar);
        // Bandeau inférieur de prompt

        Label prompts = new Label ("Ceci est un label de bas de page");
        Separator bottomSeperator = new Separator(Orientation.HORIZONTAL);
        VBox bottomBorder = new VBox(bottomSeperator, prompts);
        bottomBorder.setAlignment(Pos.CENTER);
        root.setBottom(bottomBorder);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(root);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

