//Author Name: Anjali Smith
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.control.Button;

public class Assignment11Unit2 extends Application {
//The following instance variables are declared here so they can be used by the inner class
  private GridPane rootNode;
  private ImageView c1;
  private ImageView c2;
  private ImageView c3;
  private ImageView back1;
  private ImageView back2;
  private ImageView back3;
  private Button c1Flip;
  private Button c2Flip;
  private Button c3Flip;
  private Boolean isFlipped1 = false;
  private Boolean isFlipped2 = false;
  private Boolean isFlipped3 = false;

  @Override
  public void start(Stage myStage) {
//This program first creates a GridPane and sets its properties.
    rootNode = new GridPane();
    rootNode.setAlignment(Pos.CENTER);
    rootNode.setHgap(30);

//It then creates three ImageView objects for the three card images and three buttons for each card. It then adds them to the GridPane.
    c1 = new ImageView(new Image("c1.gif"));
    c2 = new ImageView(new Image("c2.gif"));
    c3 = new ImageView(new Image("c3.gif"));
    c1Flip = new Button("flip");
    c2Flip = new Button("flip");
    c3Flip = new Button("flip");
    rootNode.add(c1,0,1);
    rootNode.add(c2,1,1);
    rootNode.add(c3,2,1);
    rootNode.add(c1Flip,0,2);
    rootNode.add(c2Flip,1,2);
    rootNode.add(c3Flip,2,2);
//It intitializes three ImageView objects for the back of each card
    back1 = new ImageView(new Image("b1fv.gif"));
    back2 = new ImageView(new Image("b1fv.gif"));
    back3 = new ImageView(new Image("b1fv.gif"));
//It centers the three flip buttons below each card image.
    rootNode.setHalignment(c1Flip, HPos.CENTER);
    rootNode.setHalignment(c2Flip, HPos.CENTER);
    rootNode.setHalignment(c3Flip, HPos.CENTER);

//It registers the event handlers with each event source.
    c1Flip.setOnAction(new c1FlipHandler());
    c2Flip.setOnAction(new c2FlipHandler());
    c3Flip.setOnAction(new c3FlipHandler());

//Lastly, the start() method sets the title for the stage, creates a new scene, and adds the scene to the stage.
    myStage.setTitle("DisplayImages");
    Scene myScene = new Scene(rootNode, 300,200);
    myStage.setScene(myScene);
    myStage.show();
  }

//It has an inner class for each button that handles each button's actions.
  class c1FlipHandler implements EventHandler<ActionEvent> {
    public void handle (ActionEvent e) {
          if (isFlipped1) {
           rootNode.getChildren().remove(back1);
           rootNode.add(c1,0,1);
       }
       else {
         rootNode.getChildren().remove(c1);
         rootNode.add(back1,0,1);
       }
        isFlipped1 = !isFlipped1;
    }
  }

   class c2FlipHandler implements EventHandler<ActionEvent> {
    public void handle (ActionEvent e) {
        if (isFlipped2) {
           rootNode.getChildren().remove(back2);
           rootNode.add(c2,1,1);
        }
       else {
         rootNode.getChildren().remove(c2);
         rootNode.add(back2,1,1);
       }
        isFlipped2 = !isFlipped2;
    }
   }
 

  class c3FlipHandler implements EventHandler<ActionEvent> {
    public void handle (ActionEvent e) {
       if (isFlipped3) {
           rootNode.getChildren().remove(back3);
           rootNode.add(c3,2,1);
       }
       else {
         rootNode.getChildren().remove(c3);
         rootNode.add(back3,2,1);
       }
        isFlipped3 = !isFlipped3;
    }
  }
}