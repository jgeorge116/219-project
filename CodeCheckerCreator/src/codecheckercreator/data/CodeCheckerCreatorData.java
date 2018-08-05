/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheckercreator.data;

import codecheckercreator.CodeCheckerCreatorApp;
import djf.components.AppDataComponent;
import java.io.File;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joelgeorge
 */
public class CodeCheckerCreatorData implements AppDataComponent{
    
    CodeCheckerCreatorApp app;
    ObservableList<String> files;
    ObservableList<String> filesStep2;
    ObservableList<String> filesStep3;
    ObservableList<String> filesStep4;
    ObservableList<String> filesStep5;
    ArrayList<String> filePaths;
    ArrayList<File> actualFiles;
    
    ObservableList<String> tempForStep;
//    String fileName;
//    String filePath;
    
    
    public CodeCheckerCreatorData(CodeCheckerCreatorApp initApp){
        app=initApp;
        files= FXCollections.observableArrayList();
        filesStep2=FXCollections.observableArrayList();
        filesStep3=FXCollections.observableArrayList();
        filesStep4=FXCollections.observableArrayList();
        filesStep5=FXCollections.observableArrayList();
        tempForStep=FXCollections.observableArrayList();
        filePaths= new ArrayList<>();
        actualFiles= new ArrayList<>();
        //addFile();
    }
    
    //File names
    public ObservableList getFiles(){
        return files;
    }
    public ObservableList getFiles2(){
        return filesStep2;
    }
    
    public ObservableList getFiles3(){
        return filesStep3;
    }
    
    public ObservableList getFiles4(){
        return filesStep4;
    }
    
    public ObservableList getFiles5(){
        return filesStep5;
    }
    
    public ArrayList getFilePaths(){
        return filePaths;
    }
    
    public ArrayList getACTUALFile(){
        return actualFiles;
    }
    
    public ObservableList getTempForStep(){
        return tempForStep;
    }
    
    
    
    
    
//    public String getFileName(File file){
//        return file.getName();
//    }
//    
//    public String getFilePath(File file){
//        return file.getPath();
//    }
    
    @Override
    public void resetData() {
        files.clear();
    }
    
//    public void addFile(File fileToAdd){
//        files.add(fileToAdd);
//    }
    @Override
    public void addFile(String fileNameToAdd){
        files.add(fileNameToAdd);

    }
    
    public void addFile2(String fileNameToAdd){
        filesStep2.add(fileNameToAdd);

    }
    
    public void addFile3(String fileNameToAdd){
        filesStep3.add(fileNameToAdd);

    }
    
    public void addFile4(String fileNameToAdd){
        filesStep4.add(fileNameToAdd);

    }
    
    public void addFile5(String fileNameToAdd){
        filesStep5.add(fileNameToAdd);

    }
    
    public void addTempForStep(String fileNameToAdd){
        tempForStep.add(fileNameToAdd);

    }
    
    
    public void addFilePath(String filePath){
        filePaths.add(filePath);
    }
    
    public void addACTUALFile(File actualFile){
        actualFiles.add(actualFile);
    }
    
}