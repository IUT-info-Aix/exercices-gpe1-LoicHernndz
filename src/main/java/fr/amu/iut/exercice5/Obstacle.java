package fr.amu.iut.exercice5;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Group {

    protected final static double LARGEUR_MOITIE_OBSTACLE = 10;
    protected final static double LARGEUR_OBSTACLE = LARGEUR_MOITIE_OBSTACLE * 2;
    private final Rectangle corps;

    Obstacle(){
        corps = new Rectangle(0,0, LARGEUR_OBSTACLE, LARGEUR_OBSTACLE);
        corps.setFill(Color.RED);
        getChildren().add(corps);
    }
}
