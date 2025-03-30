package com.balatro.randomizer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox appBox = new VBox(20);
        Label appTitle = new Label("BALATRO Randomizer");
        Button primaryButton = new Button("Click!");
        
        Label radioBtnLabel = new Label("Are you using black deck?");


        ToggleGroup tg = new ToggleGroup();
        RadioButton yesBtn = new RadioButton("Yes");
        yesBtn.setToggleGroup(tg);

        RadioButton noBtn = new RadioButton("No");
        noBtn.setToggleGroup(tg);


        Label displayJokers = new Label("");
        
        appTitle.setFont(new Font("Arial Rounded MT Bold", 18));

        primaryButton.setFont(new Font(14));
        primaryButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-background-radius: 10;");

        displayJokers.setFont(new Font("Arial Rounded MT Bold", 18));

        radioBtnLabel.setFont(new Font("Arial Rounded MT Bold", 18));


        appBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        appBox.getChildren().addAll(appTitle, primaryButton, displayJokers, radioBtnLabel, yesBtn, noBtn);

        VBox vbox = new VBox(20, appBox);
        vbox.setPadding(new Insets(50, 0, 0, 0));

        Scene scene = new Scene(vbox, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Balatro Randomizer");
        stage.show();
        
        primaryButton.setOnAction(e -> {
            try {
                String[] jokerNames = {
                    "Joker", "Greedy Joker", "Lusty Joker", "Wrathful Joker", "Gluttenous Joker", "Jolly Joker", "Zany Joker",
                    "Mad Joker", "Crazy Joker", "Droll Joker", "Sly", "Wily", "Clever", "Devious", "Crafty", "Half", "Stencil", 
                    "Four Fingers", "Mime", "Credit Card", "Ceremonial Dagger", "Banner", "Mystic Summit", "Marble Joker", "Loyalty Card", 
                    "8 Ball", "Misprint", "Dusk", "Raised Fist", "Chaos the Clown", "Fibonacci", "Steel Joker", "Scary Face", "Abstract Joker", 
                    "Delayed Gratification", "Hack", "Pareidolia", "Gros Michel", "Even Steven", "Odd Todd", "Scholar", "Business", 
                    "Supernova", "Ride The Bus", "Space Joker", "Egg", "Burglar", "Blackboard", "Runner", "Ice Cream", "DNA", "Splash", 
                    "Blue Joker", "Sixth Sense", "Constellation", "Hiker", "Faceless Joker", "Green Joker", "Superposition", "To Do List", 
                    "Cavendish", "Card Sharp", "Red Card", "Madness", "Square Joker", "Seance", "Riff Raff", "Vampire", "Shortcut", 
                    "Hologram", "Vagabond", "Baron", "Cloud 9", "Rocket", "Obelisk", "Midas Mask", "Luchador", "Photograph", "Gift", 
                    "Turtle Bean", "Erosion", "Reserved Parking", "Mail-in Rebate", "To The Moon", "Hallucination", "Fortune Teller", 
                    "Juggler", "Drunkard", "Stone Joker", "Golden Joker", "Lucky Cat", "Baseball Card", "Bull", "Diet Cola", "Trading Card", 
                    "Flash Card", "Popcorn", "Spare Trousers", "Ancient Joker", "Ramen", "Walkie Talkie", "Seltzer", "Castle", 
                    "Smiley Face", "Campfire", "Golden Ticket", "Mr. Bones", "Acrobat", "Sock And Buskin", "Swashbuckler", "Troubadour", 
                    "Certificate", "Smeared Joker", "Throwback", "Hanging Chad", "Rough Gem", "Bloodstone", "Arrowhead", "Onyx Agate", 
                    "Glass Joker", "Showman", "Flower Pot", "Blueprint", "Wee Joker", "Merry Andy", "Oops All 6s", "Idol", "Seeing Double", 
                    "Matador", "Hit The Road", "Duo", "Trio", "Family", "Order", "Tribe", "Stuntman", "Invisible Joker", "Brainstorm", "Satellite", 
                    "Shoot The Moon", "Driver's License", "Cartomancer", "Astronomer", "Burnt", "Bootstraps", "Caino", "Triboulet", 
                    "Yorick", "Chicot", "Perkeo"
                };
        
                List<String> selectedJokers = new ArrayList<>();
        
                RadioButton selectedRadioBtn = (RadioButton) tg.getSelectedToggle();
                
                if (selectedRadioBtn == null) {
                    throw new IllegalStateException("No deck type selected! Please choose a deck type.");
                }
        
                String selectedValue = selectedRadioBtn.getText();
                int deckType;
        
                if (selectedValue.equals("No"))
                    deckType = 5;
                else
                    deckType = 6;
        
                for (int i = 0; i < deckType; i++) {
                    int num = (int) (Math.random() * jokerNames.length);
                    selectedJokers.add(jokerNames[num]);
                }
        
                displayJokers.setText(String.join("\n", selectedJokers));
            } catch (Exception ex) {
                displayJokers.setText("Please answer the question below first.");
            }
        });
        
    }

    public static void main(String[] args) {
        launch();
    }
}
