package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IHMPendu extends Application {

    private Dico dico = new Dico();
    private String mot = dico.getMot();
    private String motAffiche = "*".repeat(mot.length());
    private int vies = 7;

    //  Image

    private ArrayList<Image> imgPendu = new ArrayList<>();
    private Image imgPenduWin = new Image("Exercice6/penduWin.png");
    private ImageView imgPenduView = new ImageView();

    //  Labels
    private Label lblVies = new Label("Nombre de vies : 7");
    private Label lblMot = new Label("*".repeat(mot.length()));

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

        //  Clavier jeu
        GridPane gridLetters = new GridPane();
        gridLetters.setAlignment(Pos.CENTER);

        //  Chargement des images
        for (int i = 0; i <= 7; i++)
            this.imgPendu.add(new Image("exercice6/pendu" + i + ".png"));

        this.imgPenduView.setImage(imgPendu.get(this.vies));

        //  Boutons lettres
        ArrayList<Button> buttonsLetters = new ArrayList<>();

        for (int lettre = 97; lettre <= 122; ++lettre) {
            buttonsLetters.add(new Button(Character.toString((char) lettre)));
            Button finalButton = buttonsLetters.get(lettre-97);
            buttonsLetters.get(lettre-97).setOnAction(actionEvent -> tryLetter(actionEvent, finalButton));
        }

        for (int i = 0 ; i < 26; ++i) {
            gridLetters.add(buttonsLetters.get(i), i%10 + 2 * (i/20), i/10);
            GridPane.setHalignment(buttonsLetters.get(i), HPos.CENTER);
        }

        root.getChildren().addAll(this.imgPenduView, this.lblVies, this.lblMot, gridLetters);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void tryLetter(ActionEvent event, Button button) {

        button.setDisable(true);
        ArrayList<Integer> listePositions = dico.getPositions(button.getText().charAt(0), mot);

        if (vies == 0)
            this.lblMot.setText(mot);
        else if (listePositions.size() > 0) {
            StringBuilder motBuilder = new StringBuilder(motAffiche);
            for (int position : listePositions)
                motBuilder.setCharAt(position, button.getText().charAt(0));

            motAffiche = motBuilder.toString();
            this.lblMot.setText(motAffiche);
            if (mot.equals(motAffiche)) {

            }
        }
        else if (vies > 0){
            --vies;
            this.lblVies.setText("Nombre de vies : " + String.valueOf(vies));
            this.imgPenduView.setImage(imgPendu.get(this.vies));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
