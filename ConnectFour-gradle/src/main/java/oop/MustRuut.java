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
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Light;
import javafx.animation.TranslateTransition;
import javafx.geometry.Point2D;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class MustRuut extends Application {

    private static final int TILE_SIZE = 80;
    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    private boolean redMove = true;
    private Nupp[][] ruudustik = new Nupp[COLUMNS][ROWS];
    private Pane nuppJuur = new Pane();

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
                    Maatriks laud = new Maatriks(ridadeArv, veergudeArv, voiduTingimus);
                }
            });
        });

        VBox vBox = new VBox(pealkiri, sissejuhatus, startButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);

        Scene scene = new Scene(vBox, 1000, 600);
        BackgroundFill backgroundFill = new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        vBox.setBackground(background);

        peaLava.setTitle("Connect Four");
        peaLava.setScene(scene);
        peaLava.setResizable(false);
        peaLava.show();

        // SIIT HAKKAB MÄNGULAUD
        peaLava.setScene(new Scene(looSisu()));
        peaLava.show();
    }

    private Parent looSisu() {
        Pane juur = new Pane();
        juur.getChildren().add(nuppJuur);

        Shape ruudustik = looRuudustik();
        juur.getChildren().add(ruudustik);
        juur.getChildren().addAll(looVeerud());

        return juur;
    }

    private Shape looRuudustik() {
        Shape kujund = new Rectangle((COLUMNS + 1) * TILE_SIZE, (ROWS + 1) * TILE_SIZE);
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLUMNS; x++) {
                Circle ring = new Circle(TILE_SIZE / 2);
                ring.setCenterX(TILE_SIZE / 2);
                ring.setCenterY(TILE_SIZE / 2);
                ring.setTranslateX(x * (TILE_SIZE + 5) + TILE_SIZE / 4);
                ring.setTranslateY(y * (TILE_SIZE + 5) + TILE_SIZE / 4);

                kujund = Shape.subtract(kujund, ring);
            }
        }
        Light.Distant valgus = new Light.Distant();
        valgus.setAzimuth(45.0);
        valgus.setElevation(30.0);

        Lighting valgustus = new Lighting();
        valgustus.setLight(valgus);
        valgustus.setSurfaceScale(5.0);

        kujund.setFill(Color.BLUE);
        kujund.setEffect(valgustus);

        return kujund;
    }

    private List<Rectangle> looVeerud() {
        List<Rectangle> list = new ArrayList<>();
        for (int x = 0; x < COLUMNS; x++) {
            Rectangle ristkülik = new Rectangle(TILE_SIZE, (ROWS + 1) * TILE_SIZE);
            ristkülik.setTranslateX(x * (TILE_SIZE + 5) + TILE_SIZE / 4);
            ristkülik.setFill(Color.TRANSPARENT);

            ristkülik.setOnMouseEntered(e -> ristkülik.setFill(Color.rgb(200, 200, 50, 0.3)));
            ristkülik.setOnMouseExited(e -> ristkülik.setFill(Color.TRANSPARENT));

            final int veerg = x;
            ristkülik.setOnMouseClicked(e -> lisaNupp(new Nupp(redMove), veerg));

            list.add(ristkülik);
        }
        return list;
    }

    private void lisaNupp(Nupp nupp, int column) {
        int row = ROWS - 1;
        do {
            if (!getNupp(column, row).isPresent()) {
                break;
            }
            row--;
        } while (row >= 0);

        if (row < 0) {
            return;
        }

        ruudustik[column][row] = nupp;
        nuppJuur.getChildren().add(nupp);
        nupp.setTranslateX(column * (TILE_SIZE + 5) + TILE_SIZE / 4);

        final int praeguneRida = row;

        TranslateTransition animatsioon = new TranslateTransition(Duration.seconds(0.5), nupp);
        animatsioon.setToY(row * (TILE_SIZE + 5) + TILE_SIZE / 4);
        animatsioon.setOnFinished(e -> {
            if (mangLopetatud(column, praeguneRida)) { //gameended
                mangLabi(); //gameover
            }
            redMove = !redMove;
        });
        animatsioon.play();
    }

    private boolean mangLopetatud(int column, int row) {
        List<Point2D> vertikaalne = IntStream.rangeClosed(row - 3, row + 3)
                .mapToObj(r -> new Point2D(column, r))
                .collect(Collectors.toList());

        List<Point2D> horisontaalne = IntStream.rangeClosed(column - 3, column + 3)
                .mapToObj(c -> new Point2D(c, row))
                .collect(Collectors.toList());

        Point2D topLeft = new Point2D(column - 3, row - 3);
        List<Point2D> diagonaal1 = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> topLeft.add(i, i))
                .collect(Collectors.toList());

        Point2D botLeft = new Point2D(column - 3, row - 3);
        List<Point2D> diagonaal2 = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> botLeft.add(i, -i))
                .collect(Collectors.toList());
        return kontrolliVahemik(vertikaalne) || kontrolliVahemik(horisontaalne)
                || kontrolliVahemik(diagonaal1) || kontrolliVahemik(diagonaal2);
    }

    private boolean kontrolliVahemik(List<Point2D> punktid) {
        int ahel = 0;
        for (Point2D p : punktid) {
            int column = (int) p.getX();
            int row = (int) p.getY();

            Nupp nupp = getNupp(column, row).orElse(new Nupp(!redMove));
            if (nupp.red == redMove) {
                ahel++;
                if (ahel == 4) {
                    return true;
                }
            } else {
                ahel = 0;
            }
        }
        return false;
    }

    private void mangLabi() {
        System.out.println("Võitja: " + (redMove ? "punane" : "kollane"));
    }

    private Optional<Nupp> getNupp(int column, int row) {
        if (column < 0 || column >= COLUMNS
                || row < 0 || row >= ROWS) {
            return Optional.empty();
        }
        return Optional.ofNullable(ruudustik[column][row]);
    }

    private static class Nupp extends Circle {
        private final boolean red;

        public Nupp(boolean red) {
            super(TILE_SIZE / 2, red ? Color.RED : Color.YELLOW);
            this.red = red;

            setCenterX(TILE_SIZE / 2);
            setCenterY(TILE_SIZE / 2);
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
