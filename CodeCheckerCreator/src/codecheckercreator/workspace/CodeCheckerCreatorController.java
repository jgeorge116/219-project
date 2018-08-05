/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheckercreator.workspace;

import codecheckercreator.CodeCheckerCreatorApp;
import static codecheckercreator.CodeCheckerCreatorProp.APP_PATH_WORK;
import codecheckercreator.data.CodeCheckerCreatorData;
import djf.ui.AppMessageDialogSingleton;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import properties_manager.PropertiesManager;
//import java.util.zip.ZipFile;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

/**
 *
 * @author joelgeorge
 */
public class CodeCheckerCreatorController {
    
    CodeCheckerCreatorApp app;
    
    public CodeCheckerCreatorController(CodeCheckerCreatorApp initApp){
        
        app=initApp;
        
    }
    
        public void handleView(String fileName) throws IOException, ZipException{ // handels view 
            //System.out.println("./work/"+app.getGUI().getCodeCheckName()+"/Blackboard/"+fileName);
            Alert myAlert = new Alert(Alert.AlertType.INFORMATION);
            
            TextArea contentsArea = new TextArea();
 
            contentsArea.setWrapText(true);
            
            
            contentsArea.setMaxHeight(Double.MAX_VALUE);
            contentsArea.setMaxWidth(Double.MAX_VALUE);
            
            GridPane.setVgrow(contentsArea, Priority.ALWAYS);
            GridPane.setHgrow(contentsArea, Priority.ALWAYS);
            GridPane box = new GridPane();
            
            box.setMaxHeight(Double.MAX_VALUE);
            box.add(contentsArea, 0, 0);
            
            
            ZipFile fileToView = new ZipFile("./work/" + app.getGUI().getCodeCheckName() + "/Blackboard/" + fileName);
            try {
                ArrayList<FileHeader> theFiles = (ArrayList) fileToView.getFileHeaders();

                for (int i = 0; i < theFiles.size(); i++) {
                    FileHeader sub = (FileHeader) theFiles.get(i);
                    contentsArea.appendText(sub.getFileName() + "\n");
                }
            } catch (ZipException e) {
                e.printStackTrace();
            }
              contentsArea.setEditable(false);
            
            myAlert.getDialogPane().setExpandableContent(box);
            
                myAlert.setHeaderText("Contents");
                myAlert.setTitle("Viewing file contents");
                myAlert.setContentText("Here are the contents of the file you selected: ");
                myAlert.showAndWait();
               
         
    }
        public void handleView2(String fileName) throws IOException, ZipException{ // handels view 
            //System.out.println("./work/"+app.getGUI().getCodeCheckName()+"/Blackboard/"+fileName);
            Alert myAlert = new Alert(Alert.AlertType.INFORMATION);
            
            TextArea contentsArea = new TextArea();
 
            contentsArea.setWrapText(true);
            
            
            contentsArea.setMaxHeight(Double.MAX_VALUE);
            contentsArea.setMaxWidth(Double.MAX_VALUE);
            
            GridPane.setVgrow(contentsArea, Priority.ALWAYS);
            GridPane.setHgrow(contentsArea, Priority.ALWAYS);
            GridPane box = new GridPane();
            
            box.setMaxHeight(Double.MAX_VALUE);
            box.add(contentsArea, 0, 0);
            
            
            ZipFile fileToView = new ZipFile("./work/" + app.getGUI().getCodeCheckName() + "/Submissions/" + fileName);
            try {
                ArrayList<FileHeader> theFiles = (ArrayList) fileToView.getFileHeaders();

                for (int i = 0; i < theFiles.size(); i++) {
                    FileHeader sub = (FileHeader) theFiles.get(i);
                    contentsArea.appendText(sub.getFileName() + "\n");
                }
            } catch (ZipException e) {
                e.printStackTrace();
            }
              contentsArea.setEditable(false);
            
            myAlert.getDialogPane().setExpandableContent(box);
            
                myAlert.setHeaderText("Contents");
                myAlert.setTitle("Viewing file contents");
                myAlert.setContentText("Here are the contents of the file you selected: ");
                myAlert.showAndWait();
               
         
    }
        
        public void handleView4(String fileName) throws IOException, ZipException{ // handels view 
            //System.out.println("./work/"+app.getGUI().getCodeCheckName()+"/Blackboard/"+fileName);
            Alert myAlert = new Alert(Alert.AlertType.INFORMATION);

            TextArea contentsArea = new TextArea();

            contentsArea.setWrapText(true);

            contentsArea.setMaxHeight(Double.MAX_VALUE);
            contentsArea.setMaxWidth(Double.MAX_VALUE);

            GridPane.setVgrow(contentsArea, Priority.ALWAYS);
            GridPane.setHgrow(contentsArea, Priority.ALWAYS);
            GridPane box = new GridPane();

            box.setMaxHeight(Double.MAX_VALUE);
            box.add(contentsArea, 0, 0);

            File fileToView = new File("./work/" + app.getGUI().getCodeCheckName() + "/Projects/" + fileName);

            List<File> theFiles = (List<File>) FileUtils.listFiles(fileToView, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
            
            for(int i=0; i<theFiles.size(); i++){
                contentsArea.appendText(theFiles.get(i).getName() + "\n");
            }

            contentsArea.setEditable(false);

            myAlert.getDialogPane().setExpandableContent(box);

            myAlert.setHeaderText("Contents");
            myAlert.setTitle("Viewing file contents");
            myAlert.setContentText("Here are the contents of the file you selected: ");
            myAlert.showAndWait();

         
    }
        
        public void handleView5(String fileName) throws IOException, ZipException{ // handels view 
            //System.out.println("./work/"+app.getGUI().getCodeCheckName()+"/Blackboard/"+fileName);
            Alert myAlert = new Alert(Alert.AlertType.INFORMATION);

            TextArea contentsArea = new TextArea();

            contentsArea.setWrapText(true);

            contentsArea.setMaxHeight(Double.MAX_VALUE);
            contentsArea.setMaxWidth(Double.MAX_VALUE);

            GridPane.setVgrow(contentsArea, Priority.ALWAYS);
            GridPane.setHgrow(contentsArea, Priority.ALWAYS);
            GridPane box = new GridPane();

            box.setMaxHeight(Double.MAX_VALUE);
            box.add(contentsArea, 0, 0);

            File fileToView = new File("./work/" + app.getGUI().getCodeCheckName() + "/SourceCode/" + fileName);

            List<File> theFiles = (List<File>) FileUtils.listFiles(fileToView, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
            
            for(int i=0; i<theFiles.size(); i++){
                contentsArea.appendText(theFiles.get(i).getName() + "\n");
            }

            contentsArea.setEditable(false);

            myAlert.getDialogPane().setExpandableContent(box);

            myAlert.setHeaderText("Contents");
            myAlert.setTitle("Viewing file contents");
            myAlert.setContentText("Here are the contents of the file you selected: ");
            myAlert.showAndWait();

         
    }      
    
}