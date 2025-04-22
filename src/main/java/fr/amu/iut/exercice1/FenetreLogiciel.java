package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

        // Sidebar de boutons
        VBox sideBar = new VBox();

        Label labelSideBar = new Label("Boutons :");
        Button btn1SideBar = new Button("Bouton 1");
        Button btn2SideBar = new Button("Bouton 2");
        Button btn3SideBar = new Button("Bouton 3");
        sideBar.getChildren().addAll(labelSideBar,btn1SideBar,btn2SideBar,btn3SideBar);
        sideBar.setAlignment(Pos.CENTER);
        sideBar.setSpacing(10);

        Separator leftSeperator = new Separator(Orientation.VERTICAL);
        HBox leftBorder = new HBox(sideBar, leftSeperator);

        root.setLeft(leftBorder);

        // Formulaire central
        VBox centerBorder = new VBox();

        GridPane formulaire = new GridPane();
        formulaire.setAlignment(Pos.CENTER);
        formulaire.setHgap(10);
        formulaire.setVgap(10);

        Label labelName = new Label("Name:");
        GridPane.setConstraints(labelName,0,0);
        TextField txtFieldName = new TextField();
        GridPane.setConstraints(txtFieldName,1,0);

        Label labelEmail = new Label("Email:");
        GridPane.setConstraints(labelEmail,0,1);
        TextField txtFieldEmail = new TextField();
        GridPane.setConstraints(txtFieldEmail,1,1);

        Label labelPassword = new Label("Password:");
        GridPane.setConstraints(labelPassword,0,2);
        TextField txtFieldPassword = new TextField();
        GridPane.setConstraints(txtFieldPassword,1,2);

        HBox centerButtons = new HBox();
        Button btnSubmit = new Button("Submit");
        Button btnCancel = new Button("Cancel");
        centerButtons.setAlignment(Pos.CENTER);
        centerButtons.setSpacing(10);

        formulaire.getChildren().addAll(labelName,txtFieldName,labelEmail,txtFieldEmail,labelPassword,txtFieldPassword);
        centerButtons.getChildren().addAll(btnSubmit,btnCancel);
        centerBorder.getChildren().addAll(formulaire,centerButtons);
        centerBorder.setAlignment(Pos.CENTER);
        centerBorder.setSpacing(10);

        root.setCenter(centerBorder);

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

