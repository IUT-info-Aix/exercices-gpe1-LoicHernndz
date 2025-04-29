package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.root = new BorderPane();

        this.label = new Label();
        root.setTop(label);
        BorderPane.setAlignment(label, Pos.CENTER);

        this.panneau = new Pane();
        panneau.setPrefSize(400, 200);
        root.setCenter(panneau);

        this.bas = new HBox();

        this.vert = new Button("Vert");
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> colorButtonClick(actionEvent, "Vert", "00ff00"));
        this.rouge = new Button("Rouge");
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> colorButtonClick(actionEvent, "Rouge", "ff0000"));
        this.bleu = new Button("Bleu");
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> colorButtonClick(actionEvent, "Bleu", "0000ff"));

        bas.getChildren().addAll(vert, rouge, bleu);
        bas.setAlignment(Pos.CENTER);

        root.setBottom(bas);
        BorderPane.setMargin(root, new Insets(10,10,10,10));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void colorButtonClick(Event event, String color, String hex) {

        if (color.equals("Bleu")) {
            ++this.nbBleu;
            this.label.setText(color + " choisi " + nbBleu + " fois");
        }
        else
            this.nbBleu = 0;

        if (color.equals("Rouge")) {
            ++this.nbRouge;
            this.label.setText(color + " choisi " + nbRouge + " fois");
        }
        else
            this.nbRouge = 0;

        if (color.equals("Vert")) {
            ++this.nbVert;
            this.label.setText(color + " choisi " + nbVert + " fois");
        }
        else
            nbVert = 0;

        this.panneau.setStyle("-fx-background-color: #" + hex + ";");

    }
}
