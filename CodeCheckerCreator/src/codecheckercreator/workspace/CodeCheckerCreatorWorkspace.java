/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheckercreator.workspace;

import djf.components.AppDataComponent;
import djf.components.AppWorkspaceComponent;
import javafx.scene.layout.HBox;
import codecheckercreator.CodeCheckerCreatorApp;
import static codecheckercreator.CodeCheckerCreatorProp.CCBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.CHECKBOXLABEL_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.CHECKPLABEL_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.CHOOSEB_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.CONTENTLABEL1_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.CONTENTLABEL2_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.CONTENTLABEL3_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.CONTENTLABEL4_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.CONTENTLABEL5_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.ECBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.EXTRACTBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.EXTRACTLABEL_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.FIVECOMMAND_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.FOURCOMMAND_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.FOURPLABEL_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.HOMEBUTTION_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.NEXTBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.ONECOMMAND_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.PREVBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.RBRIGHT_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.REFRESHBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.REMOVEBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.RPL_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.STEPFIVE_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.STEPFOUR_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.STEPONE_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.STEPTHREE_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.STEPTWO_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.THREECOMMAND_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.TWOCOMMAND_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.UNZIPBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.UPLABEL_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.VIEWBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.VRBUTTON_TEXT;
import static codecheckercreator.CodeCheckerCreatorProp.X_TEXT;
import codecheckercreator.data.CodeCheckerCreatorData;
import static djf.settings.AppStartupConstants.CLASS_PROMPT_LABEL2;
import djf.ui.AppGUI;
import static djf.ui.AppGUI.CLASS_BORDERED_PANE;
import static djf.ui.AppGUI.CLASS_BORDERED_PANE2;
import static djf.ui.AppGUI.CLASS_EDIT_BUTTON;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;


/**
 *
 * @author joelgeorge
 */
public class CodeCheckerCreatorWorkspace extends AppWorkspaceComponent {

    CodeCheckerCreatorApp app;
    CodeCheckerCreatorController controller;

    HBox editToolbar;
    Button homeButton;
    Button nextButton;
    Button prevButton;

    Label stepOneLabel;
    Label commandLabelOne;
    Label listContentLabel1;
    ScrollPane scrollPaneForList;
    ListView<String> filesListView;

//    TableView<String> filesTableView;
//    TableColumn fileNameColumn;
    Button removeButton;
    Button refreshButton;
    Button viewButton;
    ProgressBar extractBar;

    Label extractLabel;
    Button extractButton;
    ScrollPane scrollPaneForTextArea;
    TextArea successArea;
    TextArea errorArea;
    VBox helper;
    VBox leftBox;
    VBox rightBox;
    HBox helperForBottomButtons;
    HBox forProgressBar;
    Button space;
    Button space2;
    Button space3;
    Button space4;
    Button space5;
    Button space6;
    Button space7;
    Button space8;
    Button space9;
    Button space10;
    Button spacex;
    CheckBox space11;
    CheckBox space12;
    CheckBox space13;
    CheckBox space14;
    //Button choose;
    //Button newXButton;

    ArrayList<VBox> leftBoxList;
    ArrayList<VBox> rightBoxList;

    BorderPane basePane; //USE 2 VBOXS INSTEAD
    ReentrantLock lock;

    //STAGE 2
    Label stepTwoLabel;
    Label stepTwoCommandLabel;
    ListView<String> studnetSubmissions;
    ScrollPane studnetSubmissionsPane;
    Label listContentLabel2;
    Button remove2;
    Button refresh2;
    Button view2;
    Button renameFile;
    ProgressBar renameProgress;
    Label renameProgressLabel;
    TextArea success2;
    TextArea error2;
    ScrollPane textAreaPane2;
    VBox left2;
    VBox right2;
    VBox helper2;
    HBox helperForBottomButtons2;
    HBox forProgressBar2;
    

    //STAGE 3
    Label stepThreeLabel;
    Label stepThreeCommandLabel;
    Label listContentLabel3;
    ListView<String> unzipStdSubmissions;
    ScrollPane unzipStdSubmissionsPane;
    Button remove3;
    Button refresh3;
    Button view3;
    Button unzip;
    ProgressBar unzipProgress;
    Label unzipProgressLabel;
    TextArea success3;
    TextArea error3;
    ScrollPane textAreaPane3;
    VBox left3;
    VBox right3;
    VBox helper3;
    HBox helperForBottomButtons3;
    HBox forProgressBar3;

    //STAGE 4
    Label stepFourLabel;
    Label stepFourCommandLabel;
    ListView<String> stepFourSubmissions;
    Label listContentLabel4;
    ScrollPane stepFourSubmissionsPane;
    Button remove4;
    Button refresh4;
    Button view4;
    Button extract4;
    ProgressBar extract4Progress;
    Label extract4ProgressLabel;
    TextArea success4;
    TextArea error4;
    ScrollPane textAreaPane4;
    Label checkBoxLabel;
    CheckBox box1;
    CheckBox box2;
    CheckBox box3;
    CheckBox box4;
    CheckBox box5;
    TextField checkField;
    HBox boxForCheckBoxes1;
    HBox boxForCheckBoxes2;
    VBox left4;
    VBox right4;
    VBox helper4;
    HBox helperForBottomButtons4;
    HBox forProgressBar4;

    //STAGE 5
    Label stepFiveLabel;
    Label stepFiveCommandLabel;
    ListView<String> stepFiveSubmissions;
    ScrollPane stepFiveSubmissionsPane;
    Label listContentLabel5;
    Button remove5;
    Button refresh5;
    Button view5;
    Button codeCheckButton;
    Button viewResultsButton;
    HBox helperForCheckAndView;
    HBox forProgressBar5;
    ProgressBar check5Progress;
    Label check5ProgressLabel;
    TextArea success5;
    TextArea error5;
    ScrollPane textAreaPane5;
    VBox left5;
    VBox right5;
    VBox helper5;
    HBox helperForBottomButtons5;

    int i = 0;
    boolean flag = false;
    int switchBut=0;
    

    public CodeCheckerCreatorWorkspace(CodeCheckerCreatorApp initApp) {

        app = initApp;

        initLayout();
        initControllers();
        initStyle();

    }
    
    public Button getView1Button(){
        return viewButton;
    }
    
    public Button getRemove1Button(){
        return removeButton;
    }

    private void initLayout() {

        PropertiesManager props = PropertiesManager.getPropertiesManager();
        setUpEditToolbar();

        leftBoxList = new ArrayList<>();
        rightBoxList = new ArrayList<>();

        stepOneLabel = new Label(props.getProperty(STEPONE_TEXT));
        commandLabelOne = new Label(props.getProperty(ONECOMMAND_TEXT));
        listContentLabel1 = new Label(props.getProperty(CONTENTLABEL1_TEXT));
        scrollPaneForList = new ScrollPane();
        CodeCheckerCreatorData data = (CodeCheckerCreatorData) app.getDataComponent();
        filesListView = new ListView();
        filesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //filesTableView= new TableView();
        //filesListView.setItems(data.getFiles());
        filesListView.setItems(data.getFiles());
        //fileNameColumn = new TableColumn(props.getProperty(CONTENTLABEL1_TEXT));

        removeButton = new Button(props.getProperty(REMOVEBUTTON_TEXT));
        removeButton.setDisable(true);
        refreshButton = new Button(props.getProperty(REFRESHBUTTON_TEXT));
        viewButton = new Button(props.getProperty(VIEWBUTTON_TEXT));
        viewButton.setDisable(true);
        extractBar = new ProgressBar(0);

        extractLabel = new Label(props.getProperty(EXTRACTLABEL_TEXT));
        extractButton = new Button(props.getProperty(EXTRACTBUTTON_TEXT));
        extractButton.setDisable(true);
        //extractButton.setDisable(true);
        scrollPaneForTextArea = new ScrollPane();
        successArea = new TextArea();
        errorArea = new TextArea();
        helper = new VBox();

        basePane = new BorderPane();
        leftBox = new VBox();
        rightBox = new VBox();
        helperForBottomButtons = new HBox();
        forProgressBar = new HBox();
        forProgressBar.getChildren().add(extractLabel);
        forProgressBar.getChildren().add(extractBar);

        helperForBottomButtons.getChildren().add(removeButton);
        helperForBottomButtons.getChildren().add(refreshButton);
        helperForBottomButtons.getChildren().add(viewButton);

        //scrollPaneForList.setContent(filesListView);
        //filesTableView.getColumns().add(fileNameColumn);
        //fileNameColumn.prefWidthProperty().bind(filesTableView.widthProperty().divide(1));
        scrollPaneForList.setContent(filesListView);
//        fileNameColumn.setCellValueFactory(
//                new PropertyValueFactory<>("fileName")
//        );

        scrollPaneForList.setFitToHeight(true);
        scrollPaneForList.setFitToWidth(true);

        successArea.setPrefColumnCount(50);
        successArea.setPrefRowCount(50);
        errorArea.setPrefColumnCount(50);
        errorArea.setPrefRowCount(50);
        helper.getChildren().add(successArea);
        helper.getChildren().add(errorArea);
        scrollPaneForTextArea.setContent(helper);
        scrollPaneForTextArea.setFitToHeight(true);
        scrollPaneForTextArea.setFitToWidth(true);

        leftBox.getChildren().add(stepOneLabel);
        leftBox.getChildren().add(commandLabelOne);
        leftBox.getChildren().add(listContentLabel1);
        leftBox.getChildren().add(scrollPaneForList);
        leftBox.getChildren().add(space11);
        leftBox.getChildren().add(helperForBottomButtons);

        rightBox.getChildren().add(forProgressBar);
        rightBox.getChildren().add(extractButton);
        rightBox.getChildren().add(scrollPaneForTextArea);
        //rightBox.setAlignment(Pos.CENTER_RIGHT);

//        app.getGUI().getAppPane().setLeft(leftBox);
//        app.getGUI().getAppPane().setCenter(rightBox);
        //app.getGUI().getAppPane().setCenter();
        basePane.setCenter(leftBox);
        basePane.setRight(rightBox);

        //ADD TO LIST!
        leftBoxList.add(leftBox);
        rightBoxList.add(rightBox);

        //app..setCenter(basePane);
// STAGE 2
        
        stepTwoLabel = new Label(props.getProperty(STEPTWO_TEXT));
        stepTwoCommandLabel = new Label(props.getProperty(TWOCOMMAND_TEXT));
        studnetSubmissions = new ListView();
        studnetSubmissions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        studnetSubmissions.setItems(data.getFiles2());
        studnetSubmissionsPane = new ScrollPane();
        studnetSubmissionsPane.setContent(studnetSubmissions);
        studnetSubmissionsPane.setFitToHeight(true);
        studnetSubmissionsPane.setFitToWidth(true);
        listContentLabel2 = new Label(props.getProperty(CONTENTLABEL2_TEXT));
        remove2 = new Button(props.getProperty(REMOVEBUTTON_TEXT));
        remove2.setDisable(true);
        refresh2 = new Button(props.getProperty(REFRESHBUTTON_TEXT));
        view2 = new Button(props.getProperty(VIEWBUTTON_TEXT));
        view2.setDisable(true);
        renameFile = new Button(props.getProperty(RBRIGHT_TEXT));
        renameProgress = new ProgressBar(0);
        renameProgressLabel = new Label(props.getProperty(RPL_TEXT));
        forProgressBar2 = new HBox();
        forProgressBar2.getChildren().add(renameProgressLabel);
        forProgressBar2.getChildren().add(renameProgress);
        success2 = new TextArea();
        error2 = new TextArea();
        textAreaPane2 = new ScrollPane();
        left2 = new VBox();
        right2 = new VBox();
        helper2 = new VBox();

        success2.setPrefColumnCount(50);
        success2.setPrefRowCount(50);
        error2.setPrefColumnCount(50);
        error2.setPrefRowCount(50);

        helper2.getChildren().add(success2);
        helper2.getChildren().add(error2);
        textAreaPane2.setContent(helper2);
        textAreaPane2.setFitToHeight(true);
        textAreaPane2.setFitToWidth(true);

        helperForBottomButtons2 = new HBox();
        helperForBottomButtons2.getChildren().add(remove2);
        helperForBottomButtons2.getChildren().add(refresh2);
        helperForBottomButtons2.getChildren().add(view2);

        left2.getChildren().add(stepTwoLabel);
        left2.getChildren().add(stepTwoCommandLabel);
        left2.getChildren().add(listContentLabel2);
        left2.getChildren().add(studnetSubmissionsPane);
        left2.getChildren().add(space12);
        left2.getChildren().add(helperForBottomButtons2);

        right2.getChildren().add(forProgressBar2);
        right2.getChildren().add(renameFile);
        right2.getChildren().add(textAreaPane2);

        //ADD TO LIST!
        leftBoxList.add(left2);
        rightBoxList.add(right2);

        //STAGE 3
        stepThreeLabel = new Label(props.getProperty(STEPTHREE_TEXT));
        stepThreeCommandLabel = new Label(props.getProperty(THREECOMMAND_TEXT));
        listContentLabel3 = new Label(props.getProperty(CONTENTLABEL3_TEXT));
        unzipStdSubmissions = new ListView();
        unzipStdSubmissions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        unzipStdSubmissions.setItems(data.getFiles2());
        unzipStdSubmissionsPane = new ScrollPane();
        unzipStdSubmissionsPane.setContent(unzipStdSubmissions);
        unzipStdSubmissionsPane.setFitToHeight(true);
        unzipStdSubmissionsPane.setFitToWidth(true);

        remove3 = new Button(props.getProperty(REMOVEBUTTON_TEXT));
        remove3.setDisable(true);
        refresh3 = new Button(props.getProperty(REFRESHBUTTON_TEXT));
        view3 = new Button(props.getProperty(VIEWBUTTON_TEXT));
        view3.setDisable(true);
        unzip = new Button(props.getProperty(UNZIPBUTTON_TEXT));
        unzip.setDisable(true);
        unzipProgress = new ProgressBar(0);
        unzipProgressLabel = new Label(props.getProperty(UPLABEL_TEXT));
        forProgressBar3 = new HBox();
        success3 = new TextArea();
        error3 = new TextArea();
        textAreaPane3 = new ScrollPane();
        left3 = new VBox();
        right3 = new VBox();
        helper3 = new VBox();
        helperForBottomButtons3 = new HBox();

        helperForBottomButtons3.getChildren().add(remove3);
        helperForBottomButtons3.getChildren().add(refresh3);
        helperForBottomButtons3.getChildren().add(view3);

        left3.getChildren().add(stepThreeLabel);
        left3.getChildren().add(stepThreeCommandLabel);
        left3.getChildren().add(listContentLabel3);
        left3.getChildren().add(unzipStdSubmissionsPane);
        left3.getChildren().add(space13);
        left3.getChildren().add(helperForBottomButtons3);

        forProgressBar3.getChildren().add(unzipProgressLabel);
        forProgressBar3.getChildren().add(unzipProgress);

        success3.setPrefColumnCount(50);
        success3.setPrefRowCount(50);
        error3.setPrefColumnCount(50);
        error3.setPrefRowCount(50);

        helper3.getChildren().add(success3);
        helper3.getChildren().add(error3);
        textAreaPane3.setContent(helper3);
        textAreaPane3.setFitToHeight(true);
        textAreaPane3.setFitToWidth(true);

        right3.getChildren().add(forProgressBar3);
        right3.getChildren().add(unzip);
        right3.getChildren().add(textAreaPane3);

        //ADD TO LIST!
        leftBoxList.add(left3);
        rightBoxList.add(right3);

//STAGE 4     
        stepFourLabel = new Label(props.getProperty(STEPFOUR_TEXT));
        stepFourCommandLabel = new Label(props.getProperty(FOURCOMMAND_TEXT));
        stepFourSubmissions = new ListView();
        stepFourSubmissions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        stepFourSubmissions.setItems(data.getFiles4());
        listContentLabel4 = new Label(props.getProperty(CONTENTLABEL4_TEXT));
        stepFourSubmissionsPane = new ScrollPane();
        stepFourSubmissionsPane.setContent(stepFourSubmissions);
        stepFourSubmissionsPane.setFitToHeight(true);
        stepFourSubmissionsPane.setFitToWidth(true);
        remove4 = new Button(props.getProperty(REMOVEBUTTON_TEXT));
        remove4.setDisable(true);
        refresh4 = new Button(props.getProperty(REFRESHBUTTON_TEXT));
        view4 = new Button(props.getProperty(VIEWBUTTON_TEXT));
        view4.setDisable(true);

        extract4 = new Button(props.getProperty(ECBUTTON_TEXT));
        extract4Progress = new ProgressBar(0);
        extract4ProgressLabel = new Label(props.getProperty(FOURPLABEL_TEXT));
        forProgressBar4 = new HBox();
        success4 = new TextArea();
        error4 = new TextArea();
        textAreaPane4 = new ScrollPane();
        checkBoxLabel = new Label(props.getProperty(CHECKBOXLABEL_TEXT));
        box1 = new CheckBox(".java     ");
        box2 = new CheckBox(".c, .h, .cpp     ");
        box3 = new CheckBox(".js     ");
        box4 = new CheckBox(".cs     ");
        box5 = new CheckBox();
        checkField = new TextField();
        checkField.setPrefWidth(100);
        checkField.setPromptText("Other");
        boxForCheckBoxes1 = new HBox();
        boxForCheckBoxes2 = new HBox();
        left4 = new VBox();
        right4 = new VBox();
        helper4 = new VBox();
        helperForBottomButtons4 = new HBox();

        helperForBottomButtons4.getChildren().add(remove4);
        helperForBottomButtons4.getChildren().add(refresh4);
        helperForBottomButtons4.getChildren().add(view4);

        boxForCheckBoxes1.getChildren().add(box1);
        boxForCheckBoxes1.getChildren().add(box2);
        boxForCheckBoxes1.getChildren().add(box3);
        boxForCheckBoxes1.getChildren().add(box4);

        boxForCheckBoxes2.getChildren().add(box5);
        boxForCheckBoxes2.getChildren().add(checkField);

        left4.getChildren().add(stepFourLabel);
        left4.getChildren().add(stepFourCommandLabel);
        left4.getChildren().add(listContentLabel4);
        left4.getChildren().add(stepFourSubmissionsPane);
        left4.getChildren().add(helperForBottomButtons4);
        left4.getChildren().add(space);
        left4.getChildren().add(checkBoxLabel);
        left4.getChildren().add(space2);
        left4.getChildren().add(boxForCheckBoxes1);
        left4.getChildren().add(boxForCheckBoxes2);

        forProgressBar4.getChildren().add(extract4ProgressLabel);
        forProgressBar4.getChildren().add(extract4Progress);

        success4.setPrefColumnCount(50);
        success4.setPrefRowCount(50);
        error4.setPrefColumnCount(50);
        error4.setPrefRowCount(50);

        helper4.getChildren().add(success4);
        helper4.getChildren().add(error4);
        textAreaPane4.setContent(helper4);
        textAreaPane4.setFitToHeight(true);
        textAreaPane4.setFitToWidth(true);

        right4.getChildren().add(forProgressBar4);
        right4.getChildren().add(extract4);
        right4.getChildren().add(textAreaPane4);

        //ADD TO LIST!
        leftBoxList.add(left4);
        rightBoxList.add(right4);

//STAGE 5
        stepFiveLabel = new Label(props.getProperty(STEPFIVE_TEXT));
        stepFiveCommandLabel = new Label(props.getProperty(FIVECOMMAND_TEXT));
        stepFiveSubmissions = new ListView();
        stepFiveSubmissions.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        stepFiveSubmissions.setItems(data.getFiles5());
        stepFiveSubmissionsPane = new ScrollPane();
        stepFiveSubmissionsPane.setContent(stepFiveSubmissions);
        stepFiveSubmissionsPane.setFitToHeight(true);
        stepFiveSubmissionsPane.setFitToWidth(true);

        listContentLabel5 = new Label(props.getProperty(CONTENTLABEL5_TEXT));
        remove5 = new Button(props.getProperty(REMOVEBUTTON_TEXT));
        remove5.setDisable(true);
        refresh5 = new Button(props.getProperty(REFRESHBUTTON_TEXT));
        view5 = new Button(props.getProperty(VIEWBUTTON_TEXT));
        view5.setDisable(true);
        codeCheckButton = new Button(props.getProperty(CCBUTTON_TEXT));
        viewResultsButton = new Button(props.getProperty(VRBUTTON_TEXT));
        Tooltip forView = new Tooltip("this opens a dummy URL !");
        viewResultsButton.setTooltip(forView);
        viewResultsButton.setDisable(true);
        forProgressBar5 = new HBox();
        helperForCheckAndView = new HBox();
        check5Progress = new ProgressBar(0);
        check5ProgressLabel = new Label(props.getProperty(CHECKPLABEL_TEXT));
        success5 = new TextArea();
        error5 = new TextArea();
        textAreaPane5 = new ScrollPane();
        left5 = new VBox();
        right5 = new VBox();
        helper5 = new VBox();
        helperForBottomButtons5 = new HBox();
        helperForBottomButtons5.getChildren().add(remove5);
        helperForBottomButtons5.getChildren().add(refresh5);
        helperForBottomButtons5.getChildren().add(view5);

        left5.getChildren().add(stepFiveLabel);
        left5.getChildren().add(stepFiveCommandLabel);
        left5.getChildren().add(listContentLabel5);
        left5.getChildren().add(stepFiveSubmissionsPane);
        left5.getChildren().add(space14);
        left5.getChildren().add(helperForBottomButtons5);

        forProgressBar5.getChildren().add(check5ProgressLabel);
        forProgressBar5.getChildren().add(check5Progress);
        helperForCheckAndView.getChildren().add(codeCheckButton);
        helperForCheckAndView.getChildren().add(viewResultsButton);

        success5.setPrefColumnCount(50);
        success5.setPrefRowCount(50);
        error5.setPrefColumnCount(50);
        error5.setPrefRowCount(50);

        helper5.getChildren().add(success5);
        helper5.getChildren().add(error5);
        textAreaPane5.setContent(helper5);
        textAreaPane5.setFitToHeight(true);
        textAreaPane5.setFitToWidth(true);

        right5.getChildren().add(forProgressBar5);
        right5.getChildren().add(helperForCheckAndView);
        right5.getChildren().add(textAreaPane5);

        //ADD TO LIST!
        leftBoxList.add(left5);
        rightBoxList.add(right5);

        workspace = basePane;

    }
    
    public Button getnextButton(){
        return nextButton;
    }

    private void setUpEditToolbar() {

        PropertiesManager props = PropertiesManager.getPropertiesManager();

        homeButton = new Button(props.getProperty(HOMEBUTTION_TEXT));
        nextButton = new Button(props.getProperty(NEXTBUTTON_TEXT));
        prevButton = new Button(props.getProperty(PREVBUTTON_TEXT));
        //choose = new Button(props.getProperty(CHOOSEB_TEXT));

        homeButton.setDisable(true);
        
        prevButton.setDisable(true);
        //choose.setDisable(true);

        space = new Button("Space");
        space2 = new Button("Space");
        space3 = new Button("Space");
        space4 = new Button("Space");
        space5 = new Button("Space");
        space6 = new Button("Space");
        space7 = new Button("Space");
        space8 = new Button("Space");
        space9 = new Button("Space");
        space10 = new Button("Spacei");
        spacex = new Button("SpaceSpaiiiiiieee");
        space11 = new CheckBox();
        space12 = new CheckBox();
        space13 = new CheckBox();
        space14 = new CheckBox();
        //newXButton= new Button(props.getProperty(X_TEXT));
        editToolbar = new HBox();

        editToolbar.getChildren().add(space);
        editToolbar.getChildren().add(space2);
        editToolbar.getChildren().add(space3);
        editToolbar.getChildren().add(space4);
        editToolbar.getChildren().add(space5);
        editToolbar.getChildren().add(space6);
        editToolbar.getChildren().add(space7);
        editToolbar.getChildren().add(space8);
        editToolbar.getChildren().add(space9);
        editToolbar.getChildren().add(space10);
        editToolbar.getChildren().add(spacex);
        //editToolbar.getChildren().add(choose);
        editToolbar.getChildren().add(homeButton);
        editToolbar.getChildren().add(prevButton);
        editToolbar.getChildren().add(nextButton);
        space.setVisible(false);
        space2.setVisible(false);
        space3.setVisible(false);
        space4.setVisible(false);
        space5.setVisible(false);
        space6.setVisible(false);
        space7.setVisible(false);
        space8.setVisible(false);
        space9.setVisible(false);
        space10.setVisible(false);
        spacex.setVisible(false);

        space11.setVisible(false);
        space12.setVisible(false);
        space13.setVisible(false);
        space14.setVisible(false);
        //app.getGUI().returnTopPane().setRight(newXButton);

        app.getGUI().getTopToolbarPane().getChildren().add(editToolbar);

    }

    private void initControllers() {

        CodeCheckerCreatorData data = (CodeCheckerCreatorData) app.getDataComponent();
        controller = new CodeCheckerCreatorController(app);

        homeButton.setOnAction(e -> {
            nextButton.setDisable(false);

            basePane.getChildren().remove(leftBoxList.get(i));
            basePane.getChildren().remove(rightBoxList.get(i));

            basePane.setCenter(leftBoxList.get(0));
            basePane.setRight(rightBoxList.get(0));

            i = 0;

            homeButton.setDisable(true);
            prevButton.setDisable(true);
        });

        prevButton.setOnAction(e -> {

            nextButton.setDisable(false);

            basePane.getChildren().remove(leftBoxList.get(i));
            basePane.getChildren().remove(rightBoxList.get(i));

            basePane.setCenter(leftBoxList.get(i - 1));
            basePane.setRight(rightBoxList.get(i - 1));

            i--;

            if (i == 0) {
                prevButton.setDisable(true);
                homeButton.setDisable(true);
            }

        });

        nextButton.setOnAction(e -> {

            homeButton.setDisable(false);
            prevButton.setDisable(false);
            //nextButton.setDisable(true);

            basePane.getChildren().remove(leftBoxList.get(i));
            basePane.getChildren().remove(rightBoxList.get(i));

            basePane.setCenter(leftBoxList.get(i + 1));
            basePane.setRight(rightBoxList.get(i + 1));

            i++;

            if (i == leftBoxList.size() - 1) {
                nextButton.setDisable(true);
            }

        });


    filesListView.setOnMousePressed(e->{
        removeButton.setDisable(false);
        viewButton.setDisable(false);
        extractButton.setDisable(false);
        
    });
    studnetSubmissions.setOnMousePressed(e->{
        remove2.setDisable(false);
        view2.setDisable(false);
        
    });
    unzipStdSubmissions.setOnMousePressed(e->{
        remove3.setDisable(false);
        view3.setDisable(false);
        unzip.setDisable(false);
        
    });
    stepFourSubmissions.setOnMousePressed(e->{
        remove4.setDisable(false);
        view4.setDisable(false);
        
    });
    stepFiveSubmissions.setOnMousePressed(e->{
        remove5.setDisable(false);
        view5.setDisable(false);
        
    });

        refreshButton.setOnAction(e -> {
            //extractButton.setDisable(false);
            if (!data.getFiles().isEmpty()) {
                data.getFiles().clear();
            }

            File folderToGet = new File("./work/" + app.getGUI().getCodeCheckName() + "/Blackboard");

            File[] allTheFiles = folderToGet.listFiles();

            for (File theFile : allTheFiles) {
                if (theFile.isFile()) {
                    data.getFiles().add(theFile.getName());
                }
            }
            filesListView.refresh();

        });

        refresh2.setOnAction(e -> {
            //extractButton.setDisable(false);
            if (!data.getFiles2().isEmpty()) {
                data.getFiles2().clear();
            }

            File folderToGet = new File("./work/" + app.getGUI().getCodeCheckName() + "/Submissions");

            File[] allTheFiles = folderToGet.listFiles();

            for (File theFile : allTheFiles) {
                if (theFile.isFile() && theFile.getName().endsWith(".zip")) {
                    data.getFiles2().add(theFile.getName());
                }
            }
           
            
            studnetSubmissions.refresh();

        });
        
        refresh3.setOnAction(e -> {
            //extractButton.setDisable(false);
            if (!data.getFiles2().isEmpty()) {
                data.getFiles2().clear();
            }

            File folderToGet = new File("./work/" + app.getGUI().getCodeCheckName() + "/Submissions");

            File[] allTheFiles = folderToGet.listFiles();

            for (File theFile : allTheFiles) {
                if (theFile.isFile() && theFile.getName().endsWith(".zip")) {
                    data.getFiles2().add(theFile.getName());
                }
            }
           
            
            unzipStdSubmissions.refresh();

        });
        
        refresh4.setOnAction(e -> {
            //extractButton.setDisable(false);
            if (!data.getFiles4().isEmpty()) {
                data.getFiles4().clear();
            }

            File folderToGet = new File("./work/" + app.getGUI().getCodeCheckName() + "/Projects");

            File[] allTheFiles = folderToGet.listFiles();

            for (File theFile : allTheFiles) {
                if (theFile.isDirectory()) {
                    data.getFiles4().add(theFile.getName());
                }
            }
            
            stepFourSubmissions.refresh();

        });
        
        refresh5.setOnAction(e -> {
            //extractButton.setDisable(false);
            if (!data.getFiles5().isEmpty()) {
                data.getFiles5().clear();
            }

            File folderToGet = new File("./work/" + app.getGUI().getCodeCheckName() + "/SourceCode");

            File[] allTheFiles = folderToGet.listFiles();

            for (File theFile : allTheFiles) {
                if (theFile.isDirectory()) {
                    data.getFiles5().add(theFile.getName());
                }
            }
            
            stepFourSubmissions.refresh();

        });

        removeButton.setOnAction(e -> {
            
            if(data.getFiles().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            
            else{
            
            int x = filesListView.getSelectionModel().getSelectedIndex();

            Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
            myAlert.setHeaderText(null);
            myAlert.setTitle("Deleting a file");
            myAlert.setContentText("Are you 100% sure you want to delete this file? ");
            myAlert.showAndWait();

            Optional<ButtonType> action = myAlert.showAndWait();
            
            
            if (action.get() == ButtonType.OK) {

               if(filesListView.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only remove 1 file at a time");
                myAlert2.showAndWait();
                }
               
               else{
                   
                Path thePath = Paths.get("./work/" + app.getGUI().getCodeCheckName() + "/Blackboard/" + filesListView.getSelectionModel().getSelectedItem());
                data.getFiles().remove(x);
                try {
                    Files.delete(thePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
            } else if (action.get() == ButtonType.CANCEL) {
                e.consume();
            }
            
            removeButton.setDisable(true);
            viewButton.setDisable(true);
            }

        });
        
        remove2.setOnAction(e -> {
            
            if(data.getFiles2().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            else{
            
            //if(switchBut==0){
            
            int x = studnetSubmissions.getSelectionModel().getSelectedIndex();

            Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
            myAlert.setHeaderText(null);
            myAlert.setTitle("Deleting a file");
            myAlert.setContentText("Are you 100% sure you want to delete this file? ");
            myAlert.showAndWait();

            Optional<ButtonType> action = myAlert.showAndWait();
            
            
            if (action.get() == ButtonType.OK) {

               if(studnetSubmissions.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only remove 1 file at a time");
                myAlert2.showAndWait();
                }
               
               else{
                   
                Path thePath = Paths.get("./work/" + app.getGUI().getCodeCheckName() + "/Submissions/" + studnetSubmissions.getSelectionModel().getSelectedItem());
                data.getFiles2().remove(x);
                try {
                    Files.delete(thePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
            } else if (action.get() == ButtonType.CANCEL) {
                e.consume();
            }
        
            
            remove2.setDisable(true);
            view2.setDisable(true);
            }
        });
        
        remove3.setOnAction(e -> {
            
            if(data.getFiles2().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
            
            int x = unzipStdSubmissions.getSelectionModel().getSelectedIndex();

            Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
            myAlert.setHeaderText(null);
            myAlert.setTitle("Deleting a file");
            myAlert.setContentText("Are you 100% sure you want to delete this file? ");
            myAlert.showAndWait();

            Optional<ButtonType> action = myAlert.showAndWait();
            
            
            if (action.get() == ButtonType.OK) {

               if(unzipStdSubmissions.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only remove 1 file at a time");
                myAlert2.showAndWait();
                }
               
               else{
                   
                Path thePath = Paths.get("./work/" + app.getGUI().getCodeCheckName() + "/Submissions/" + unzipStdSubmissions.getSelectionModel().getSelectedItem());
                data.getFiles2().remove(x);
                //data.getTempForStep().remove(x);
                try {
                    Files.delete(thePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
            } else if (action.get() == ButtonType.CANCEL) {
                e.consume();
            }
            
            remove3.setDisable(true);
            view3.setDisable(true);
            
            }
            
        });
        
        remove4.setOnAction(e -> {
            
            if(data.getFiles4().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
            
            int x = stepFourSubmissions.getSelectionModel().getSelectedIndex();

            Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
            myAlert.setHeaderText(null);
            myAlert.setTitle("Deleting a file");
            myAlert.setContentText("Are you 100% sure you want to delete this file? ");
            myAlert.showAndWait();

            Optional<ButtonType> action = myAlert.showAndWait();
            
            
            if (action.get() == ButtonType.OK) {

               if(stepFourSubmissions.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only remove 1 file at a time");
                myAlert2.showAndWait();
                }
               
               else{
                   
                File thePath = new File("./work/" + app.getGUI().getCodeCheckName() + "/Projects/" + stepFourSubmissions.getSelectionModel().getSelectedItem());
                data.getFiles4().remove(x);
                   try {
                       FileUtils.deleteDirectory(thePath);
                   } catch (IOException ex) {
                       Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } else if (action.get() == ButtonType.CANCEL) {
                e.consume();
            }
            
            remove4.setDisable(true);
            view4.setDisable(true);
            }
            
        });
        
        remove5.setOnAction(e -> {
            
            if(data.getFiles5().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            else{
            
            int x = stepFiveSubmissions.getSelectionModel().getSelectedIndex();

            Alert myAlert = new Alert(Alert.AlertType.CONFIRMATION);
            myAlert.setHeaderText(null);
            myAlert.setTitle("Deleting a file");
            myAlert.setContentText("Are you 100% sure you want to delete this file? ");
            myAlert.showAndWait();

            Optional<ButtonType> action = myAlert.showAndWait();
            
            
            if (action.get() == ButtonType.OK) {

               if(stepFiveSubmissions.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only remove 1 file at a time");
                myAlert2.showAndWait();
                }
               
               else{
                   
                File thePath = new File("./work/" + app.getGUI().getCodeCheckName() + "/SourceCode/" + stepFiveSubmissions.getSelectionModel().getSelectedItem());
                data.getFiles5().remove(x);
                   try {
                       FileUtils.deleteDirectory(thePath);
                   } catch (IOException ex) {
                       Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            } else if (action.get() == ButtonType.CANCEL) {
                e.consume();
            }
            
            remove5.setDisable(true);
            view5.setDisable(true);
            }
            
        });
        
//        filesListView.setOnMousePressed(e->{
//            extractButton.setDisable(false);
//            
//        });

        extractButton.setOnAction(e -> {
            
            //nextButton.setDisable(false);
            
            if(data.getFiles().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
                
            ArrayList<ZipFile> zipFiles = new ArrayList<>();

            ObservableList<String> temp = filesListView.getSelectionModel().getSelectedItems();
            

            for (int i = 0; i < temp.size(); i++) {
                try {
                    zipFiles.add(new ZipFile("./work/"+app.getGUI().getCodeCheckName()+"/Blackboard/"+temp.get(i)));
                    //successArea.appendText(temp.get(i)+" has been successfullly extracted" + "\n");

                } catch (ZipException ex) {
                    //errorArea.appendText(temp.get(i)+" has not been extracted");
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

                Task<Void> task = new Task<Void>() {

                    @Override
                    protected Void call() throws Exception {

                        for (int i = 0; i < zipFiles.size(); i++) {

                            try {
                               
                                //System.out.println(i);
                                zipFiles.get(i).extractAll("./work/" + app.getGUI().getCodeCheckName() + "/Submissions");
                                File folderToGet = new File("./work/" + app.getGUI().getCodeCheckName() + "/Submissions");
                                successArea.appendText(temp.get(i)+" has been successfullly extracted" + "\n");
                                File[] allTheFiles = folderToGet.listFiles();
                                
                                if(i==zipFiles.size()-1){
                                data.getFiles2().clear();
                                for (int j=0; j<allTheFiles.length; j++) {
                                    if (allTheFiles[j].isFile() && allTheFiles[j].getName().endsWith(".zip")) {
                                        
                                        data.getFiles2().add(allTheFiles[j].getName());
                                        
                                    }
                                    else{
                                        error2.appendText(allTheFiles[j].getName()+ " has not been added to the list" + "\n");
                                    }
                                        
                                  }
                                }

                                updateProgress(i, zipFiles.size() - 1);
                                
                            } catch (ZipException ex) {
                                errorArea.appendText(temp.get(i)+" has not been extracted");
                                ex.printStackTrace();
                                Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            Thread.sleep(5);
                           
                        }

                        return null;

                    }

                };

                Thread thread = new Thread(task);
                extractBar.progressProperty().bind(task.progressProperty());
                thread.start();
            }
   
        });
        
        renameFile.setOnAction(e -> {
            //nextButton.setDisable(false);
            
            if(data.getFiles2().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
            
            switchBut++;
            
            for (int i = 0; i < data.getFiles2().size(); i++) {
                try {
                    
                    success2.appendText(data.getFiles2().get(i)+" has been renamed" + "\n");

                } catch (Exception ex) {
                    error2.appendText(data.getFiles2().get(i)+" has not been renamed");
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Task<Void> task2 = new Task<Void>() {

                @Override
                protected Void call() throws Exception {

                    ArrayList<String> temp = new ArrayList<>();
                    for (int i = 0; i < data.getFiles2().size(); i++) {
                        //data.getTempForStep().add((String)data.getFiles2().get(i));
                        

                        String fileName = (String) data.getFiles2().get(i);
                        String[] parts = fileName.split("_");
                        String newName = parts[1]+".zip";
                        
                        File orig = new File("./work/" + app.getGUI().getCodeCheckName() + "/Submissions/"+data.getFiles2().get(i));
                        File newOne = new File("./work/" + app.getGUI().getCodeCheckName() + "/Submissions/"+newName);
                        
                        orig.renameTo(newOne);
                        //success2.appendText(data.getFiles2().get(i)+" has been renamed" + "\n");
                        
                        
                        temp.add(newOne.getName());
                        
                        if(i==data.getFiles2().size()-1){
                            data.getFiles2().clear();
                            for(int j=0; j<temp.size(); j++){
                                
                                data.getFiles2().add(temp.get(j));
                            }
                            
                        }
                        
                        
                        updateProgress(i, data.getFiles2().size() - 1);
                       
                       
                        Thread.sleep(5);
                    }

                    return null;

                }

            };

            Thread thread2 = new Thread(task2);
            renameProgress.progressProperty().bind(task2.progressProperty());
            thread2.start();
            }

        });
        
//        unzipStdSubmissions.setOnMousePressed(e->{
//            unzip.setDisable(false);
//        });
        
        unzip.setOnAction(e -> {
            //nextButton.setDisable(false);
            
            if(data.getFiles2().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
            
            ArrayList<ZipFile> zipFiles4 = new ArrayList<>();
            
            ObservableList<String> names = unzipStdSubmissions.getSelectionModel().getSelectedItems();

            //ObservableList<Integer> temp = unzipStdSubmissions.getSelectionModel().getSelectedIndices();
            //ArrayList<String> temp2= new ArrayList<>();
            
//            for(int a=0; a<temp.size(); a++){
//                
//                temp2.add((String) data.getTempForStep().get(temp.get(a)));
//                
//            }

            for (int i = 0; i < names.size(); i++) {
                try {
                    zipFiles4.add(new ZipFile("./work/" + app.getGUI().getCodeCheckName() + "/Submissions/" + names.get(i)));
                    //System.out.println(temp2.get(i));
//                    success3.appendText(names.get(i) + " has been successfullly unzipped" + "\n");

                } catch (ZipException ex) {
//                    error3.appendText(names.get(i) + " has not been unzipped");
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Task<Void> task3 = new Task<Void>() {

                @Override
                protected Void call() throws Exception {

                    for (int i = 0; i < zipFiles4.size(); i++) {

                        try {
                            
//                                String fileName = (String) temp2.get(i);
//                                String[] parts = fileName.split("_");
//                                String newName = parts[1];
                                
                                File newDir = new File("./work/"+app.getGUI().getCodeCheckName()+"/Projects/"+names.get(i)+"_work");
                                
                                FileUtils.forceMkdir(newDir);
                            
                            zipFiles4.get(i).extractAll("./work/" + app.getGUI().getCodeCheckName() + "/Projects/"+names.get(i)+"_work");
                            
                            success3.appendText(names.get(i) + " has been successfullly unzipped" + "\n");
                            
                            File folderToGet = new File("./work/" + app.getGUI().getCodeCheckName() + "/Projects");
                            
                            File[] allTheFiles = folderToGet.listFiles();

                            if (i == zipFiles4.size() - 1) {
                                data.getFiles4().clear();
                                for (int j = 0; j < allTheFiles.length; j++) {
                                    if (allTheFiles[j].isDirectory()) {

                                        data.getFiles4().add(allTheFiles[j].getName());

                                    } else {
                                        error4.appendText(allTheFiles[j].getName() + " has not been added to the list" + "\n");
                                    }

                                }
                            }

                            updateProgress(i, zipFiles4.size() - 1);

                        } catch (ZipException ex) {
                             error3.appendText(names.get(i) + " has not been unzipped");
                            ex.printStackTrace();
                            Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        Thread.sleep(5);

                    }

                    return null;

                }

            };

            Thread thread3 = new Thread(task3);
            unzipProgress.progressProperty().bind(task3.progressProperty());
            thread3.start();
            }

        });
        
        extract4.setOnAction(e -> {
            
            if (!box1.isSelected()
                    && !box2.isSelected()
                    && !box3.isSelected()
                    && !box4.isSelected()
                    && !box5.isSelected()) {

                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("You must select what type of file to extract");
                myAlert2.showAndWait();

            }
            
            else if(data.getFiles4().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
                
                ObservableList<String> names = data.getFiles4();

            for (int i = 0; i < names.size(); i++) {
                try {

                    success4.appendText("Desired source code from " + names.get(i) + " has been extracted" + "\n");

                } catch (Exception ex) {
                    error4.appendText("Desired source code from " + names.get(i) + " has NOT been extracted" + "\n");
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Task<Void> task4 = new Task<Void>() {

                @Override
                protected Void call() throws Exception {

                    for (int i = 0; i < names.size(); i++) {

                        File fileToView = new File("./work/" + app.getGUI().getCodeCheckName() + "/Projects/" + names.get(i));
                        
                        List<File> fileSourceCode = (List<File>) FileUtils.listFiles(fileToView, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);

                        File newDir = new File("./work/"+app.getGUI().getCodeCheckName()+"/SourceCode/"+names.get(i)+"_SourceCode");
                                    
                        FileUtils.forceMkdir(newDir);
                        
                        for (int j = 0; j < fileSourceCode.size(); j++) {
                            
                            if (box1.isSelected() && fileSourceCode.get(j).getName().endsWith(".java")) {
                                
                                    try{
                                    FileUtils.copyFileToDirectory(fileSourceCode.get(j), newDir);
                                    }
                                    catch(IOException v){
                                        v.printStackTrace();
                                    }
                                    
                            }

                            if (box2.isSelected() && (fileSourceCode.get(j).getName().endsWith(".c") || 
                                        fileSourceCode.get(j).getName().endsWith(".h") || 
                                        fileSourceCode.get(j).getName().endsWith(".cpp"))) {
                                
                                    try{
                                    FileUtils.copyFileToDirectory(fileSourceCode.get(j), newDir);
                                    }
                                    catch(IOException v){
                                        v.printStackTrace();
                                    }

                            }

                            if (box3.isSelected() && fileSourceCode.get(j).getName().endsWith(".js")) {
                                    
                                    try{
                                    FileUtils.copyFileToDirectory(fileSourceCode.get(j), newDir);
                                    }
                                    catch(IOException v){
                                        v.printStackTrace();
                                    }
                                    
                            }

                            if (box4.isSelected() && fileSourceCode.get(j).getName().endsWith(".cs")) {
                                    
                                    try{
                                    FileUtils.copyFileToDirectory(fileSourceCode.get(j), newDir);
                                    }
                                    catch(IOException v){
                                        v.printStackTrace();
                                    }
                                    
                            }

                            if (box5.isSelected() && fileSourceCode.get(j).getName().endsWith(checkField.getText())) {
                                    
                                    try{
                                    FileUtils.copyFileToDirectory(fileSourceCode.get(j), newDir);
                                    }
                                    catch(IOException v){
                                        v.printStackTrace();
                                    }
                                    
                            }
                            
                            if(i==names.size()-1){
                                
                                if(!data.getFiles5().isEmpty()){
                                    data.getFiles5().clear();
                                }
                            
                                File addTo5 = new File ("./work/"+app.getGUI().getCodeCheckName()+"/SourceCode");
                                File[] theFiles = addTo5.listFiles();
                            
                            for(int k=0; k<theFiles.length; k++){
                                
                               data.getFiles5().add(theFiles[k].getName());
                            }
                            
                        }

                        }

                        updateProgress(i, data.getFiles4().size() - 1);

                        Thread.sleep(5);
                    }

                    return null;

                }

            };

            Thread thread4 = new Thread(task4);
            extract4Progress.progressProperty().bind(task4.progressProperty());
            thread4.start();
        }

        });
        
        viewButton.setOnAction(e -> {
            
            if(data.getFiles().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            else{
            
            if(filesListView.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only view one File at a time");
                myAlert2.showAndWait();
                }
            else{
            String temp = filesListView.getSelectionModel().getSelectedItem();
                try {
                    controller.handleView(temp);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ZipException ex) {
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            removeButton.setDisable(true);
            viewButton.setDisable(true);
            extractButton.setDisable(true);
            
            }

        });
        
        view2.setOnAction(e -> {
            
            if(data.getFiles2().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
            
            if(studnetSubmissions.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only view one File at a time");
                myAlert2.showAndWait();
                }
            else{
            String temp = studnetSubmissions.getSelectionModel().getSelectedItem();
            int tempInt =studnetSubmissions.getSelectionModel().getSelectedIndex();
                try {
                    //if(temp.startsWith("HW"))
                    //controller.handleView2(temp);
                    //else{
                        //String theTemp = (String) data.getTempForStep().get(tempInt);
                        controller.handleView2(temp);
                        
                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ZipException ex) {
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            remove2.setDisable(true);
            view2.setDisable(true);
            
            }

        });
        
        view3.setOnAction(e -> {
            
            if(data.getFiles2().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
            
            if(unzipStdSubmissions.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only view one File at a time");
                myAlert2.showAndWait();
                }
            else{
            //int tempInt = unzipStdSubmissions.getSelectionModel().getSelectedIndex();
            String temp = unzipStdSubmissions.getSelectionModel().getSelectedItem();
                try {
                    controller.handleView2(temp);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ZipException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            remove3.setDisable(true);
            view3.setDisable(true);
            unzip.setDisable(true);
            }
        });
        
        view4.setOnAction(e -> {
            
            if(data.getFiles4().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            else{
            
            if(stepFourSubmissions.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only view one File at a time");
                myAlert2.showAndWait();
                }
            else{
           
            String temp = stepFourSubmissions.getSelectionModel().getSelectedItem();
                try {
                    controller.handleView4(temp);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ZipException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            remove4.setDisable(true);
            view4.setDisable(true);
            }
        });
        
        view5.setOnAction(e -> {
            
            if(data.getFiles5().isEmpty()){
                
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText("The table is empty!");
                myAlert2.showAndWait();
                
            }
            
            else{
            
            if(stepFiveSubmissions.getSelectionModel().getSelectedItems().size()>1){
                Alert myAlert2 = new Alert(AlertType.ERROR);
                myAlert2.setHeaderText(null);
                myAlert2.setTitle("Error");
                myAlert2.setContentText( "You can only view one File at a time");
                myAlert2.showAndWait();
                }
            else{
           
            String temp = stepFiveSubmissions.getSelectionModel().getSelectedItem();
                try {
                    controller.handleView5(temp);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ZipException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(CodeCheckerCreatorWorkspace.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            remove5.setDisable(true);
            view5.setDisable(true);
            }
        });

        codeCheckButton.setOnAction(e -> {
            viewResultsButton.setDisable(false);
            success5.appendText("Code Check in progress..." + "\n");
            
             Task<Void> task5 = new Task<Void>() {

                @Override
                protected Void call() throws Exception {

                    for (int i = 0; i < 199; i++) {
                        
                        
                        if(i==198){
                            success5.appendText("The Code Check is complete! Click 'View Results' to see the results" + "\n");
                        }
                        
                        updateProgress(i, 198);
                        
                        Thread.sleep(5);
                    }

                    return null;

                }

            };

            Thread thread5 = new Thread(task5);
            check5Progress.progressProperty().bind(task5.progressProperty());
            thread5.start();

        });

        viewResultsButton.setOnAction(e -> {

            WebView theWeb = new WebView();
            WebEngine theEngine = theWeb.getEngine();
            theEngine.load("http://www.google.com");
            VBox pane = new VBox();

            pane.getChildren().add(theWeb);

            Scene scene = new Scene(pane, 750, 750);
            Stage stage3 = new Stage();
            stage3.setTitle("Code Check results");
            stage3.setScene(scene);

            stage3.show();
            viewResultsButton.setDisable(true);
        });

    }

    private void initStyle() {

        forProgressBar.getStyleClass().add(CLASS_BORDERED_PANE2);
        forProgressBar2.getStyleClass().add(CLASS_BORDERED_PANE2);
        forProgressBar3.getStyleClass().add(CLASS_BORDERED_PANE2);
        forProgressBar4.getStyleClass().add(CLASS_BORDERED_PANE2);
        forProgressBar5.getStyleClass().add(CLASS_BORDERED_PANE2);
        helperForCheckAndView.getStyleClass().add(CLASS_BORDERED_PANE2);

        stepOneLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        stepTwoLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        stepThreeLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        stepFourLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        stepFiveLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        checkBoxLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);

        extractLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        renameProgressLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        unzipProgressLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        extract4ProgressLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);
        check5ProgressLabel.getStyleClass().add(CLASS_PROMPT_LABEL2);

        editToolbar.getStyleClass().add(CLASS_BORDERED_PANE);
        homeButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        nextButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        prevButton.getStyleClass().add(CLASS_EDIT_BUTTON);
//        choose.getStyleClass().add(CLASS_EDIT_BUTTON);
//        Tooltip myTool = new Tooltip("click to add a zip file to start the grading process");
//        choose.setTooltip(myTool);

        extractButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        renameFile.getStyleClass().add(CLASS_EDIT_BUTTON);
        unzip.getStyleClass().add(CLASS_EDIT_BUTTON);
        extract4.getStyleClass().add(CLASS_EDIT_BUTTON);
        codeCheckButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        viewResultsButton.getStyleClass().add(CLASS_EDIT_BUTTON);

        viewButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        refreshButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        removeButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        view2.getStyleClass().add(CLASS_EDIT_BUTTON);
        refresh2.getStyleClass().add(CLASS_EDIT_BUTTON);
        remove2.getStyleClass().add(CLASS_EDIT_BUTTON);
        view3.getStyleClass().add(CLASS_EDIT_BUTTON);
        refresh3.getStyleClass().add(CLASS_EDIT_BUTTON);
        remove3.getStyleClass().add(CLASS_EDIT_BUTTON);
        view4.getStyleClass().add(CLASS_EDIT_BUTTON);
        refresh4.getStyleClass().add(CLASS_EDIT_BUTTON);
        remove4.getStyleClass().add(CLASS_EDIT_BUTTON);
        view5.getStyleClass().add(CLASS_EDIT_BUTTON);
        refresh5.getStyleClass().add(CLASS_EDIT_BUTTON);
        remove5.getStyleClass().add(CLASS_EDIT_BUTTON);

        leftBox.getStyleClass().add(CLASS_BORDERED_PANE);
        rightBox.getStyleClass().add(CLASS_BORDERED_PANE);
        left2.getStyleClass().add(CLASS_BORDERED_PANE);
        right2.getStyleClass().add(CLASS_BORDERED_PANE);
        left3.getStyleClass().add(CLASS_BORDERED_PANE);
        right3.getStyleClass().add(CLASS_BORDERED_PANE);
        left4.getStyleClass().add(CLASS_BORDERED_PANE);
        right4.getStyleClass().add(CLASS_BORDERED_PANE);
        left5.getStyleClass().add(CLASS_BORDERED_PANE);
        right5.getStyleClass().add(CLASS_BORDERED_PANE);

    }

    @Override
    public void resetWorkspace() {

        homeButton.setDisable(true);
        prevButton.setDisable(true);
        //nextButton.setDisable(true);
        //choose.setDisable(false);

        basePane.setCenter(leftBoxList.get(0));
        basePane.setRight(rightBoxList.get(0));

        i = 0;

    }

    @Override
    public void reloadWorkspace(AppDataComponent dataComponent) {

    }

}
