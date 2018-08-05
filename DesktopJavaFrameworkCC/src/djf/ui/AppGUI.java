package djf.ui;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;
import djf.controller.AppFileController;
import djf.AppTemplate;
import djf.components.AppWorkspaceComponent;
import static djf.settings.AppPropertyType.*;
import static djf.settings.AppStartupConstants.CLASS_CODECHECK;
import static djf.settings.AppStartupConstants.CLASS_PROMPT_LABEL;
import static djf.settings.AppStartupConstants.CLASS_PROMPT_LABEL2;
import static djf.settings.AppStartupConstants.FILE_PROTOCOL;
import static djf.settings.AppStartupConstants.PATH_IMAGES;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.FileUtils;
//import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * This class provides the basic user interface for this application, including
 * all the file controls, but not including the workspace, which would be
 * customly provided for each app.
 *
 * @author Richard McKenna
 * @version 1.0
 */
public class AppGUI {

    // THIS HANDLES INTERACTIONS WITH FILE-RELATED CONTROLS
    protected AppFileController fileController;

    // THIS IS THE APPLICATION WINDOW
    protected Stage primaryStage;

    // THIS IS THE STAGE'S SCENE GRAPH
    protected Scene primaryScene;

    // THIS PANE ORGANIZES THE BIG PICTURE CONTAINERS FOR THE
    // APPLICATION AppGUI. NOTE THAT THE WORKSPACE WILL GO
    // IN THE CENTER REGION OF THE appPane
    protected BorderPane appPane;

    // THIS IS THE TOP PANE WHERE WE CAN PUT TOOLBAR
    protected FlowPane topToolbarPane;

    // THIS IS THE FILE TOOLBAR AND ITS CONTROLS
    protected FlowPane fileToolbar;

    // FILE TOOLBAR BUTTONS
    protected Button newButton;
    protected Button loadButton;
    protected Button renameButton;
    protected Button aboutButton;
    //protected Button actualSaveButton;

    // THIS DIALOG IS USED FOR GIVING FEEDBACK TO THE USER
    protected AppYesNoCancelDialogSingleton yesNoCancelDialog;

    // THIS TITLE WILL GO IN THE TITLE BAR
    protected String appTitle;

    protected BorderPane welcomePane; //added
    protected VBox recentWorks;
    protected Label worksLabel;
    protected BorderPane welcomeTag;
    protected Label welcome;
    protected Label codeCheckLabel;
    protected Hyperlink createNew;
    protected BorderPane topPane;
    //protected Stage welcomeStage;
    //protected Scene welcomeScene;
    protected Button xButton;
    protected HBox test1;
    protected HBox test2;
    protected Button newXButton;
    protected String codeCheckName;
    int counter = 0;
    public ArrayList<String> names;
    int bad = 0;
    File global;
    static final String JSON_NAME = "name";
    static final String JSON_PATH = "path";
    static final String JSON_RECENTS = "recents";

    /**
     * This constructor initializes the file toolbar for use.
     *
     * @param initPrimaryStage The window for this application.
     *
     * @param initAppTitle The title of this application, which will appear in
     * the window bar.
     *
     * @param app The app within this gui is used.
     */
    public AppGUI(Stage initPrimaryStage,
            String initAppTitle,
            AppTemplate app) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException, URISyntaxException {
        // SAVE THESE FOR LATER
        primaryStage = initPrimaryStage;
        appTitle = initAppTitle;

        // INIT THE TOOLBAR
        //       initTopToolbar(app);
        // AND FINALLY START UP THE WINDOW (WITHOUT THE WORKSPACE)
        initWindow(app);

        welcomeToCodeCheck(app);
        // INIT THE STYLESHEET AND THE STYLE FOR THE FILE TOOLBAR
        //initStylesheet(app);                                          //change later if needed
        //initFileToolbarStyle();        
    }

    /**
     * Accessor method for getting the file toolbar controller.
     */
    public AppFileController getFileController() {
        return fileController;
    }

    /**
     * Accessor method for getting the application pane, within which all user
     * interface controls are ultimately placed.
     *
     * @return This application GUI's app pane.
     */
    public BorderPane getAppPane() {
        return appPane;
    }

    /**
     * Accessor method for getting the toolbar pane in the top, within which
     * other toolbars are placed.
     *
     * @return This application GUI's app pane.
     */
    public FlowPane getTopToolbarPane() {
        return topToolbarPane;
    }

    /**
     * Accessor method for getting the file toolbar pane, within which all file
     * controls are ultimately placed.
     *
     * @return This application GUI's app pane.
     */
    public FlowPane getFileToolbar() {
        return fileToolbar;
    }

    /**
     * Accessor method for getting this application's primary stage's, scene.
     *
     * @return This application's window's scene.
     */
    public Scene getPrimaryScene() {
        return primaryScene;
    }

    /**
     * Accessor method for getting this application's window, which is the
     * primary stage within which the full GUI will be placed.
     *
     * @return This application's primary stage (i.e. window).
     */
    public Stage getWindow() {
        return primaryStage;
    }

    /**
     * This method is used to activate/deactivate toolbar buttons when they can
     * and cannot be used so as to provide foolproof design.
     *
     * @param saved Describes whether the loaded Page has been saved or not.
     */
    public void updateToolbarControls(boolean saved) {
        // THIS TOGGLES WITH WHETHER THE CURRENT COURSE
        // HAS BEEN SAVED OR NOT
//        actualSaveButton.setDisable(true);
//        saveButton.setDisable(saved);

        // ALL THE OTHER BUTTONS ARE ALWAYS ENABLED
        // ONCE EDITING THAT FIRST COURSE BEGINS
        newButton.setDisable(false);
        loadButton.setDisable(false);
        //exitButton.setDisable(false);

        // NOTE THAT THE NEW, LOAD, AND EXIT BUTTONS
        // ARE NEVER DISABLED SO WE NEVER HAVE TO TOUCH THEM
    }

    public BorderPane returnTopPane() {
        return topPane;
    }

    public BorderPane returnWelcomePane() {
        return welcomePane;
    }

    public String getCodeCheckName() {
        return codeCheckName;
    }

    public void setName(String name) {
        codeCheckName = name;
    }

    public Label returnWelcomeLabel() {
        return welcome;
    }
    public void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException, URISyntaxException {

//        Media media; //replace /Movies/test.mp3 with your file
//        media = new Media(getClass().getResource("./work/Elevator-music.mp3").toURI().toString());
//       MediaPlayer player = new MediaPlayer(media); 
//       player.play();
    }

    private void welcomeToCodeCheck(AppTemplate app) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException, URISyntaxException {

        PropertiesManager props = PropertiesManager.getPropertiesManager();
        //welcomePane = new BorderPane();
        recentWorks = new VBox();
        worksLabel = new Label(props.getProperty(RECENTWORKS_TEXT));

        worksLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        welcomeTag = new BorderPane();
        welcome = new Label(props.getProperty(WELCOME_TEXT));
        welcome.getStyleClass().add(CLASS_PROMPT_LABEL2);
        createNew = new Hyperlink(props.getProperty(HYPERLINK_TEXT));
        topPane = new BorderPane();
        xButton = new Button();
        newXButton = new Button();
        test1 = new HBox();
        test2 = new HBox();
        codeCheckLabel = new Label(props.getProperty(LOGO_TEXT));
        codeCheckLabel.getStyleClass().add(CLASS_CODECHECK);
        test1.getChildren().add(codeCheckLabel);
        test2.getChildren().add(createNew);

        topPane.setLeft(welcome);
        topPane.setRight(xButton);
        xButton.setText(props.getProperty(X_TEXT));
        Tooltip hi = new Tooltip("Close welcome screen");
        xButton.setTooltip(hi);
        newXButton.setText(props.getProperty(X_TEXT));
        Tooltip exit = new Tooltip("Exit Code Check");
        newXButton.setTooltip(exit);

        recentWorks.getChildren().add(worksLabel);
        recentWorks.getStyleClass().add(CLASS_BORDERED_PANE);
        // fileController.loadRecents("./work/Files.json", recentWorks);
        fileController = new AppFileController(app);
        loadRecents(app);
        welcomeTag.getStyleClass().add(CLASS_BORDERED_PANE);
        topPane.getStyleClass().add(CLASS_BORDERED_PANE);

        test1.setAlignment(Pos.CENTER);
        test2.setAlignment(Pos.CENTER);
        welcomeTag.setTop(test1);
        welcomeTag.setBottom(test2);

        appPane.setTop(topPane);
        appPane.setCenter(welcomeTag);
        appPane.setLeft(recentWorks);
        names = new ArrayList<>();

        //welcomeScene= new Scene(welcomePane,700,700);
        initStylesheet(app);
        music();

        //primaryStage.setScene(welcomeScene);
        xButton.setOnAction(e -> {

            appPane.getChildren().remove(welcomeTag);
            appPane.getChildren().remove(recentWorks);
            try {
                initTopToolbar(app);
            } catch (IOException ex) {
                Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            initFileToolbarStyle();
            topPane.getChildren().remove(xButton);
            topPane.setRight(newXButton);
            app.buildAppComponentsHook();

        });

        createNew.setOnAction(e -> {
            //counter++;

            TextInputDialog name = new TextInputDialog();
            name.setHeaderText(null);
            name.setTitle("Code Check name");
            name.setContentText("Enter a name for your new Code Check (alphanumeric characters only and no spaces):");
            Optional<String> title = name.showAndWait();
            String answer = "";

            answer = title.toString();
            answer = title.toString().substring(9, answer.length() - 1);

            if (answer.equals("")) {
                Alert myAlert = new Alert(AlertType.ERROR);
                myAlert.setHeaderText(null);
                myAlert.setTitle("Error");
                myAlert.setContentText("You didn't put a name for your Code Check, try again");
                myAlert.showAndWait();
            }
            if (answer.equals("empt")) {
                Alert myAlert = new Alert(AlertType.ERROR);
                myAlert.setHeaderText(null);
                myAlert.setTitle("cancelled");
                myAlert.setContentText("You cancelled creating new");
                myAlert.showAndWait();
            }
            else{

            if (!names.isEmpty()) {
                for (int i = 0; i <= names.size() - 1; i++) {
                    if (answer.equals(names.get(i))) { 
                        Alert myAlert = new Alert(AlertType.ERROR);
                        myAlert.setHeaderText(null);
                        myAlert.setTitle("Error");
                        myAlert.setContentText("The name you entered already exists for a Code Check, try again");
                        myAlert.showAndWait();
                    }
                }
            } else if (!StringUtils.isAlphanumeric(answer)) {

                Alert myAlert = new Alert(AlertType.ERROR);
                myAlert.setHeaderText(null);
                myAlert.setTitle("Error");
                myAlert.setContentText("Not a valid name for your Code Check, try again");
                myAlert.showAndWait();
            } else {

                codeCheckName = answer;
                //String p=System.getProperty("user.dir");
                //System.out.println(p);
                File fileToMake = new File("./work/" + codeCheckName);
                if (fileToMake.isDirectory()) {

                    Alert myAlert = new Alert(AlertType.ERROR);
                    myAlert.setHeaderText(null);
                    myAlert.setTitle("Error");
                    myAlert.setContentText("The name you entered already exists for a Code Check, try again");
                    myAlert.showAndWait();
                } else {
                    names.add(codeCheckName);

                    Alert myAlert = new Alert(AlertType.INFORMATION);
                    myAlert.setHeaderText(null);
                    myAlert.setTitle("Code Check title");
                    myAlert.setContentText("the name of your Code Check will be " + answer);
                    myAlert.showAndWait();

                    global = fileToMake;
                    //File fileToMake = new File("/Users/joelgeorge/Desktop/219Project/the project/CodeCheckerCreator/work/"+codeCheckName);
                    File fileBB = new File("./work/" + codeCheckName + "/Blackboard");
                    File fileSub = new File("./work/" + codeCheckName + "/Submissions");
                    File fileProj = new File("./work/" + codeCheckName + "/Projects");
                    File fileSourceC = new File("./work/" + codeCheckName + "/SourceCode");
                    try {
                        FileUtils.forceMkdir(fileToMake);
                        FileUtils.forceMkdir(fileBB);
                        FileUtils.forceMkdir(fileSub);
                        FileUtils.forceMkdir(fileProj);
                        FileUtils.forceMkdir(fileSourceC);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    appPane.getChildren().remove(welcomeTag);
                    appPane.getChildren().remove(recentWorks);

                    try {
                        initTopToolbar(app);
                    } catch (IOException ex) {
                        Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    initFileToolbarStyle();
                    topPane.getChildren().remove(xButton);
                    topPane.setRight(newXButton);
                    app.buildAppComponentsHook();
                    renameButton.setDisable(false);
                    fileController.handleNewRequest();
                    welcome.setText(codeCheckName);
                }

            }
            }
        });

        primaryStage.setOnCloseRequest(e -> {
            //fileController.handleWindowExit();
            Alert myAlert = new Alert(AlertType.CONFIRMATION);
            myAlert.setHeaderText(null);
            myAlert.setTitle("Trying to exit");
            myAlert.setContentText("Are you 100% sure you want to exit? ");
            myAlert.showAndWait();

            Optional<ButtonType> action = myAlert.showAndWait();
            if (action.get() == ButtonType.YES) {
                System.exit(0);
            } else if (action.get() == ButtonType.CANCEL) {
                e.consume();
            }

        });

    }

    /**
     * *************************************************************************
     */
    /* BELOW ARE ALL THE PRIVATE HELPER METHODS WE USE FOR INITIALIZING OUR AppGUI */
    /**
     * *************************************************************************
     */
    /**
     * This function initializes all the buttons in the toolbar at the top of
     * the application window. These are related to file management.
     */
    private void initTopToolbar(AppTemplate app) throws IOException {
        fileToolbar = new FlowPane();

        // HERE ARE OUR FILE TOOLBAR BUTTONS, NOTE THAT SOME WILL
        // START AS ENABLED (false), WHILE OTHERS DISABLED (true)
        newButton = initChildButton(fileToolbar, NEW_ICON.toString(), NEW_TOOLTIP.toString(), false);
        loadButton = initChildButton(fileToolbar, LOAD_ICON.toString(), LOAD_TOOLTIP.toString(), false);
        renameButton = initChildButton(fileToolbar, RENAME_ICON.toString(), RENAME_TOOLTIP.toString(), true);
        aboutButton = initChildButton(fileToolbar, ABOUT_ICON.toString(), REAL_SAVE_TOOLTIP.toString(), false);
        //exitButton = initChildButton(fileToolbar,	EXIT_ICON.toString(),	    EXIT_TOOLTIP.toString(),	false);

        // AND NOW SETUP THEIR EVENT HANDLERS
        //fileController = new AppFileController(app);
        //loadRecents("./work/Files.json");
        newButton.setOnAction(e -> {

            TextInputDialog name = new TextInputDialog();
            name.setHeaderText(null);
            name.setTitle("Code Check name");
            name.setContentText("Enter a name for your new Code Check (alphanumeric characters only and no spaces):");
            Optional<String> title = name.showAndWait();
            String answer = "";

            answer = title.toString();
            answer = title.toString().substring(9, answer.length() - 1);
            bad = 0;

            if (answer.equals("")) {
                Alert myAlert = new Alert(AlertType.ERROR);
                myAlert.setHeaderText(null);
                myAlert.setTitle("Error");
                myAlert.setContentText("You didn't put a name for your Code Check, try again");
                myAlert.showAndWait();
            }
            if (answer.equals("empt")) {
                Alert myAlert = new Alert(AlertType.ERROR);
                myAlert.setHeaderText(null);
                myAlert.setTitle("cancelled");
                myAlert.setContentText("You cancelled creating new");
                myAlert.showAndWait();
            }
            else{
            if (!StringUtils.isAlphanumeric(answer)) {

                Alert myAlert = new Alert(AlertType.ERROR);
                myAlert.setHeaderText(null);
                myAlert.setTitle("Error");
                myAlert.setContentText("Not a valid name for your Code Check, try again");
                myAlert.showAndWait();
            } else if (names.isEmpty()) {

                codeCheckName = answer;

                File fileToMake = new File("./work/" + codeCheckName);
                if (fileToMake.isDirectory()) {

                    Alert myAlert = new Alert(AlertType.ERROR);
                    myAlert.setHeaderText(null);
                    myAlert.setTitle("Error");
                    myAlert.setContentText("The name you entered already exists for a Code Check, try again");
                    myAlert.showAndWait();

                } else {

                    names.add(codeCheckName);
                    global = fileToMake;
                    Alert myAlert = new Alert(AlertType.INFORMATION);
                    myAlert.setHeaderText(null);
                    myAlert.setTitle("Code Check title");
                    myAlert.setContentText("the name of your Code Check will be " + answer);
                    myAlert.showAndWait();

                    //File fileToMake = new File("/Users/joelgeorge/Desktop/219Project/the project/CodeCheckerCreator/work/"+codeCheckName);
                    File fileBB = new File("./work/" + codeCheckName + "/Blackboard");
                    File fileSub = new File("./work/" + codeCheckName + "/Submissions");
                    File fileProj = new File("./work/" + codeCheckName + "/Projects");
                    File fileSourceC = new File("./work/" + codeCheckName + "/SourceCode");

                    try {
                        FileUtils.forceMkdir(fileToMake);
                        FileUtils.forceMkdir(fileBB);
                        FileUtils.forceMkdir(fileSub);
                        FileUtils.forceMkdir(fileProj);
                        FileUtils.forceMkdir(fileSourceC);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    appPane.getChildren().remove(welcomeTag);
                    appPane.getChildren().remove(recentWorks);

                    fileController.handleNewRequest();
                    renameButton.setDisable(false);
                    welcome.setText(codeCheckName);
                }

            } else if (!names.isEmpty()) {
                for (int i = 0; i <= names.size() - 1; i++) {
                    if (answer.equals(names.get(i))) {
                        bad++;
                        Alert myAlert = new Alert(AlertType.ERROR);
                        myAlert.setHeaderText(null);
                        myAlert.setTitle("Error");
                        myAlert.setContentText("The name you entered already exists for a Code Check, try again");
                        myAlert.showAndWait();
                    }

                }
                if (bad == 0) {

                    File fileToMake = new File("./work/" + codeCheckName);
                    if (fileToMake.isDirectory()) {
                        Alert myAlert = new Alert(AlertType.ERROR);
                        myAlert.setHeaderText(null);
                        myAlert.setTitle("Error");
                        myAlert.setContentText("The name you entered already exists for a Code Check, try again");
                        myAlert.showAndWait();
                    } else {
                        codeCheckName = answer;
                        names.add(codeCheckName);

                        Alert myAlert = new Alert(AlertType.INFORMATION);
                        myAlert.setHeaderText(null);
                        myAlert.setTitle("Code Check title");
                        myAlert.setContentText("the name of your Code Check will be " + answer);
                        myAlert.showAndWait();

                        //File fileToMake = new File("/Users/joelgeorge/Desktop/219Project/the project/CodeCheckerCreator/work/"+codeCheckName);
                        File fileBB = new File("./work/" + codeCheckName + "/Blackboard");
                        File fileSub = new File("./work/" + codeCheckName + "/Submissions");
                        File fileProj = new File("./work/" + codeCheckName + "/Projects");
                        File fileSourceC = new File("./work/" + codeCheckName + "/SourceCode");
                        try {
                            FileUtils.forceMkdir(fileToMake);
                            FileUtils.forceMkdir(fileBB);
                            FileUtils.forceMkdir(fileSub);
                            FileUtils.forceMkdir(fileProj);
                            FileUtils.forceMkdir(fileSourceC);

                        } catch (IOException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        appPane.getChildren().remove(welcomeTag);
                        appPane.getChildren().remove(recentWorks);
                        renameButton.setDisable(false);

                        fileController.handleNewRequest();
                        welcome.setText(codeCheckName);
                    }

                }
            }
           }

        });

        loadButton.setOnAction(e -> {
            fileController.handleLoadRequest();
            renameButton.setDisable(false);

            //saveButton.setDisable(false);
        });

        renameButton.setOnAction(e -> {

            TextInputDialog name = new TextInputDialog();
            name.setHeaderText(null);
            name.setTitle("Renaming your Code Check");
            name.setContentText("Enter a name for your new Code Check (alphanumeric characters only and no spaces):");
            Optional<String> title = name.showAndWait();
            String answer = "";

            if (title.isPresent()) {

                answer = title.toString();
                answer = title.toString().substring(9, answer.length() - 1);

                if (answer.equals("")) {
                    Alert myAlert = new Alert(AlertType.ERROR);
                    myAlert.setHeaderText(null);
                    myAlert.setTitle("Error");
                    myAlert.setContentText("You didn't put a name for your Code Check, try again");
                    myAlert.showAndWait();
                } else {

                    if (StringUtils.isAlphanumeric(answer)) {//if it's alphanumeric
                        File renamedFile = new File("./work/" + answer);
                        if (renamedFile.isDirectory()) {

                            Alert myAlert = new Alert(AlertType.ERROR);
                            myAlert.setHeaderText(null);
                            myAlert.setTitle("Error");
                            myAlert.setContentText("The name you entered already exists for a Code Check, try again");
                            myAlert.showAndWait();

                        } else {
                            Path myPath = Paths.get("./work/" + codeCheckName);
                            try {
                                Files.move(myPath, myPath.resolveSibling("./work/" + answer));
                            } catch (IOException ex) {
                                Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Alert myAlert = new Alert(AlertType.INFORMATION);
                            myAlert.setHeaderText(null);
                            myAlert.setTitle("Code Check title");
                            myAlert.setContentText("the name of your Code Check is " + answer);
                            myAlert.showAndWait();
                            codeCheckName = answer;

                            welcome.setText(codeCheckName);
                        }
                    } else {

                        Alert myAlert = new Alert(AlertType.ERROR);
                        myAlert.setHeaderText(null);
                        myAlert.setTitle("Error");
                        myAlert.setContentText(answer + " is not a valid name for a Code Check, try again");
                        myAlert.showAndWait();

                    }
                }

            }

        });

        aboutButton.setOnAction(e -> {

            Alert myAlert = new Alert(AlertType.INFORMATION);
            myAlert.setHeaderText(null);
            myAlert.setTitle("About Code Check");
            myAlert.setContentText("This application is called Code Check. It was designed in 2017 to help"
                    + " grading teacher assisants speed up the grading process. This specific application was created"
                    + " by a student named Joel George.");

            myAlert.showAndWait();

        });

        newXButton.setOnAction(e -> {
            //System.exit(0);
            fileController.handleExitRequest();

        });

        // NOW PUT THE FILE TOOLBAR IN THE TOP TOOLBAR, WHICH COULD
        // ALSO STORE OTHER TOOLBARS
        topToolbarPane = new FlowPane();
        topToolbarPane.getChildren().add(fileToolbar);
        topPane.setBottom(topToolbarPane);
        //app.returnTopPane().getStyleClass().add(CLASS_BORDERED_PANE);
    }

    public Button returnNewButton() {
        return newButton;
    }

    public Button returnLoadButton() {
        return loadButton;
    }

    // INITIALIZE THE WINDOW (i.e. STAGE) PUTTING ALL THE CONTROLS
    // THERE EXCEPT THE WORKSPACE, WHICH WILL BE ADDED THE FIRST
    // TIME A NEW Page IS CREATED OR LOADED
    private void initWindow(AppTemplate app) {
        // SET THE WINDOW TITLE
        primaryStage.setTitle(appTitle);

        // GET THE SIZE OF THE SCREEN
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        // AND USE IT TO SIZE THE WINDOW
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        // ADD THE TOOLBAR ONLY, NOTE THAT THE WORKSPACE
        // HAS BEEN CONSTRUCTED, BUT WON'T BE ADDED UNTIL
        // THE USER STARTS EDITING A COURSE
        appPane = new BorderPane(); //base pane
        //appPane.setTop(app.returnTopPane());
        primaryScene = new Scene(appPane);

        // NOW TIE THE SCENE TO THE WINDOW
        primaryStage.setScene(primaryScene);

    }

    /**
     * This is a public helper method for initializing a simple button with an
     * icon and tooltip and placing it into a toolbar.
     *
     * @param toolbar Toolbar pane into which to place this button.
     *
     * @param icon Icon image file name for the button.
     *
     * @param tooltip Tooltip to appear when the user mouses over the button.
     *
     * @param disabled true if the button is to start off disabled, false
     * otherwise.
     *
     * @return A constructed, fully initialized button placed into its
     * appropriate pane container.
     */
    public Button initChildButton(Pane toolbar, String icon, String tooltip, boolean disabled) {
        PropertiesManager props = PropertiesManager.getPropertiesManager();

        // LOAD THE ICON FROM THE PROVIDED FILE
        //String imagePath = FILE_PROTOCOL + PATH_IMAGES + props.getProperty(icon);
        //Image buttonImage = new Image(imagePath);
        // NOW MAKE THE BUTTON
        Button button = new Button(props.getProperty(icon));
        button.setDisable(disabled);
        //button.setGraphic(new ImageView(buttonImage));
        Tooltip buttonTooltip = new Tooltip(props.getProperty(tooltip));
        button.setTooltip(buttonTooltip);

        // PUT THE BUTTON IN THE TOOLBAR
        toolbar.getChildren().add(button);

        // AND RETURN THE COMPLETED BUTTON
        return button;
    }

    /**
     * Note that this is the default style class for the top file toolbar and
     * that style characteristics for this type of component should be put
     * inside app_properties.xml.
     */
    public static final String CLASS_BORDERED_PANE = "bordered_pane";
    public static final String CLASS_BORDERED_PANE2 = "bordered_pane2";
    /**
     * Note that this is the default style class for the file buttons in the top
     * file toolbar and that style characteristics for this type of component
     * should be put inside app_properties.xml.
     */
    public static final String CLASS_EDIT_BUTTON = "edit_button";

    /**
     * This function sets up the stylesheet to be used for specifying all style
     * for this application. Note that it does not attach CSS style classes to
     * controls, that must be done separately.
     */
    private void initStylesheet(AppTemplate app) {
        // SELECT THE STYLESHEET
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        String stylesheet = props.getProperty(APP_PATH_CSS2);
        stylesheet += props.getProperty(APP_CSS2);
        Class appClass = app.getClass();
        URL stylesheetURL = appClass.getResource(stylesheet);
        String stylesheetPath = stylesheetURL.toExternalForm();
        primaryScene.getStylesheets().add(stylesheetPath);
    }

    /**
     * This function specifies the CSS style classes for the controls managed by
     * this framework.
     */
    private void initFileToolbarStyle() {
        //topToolbarPane.getStyleClass().add(CLASS_BORDERED_PANE);
        fileToolbar.getStyleClass().add(CLASS_BORDERED_PANE);
        newButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        loadButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        renameButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        aboutButton.getStyleClass().add(CLASS_EDIT_BUTTON);

    }

    public void loadRecents(AppTemplate app) throws IOException {

        File folderToGet = new File("./work");
        File[] allTheShit = folderToGet.listFiles();

        ArrayList<File> temp1 = new ArrayList<>();
        ArrayList<File> sortedFiles = new ArrayList<>();

        for (int i = 0; i < allTheShit.length; i++) { //adds all the files to an ArrayList for convience
            temp1.add(allTheShit[i]);
        }

        while (!temp1.isEmpty()) { //sorts the list

            File min = temp1.get(0);
            for (int i = 0; i < temp1.size(); i++) {

                if (temp1.get(i).lastModified() > min.lastModified()) {
                    min = temp1.get(i);
                }

                if (i == temp1.size() - 1) {
                    temp1.remove(min);
                    sortedFiles.add(min);
                }
            }
        }
        
        for(int i=0; i<sortedFiles.size(); i++){ 
            if(sortedFiles.get(i).getName().equals(".DS_Store"))
                sortedFiles.remove(i);
        }

        for (int i = 0; i < sortedFiles.size(); i++) {

            String fileName = sortedFiles.get(i).getName();
            String pathName = sortedFiles.get(i).getPath();

            if (sortedFiles.get(i).isFile()
                    && !sortedFiles.get(i).getName().endsWith(".zip")
                    && !sortedFiles.get(i).getName().endsWith(".json")
                    && !sortedFiles.get(i).getName().endsWith(".mp3")) {

                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");

                Hyperlink recent1 = new Hyperlink(fileName);
                Label recentsTime = new Label(" Last Modified: On "
                        + sdf.format(sortedFiles.get(i).lastModified()) + " at "
                        + sdf2.format(sortedFiles.get(i).lastModified()));
                HBox putIn = new HBox();

                putIn.getChildren().addAll(recent1, recentsTime);
                recentWorks.getChildren().add(putIn);

                recent1.setOnAction(e -> {
                    try {

                        initTopToolbar(app);
                        renameButton.setDisable(false);
                    } catch (IOException ex) {
                        Logger.getLogger(AppGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    initFileToolbarStyle();
                    topPane.getChildren().remove(xButton);
                    topPane.setRight(newXButton);
                    appPane.getChildren().remove(welcomeTag);
                    appPane.getChildren().remove(recentWorks);
                    app.buildAppComponentsHook();
                    fileController.openRecents(pathName);

                });

            }

        }
    }

}
