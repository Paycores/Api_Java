package lib.order;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.concurrent.Worker;
import javafx.concurrent.Worker.State;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by paycores.com on 18/12/17.
 *
 * Esta clase se creo para poder embeber la pagina que contiene el script del firgerprint
 * y poderse ejecutar en segundo plato
 */
public class PayCoresExecuteScript extends Application {

    /**
     * @param paycores_purchaseCode - lo usamos para crear la ruta correcta a la pagina
     */
    private static String paycores_purchaseCode = "";

    /**
     * @param webview - se usa para crear una vista web
     */
    private static WebView webView;

    /**
     * @param webEngine - este objeto es un motor de ejecuciones sobre la vista grafica webView
     */
    private WebEngine webEngine;


    /**
     * Metodo propio de la clase application donde se ejecuta lo que inicializa la pagina
     * y el metodo loadPage que ejecuta el script
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        loadPage();

        StackPane root = new StackPane();
        HBox hh = new HBox();
        hh.getChildren().add(webView);
        hh.setVisible(false);
        root.getChildren().add(hh);
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Page Script");
        primaryStage.setScene(scene);
        primaryStage.hide();


        //Este metodo escuchara cuando se carga la pagina y la cierra

        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
                    @Override
                    public void changed(ObservableValue ov, State oldState, State newState) {
                        if (newState == Worker.State.SUCCEEDED) {
                            System.out.println("La pagina cargo correctamente");
                            stop();
                        }

                    }
                });

    }


    /**
     * Este metodo lo usamos para detener el webview
     */
    @Override
    public void stop() {
        Platform.exit();
    }

    /**
     * Este metodo se encarga de inicilizar el webView y cargar la pagina, no visible para que se ejecute el script
     */
    private void loadPage() {
        try {
            webView = new WebView();
            webView.setVisible(false);
            webEngine = webView.getEngine();
            webEngine.setJavaScriptEnabled(true);


            // TODO:  OJOOO REVISAR EL SERVIDOR
            System.setProperty("jsse.enableSNIExtension", "false");

            java.net.URLConnection conectionPage = new java.net.URL("https://business.paycores.com/business-tools/generateFingerprint/" + paycores_purchaseCode).openConnection();
            //java.net.URLConnection conectionPage = new java.net.URL("https://stackoverflow.com/questions/14029964/execute-a-javascript-function-for-a-webview-from-a-javafx-program").openConnection();
            //URL conectionPage = new URL("https://business.paycores.com/business-tools/generateFingerprint/"+paycores_purchaseCode);
            webEngine.load(conectionPage.getURL().toExternalForm());
        } catch (Exception ex) {
            System.err.print("error " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * este metodo se debio reliazar para poder lanzar el metodo launch propio de la clase Application
     * ya que no permite ser lanzado en su contructor
     *
     * @param purchaseCode - purchaseCode sacado del servicio que genera el firgenprint necesario para
     *                     cargar la pagina donde esta el script
     */
    public void startEngine(String purchaseCode) {
        this.paycores_purchaseCode = purchaseCode;
        launch(PayCoresExecuteScript.class);
    }
}
