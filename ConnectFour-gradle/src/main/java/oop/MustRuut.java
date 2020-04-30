package oop;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class MustRuut extends Application {

    @Override
    public void start(Stage peaLava) throws Exception {
        // Connect Four pealkiri
        Text pealkiri = new Text();
        pealkiri.setText("CONNECT FOUR");
        pealkiri.setFill(Color.GOLD);
        pealkiri.setTextAlignment(TextAlignment.CENTER);
        pealkiri.setStyle("-fx-font-size: 24");

        // Tutvustav tekst
        Text sissejuhatus = new Text();
        sissejuhatus.setText("Tere tulemast mängima mängu 'Connect Four'! \n" +
                "Oma käigu ajal pead valima, millisest veerust oma nuppu soovid sisestada. \nSeejärel teeb seda sama sinu vastaseks olev arvuti.\n" +
                "Mängu eesmärgiks on olla esimene, kes moodustab horisontaalse, vertikaalse või diagonaalse joone,\nmis oleks sama pikk kui võidu tingimus.\n" +
                "Alustamiseks pead sisestama oma nime ja sümboli, millega sooviksid mängida. \nSeejärel sisesta soovitud mängulaua suurused ja võidu tingimus.\n" +
                "Head mängimist!\n________________________________________________________________________");
        sissejuhatus.setFill(Color.GOLD);
        sissejuhatus.setTextAlignment(TextAlignment.CENTER);
        sissejuhatus.setStyle("-fx-font-size: 20");

        // Mängu alustamise nupp
        Button startButton = new Button("START");
        startButton.setOnMouseClicked(event -> {

            peaLava.hide();
            Stage nimi = new Stage();
            String mangijaNimi;
            String mangijaNupp;

            // oma nime sisestamise koht, kust edasi peab hetkel lihtsalt hiirega minema
            Label kusimus = new Label("Sisestage oma nimi: ");
            kusimus.setTextFill(Color.GOLD);
            TextField textField = new TextField();
            textField.setPrefColumnCount(10);

            // oma sümboli sisestamise koht, kust edasi liikumiseks peab OK nuppu vajutama
            Label nupuKusimine = new Label("Sisestage sümbol, millega tahaksite mängida, näiteks '⚫:");
            nupuKusimine.setTextFill(Color.GOLD);
            TextField textField2 = new TextField();
            textField2.setPrefColumnCount(10);

            Button OK = new Button("OK");

            // paigutus
            HBox hBox = new HBox(kusimus, textField);
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(40);
            HBox hBoxUus = new HBox(nupuKusimine, textField2);
            hBoxUus.setAlignment(Pos.CENTER);
            hBoxUus.setSpacing(40);
            HBox nupp = new HBox(OK);
            nupp.setAlignment(Pos.CENTER);
            VBox vBox = new VBox(hBox, hBoxUus, nupp);
            vBox.setSpacing(70);
            vBox.setAlignment(Pos.CENTER);
            BackgroundFill backgroundFill = new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(backgroundFill);
            vBox.setBackground(background);
            Scene stseen2 = new Scene(vBox, 600, 300);
            nimi.setScene(stseen2);
            nimi.show();

            // sisestatud andmete väärtustamine
            textField.setOnAction(e -> {
                //mangijaNimi = textField.getText();
            });
            textField2.setOnAction(e -> {
                // mangijaNupp = textField2.getText();
            });

            // mängijate loomine
            Mangija arvuti = new Mangija("Arvuti", "◙");
            //Mangija inimene = new Mangija(mangijaNimi, mangijaNupp);


            // nupu vajutamisel
            OK.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    nimi.hide();
                    Stage numbrid = new Stage();

                    // ridade arvu sisestamine, kust edasi peab hetkel liikuma ise hiirega
                    Label read = new Label("Sisestage soovitud mängulaua ridade arv, tavamängus 6: ");
                    read.setTextFill(Color.GOLD);
                    TextField ridade = new TextField();
                    ridade.setPrefColumnCount(20);
                    // ridade arvu väärtustamine
                    int ridadeArv = Integer.parseInt(ridade.getText());

                    // veergude arvu sisestamine, kust edasi peab hetkel liikuma ise hiirega
                    Label veerud = new Label("Sisestage soovitud mängulaua veergude arv, tavamängus 7: ");
                    veerud.setTextFill(Color.GOLD);
                    TextField veergude = new TextField();
                    veergude.setPrefColumnCount(20);
                    // veergude arvu väärtustamine
                    int veergudeArv = Integer.parseInt(veergude.getText());

                    // võidutingimuse sisestamine, kust edasi ei ole hetkel midagi
                    Label voidutingimus = new Label("Sisestage soovitud võidutingimus, tavamängus 4:");
                    voidutingimus.setTextFill(Color.GOLD);
                    TextField voit = new TextField();
                    // võidutigimuse väärtustamine
                    int voiduTingimus = Integer.parseInt(voit.getText());

                    // paigutus
                    HBox hbox1 = new HBox(read, ridade);
                    hbox1.setAlignment(Pos.CENTER);
                    hbox1.setSpacing(20);
                    HBox hbox2 = new HBox(veerud, veergude);
                    hbox2.setAlignment(Pos.CENTER);
                    hbox2.setSpacing(20);
                    HBox hbox3 = new HBox(voidutingimus, voit);
                    hbox3.setAlignment(Pos.CENTER);
                    hbox3.setSpacing(20);
                    VBox vBox = new VBox(hbox1, hbox2, hbox3);
                    vBox.setBackground(background);
                    vBox.setAlignment(Pos.CENTER);
                    vBox.setSpacing(50);
                    Scene stseen3 = new Scene(vBox, 600, 300);
                    numbrid.setScene(stseen3);
                    numbrid.show();

                    // mängulaua loomine
                    Maatriks laud = new Maatriks(ridadeArv,veergudeArv, voiduTingimus);
                }
            });
        });

        VBox vBox = new VBox(pealkiri,sissejuhatus, startButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);

        Scene scene = new Scene(vBox,1000,600);
        BackgroundFill backgroundFill = new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        vBox.setBackground(background);

        peaLava.setTitle("Connect Four");
        peaLava.setScene(scene);
        peaLava.setResizable(false);
        peaLava.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
