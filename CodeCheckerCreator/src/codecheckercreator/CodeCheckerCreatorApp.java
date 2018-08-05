/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheckercreator;

import codecheckercreator.data.CodeCheckerCreatorData;
import codecheckercreator.file.CodeCheckerCreatorFiles;
import codecheckercreator.workspace.CodeCheckerCreatorWorkspace;
import djf.AppTemplate;
import static javafx.application.Application.launch;



/**
 *
 * @author joelgeorge
 */
//appTemplete (has start method) must extend Application, this class must extend appTemplete
//keep main method here
public class CodeCheckerCreatorApp extends AppTemplate {  
    
    @Override
    public void buildAppComponentsHook() {
        // CONSTRUCT ALL THREE COMPONENTS. NOTE THAT FOR THIS APP
        // THE WORKSPACE NEEDS THE DATA COMPONENT TO EXIST ALREADY
        // WHEN IT IS CONSTRUCTED, SO BE CAREFUL OF THE ORDER
        
        dataComponent = new CodeCheckerCreatorData(this);
        workspaceComponent= new CodeCheckerCreatorWorkspace(this);
        fileComponent = new CodeCheckerCreatorFiles(this);
        
        
        //add file component later
    }
    
    public CodeCheckerCreatorWorkspace returnCodeCheckerCreatorWorkspace(){
       return (CodeCheckerCreatorWorkspace) workspaceComponent;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       
    }
    
}
