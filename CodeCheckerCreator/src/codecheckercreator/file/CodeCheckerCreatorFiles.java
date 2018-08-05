/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codecheckercreator.file;

import codecheckercreator.CodeCheckerCreatorApp;
import codecheckercreator.data.CodeCheckerCreatorData;
import djf.components.AppDataComponent;
import djf.components.AppFileComponent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;


/**
 *
 * @author joelgeorge
 */
public class CodeCheckerCreatorFiles implements AppFileComponent{
    
    CodeCheckerCreatorApp app;
    
    static final String JSON_FILES = "files";
    static final String JSON_FILES2 = "files2";
    static final String JSON_FILES3 = "files3";
    static final String JSON_FILES4 = "files4";
    static final String JSON_FILES5 = "files5";
    static final String JSON_FILESTEMP = "tempForStep";
    
    static final String JSON_FILE_NAME = "file_name";
    static final String JSON_FILE_NAME2 = "file_name2";
    static final String JSON_FILE_NAME3 = "file_name3";
    static final String JSON_FILE_NAME4 = "file_name4";
    static final String JSON_FILE_NAME5 = "file_name5";
    static final String JSON_FILE_NAMET = "file_nameT";
    
    static final String JSON_PATH = "path";
    static final String JSON_CCNAME = "codeCheckNames";
    static final String JSON_THENAME = "name";
    public String CCC;
    
    public CodeCheckerCreatorFiles(CodeCheckerCreatorApp initApp){
        
        app=initApp;
    }
    
     @Override
    public void loadData(AppDataComponent data, String filePath) throws IOException {
        
        // LOAD THE JSON FILE WITH ALL THE DATA
	JsonObject json = loadJSONFile(filePath);

	// CLEAR THE OLD DATA OUT
	CodeCheckerCreatorData dataManager = (CodeCheckerCreatorData)data;
        dataManager.resetData();

        // NOW LOAD ALL THE DATA FROM THE json OBJECT
        
        //STEP 1
        JsonArray jsonSlidesArray = json.getJsonArray(JSON_FILES); 
        for (int i = 0; i < jsonSlidesArray.size(); i++) {
            JsonObject jsonSlide = jsonSlidesArray.getJsonObject(i);
            String fileName = jsonSlide.getString(JSON_FILE_NAME);
            //CCC= app.getGUI().getCodeCheckName();
            //String path = jsonSlide.getString(JSON_PATH);
            
            dataManager.addFile(fileName);
            //dataManager.addFilePath(path);
            
        }
        
        //STEP 2
        
        JsonArray jsonFiles2Array = json.getJsonArray(JSON_FILES2); 
        for (int i = 0; i < jsonFiles2Array.size(); i++) {
            JsonObject jsonSlide2 = jsonFiles2Array.getJsonObject(i);
            String fileName2 = jsonSlide2.getString(JSON_FILE_NAME2);
            //CCC= app.getGUI().getCodeCheckName();
            //String path = jsonSlide.getString(JSON_PATH);
            
            dataManager.addFile2(fileName2);
            //dataManager.addFilePath(path);
            
        }
        
        
        JsonArray jsonFiles4Array = json.getJsonArray(JSON_FILES4); 
        for (int i = 0; i < jsonFiles4Array.size(); i++) {
            JsonObject jsonSlide4 = jsonFiles4Array.getJsonObject(i);
            String fileName4 = jsonSlide4.getString(JSON_FILE_NAME4);
            //CCC= app.getGUI().getCodeCheckName();
            //String path = jsonSlide.getString(JSON_PATH);
            
            dataManager.addFile4(fileName4);
            //dataManager.addFilePath(path);
            
        }
        
        //STEP 5
        
        JsonArray jsonFiles5Array = json.getJsonArray(JSON_FILES5); 
        for (int i = 0; i < jsonFiles5Array.size(); i++) {
            JsonObject jsonSlide5 = jsonFiles5Array.getJsonObject(i);
            String fileName5 = jsonSlide5.getString(JSON_FILE_NAME5);
            //CCC= app.getGUI().getCodeCheckName();
            //String path = jsonSlide.getString(JSON_PATH);
            
            dataManager.addFile5(fileName5);
            //dataManager.addFilePath(path);
            
        }

        // CC NAME
        JsonArray jsonNamesArray = json.getJsonArray(JSON_CCNAME);
        
        for (int i = 0; i < jsonNamesArray.size(); i++) {
            JsonObject jsonSlide2 = jsonNamesArray.getJsonObject(i);
            
            
            String CCName = jsonSlide2.getString(JSON_CCNAME);
            //System.out.println(CCName);
            
            app.getGUI().returnWelcomeLabel().setText(CCName);
            app.getGUI().setName(CCName);
            //dataManager.addFilePath(path);
            
        }
        
        app.returnCodeCheckerCreatorWorkspace().getnextButton().setDisable(false);
//        app.returnCodeCheckerCreatorWorkspace().getRemove1Button().setDisable(false);
//        app.returnCodeCheckerCreatorWorkspace().getView1Button().setDisable(false);
        
    }
      
    // HELPER METHOD FOR LOADING DATA FROM A JSON FORMAT
    private JsonObject loadJSONFile(String jsonFilePath) throws IOException {
	InputStream is = new FileInputStream(jsonFilePath);
	JsonReader jsonReader = Json.createReader(is);
	JsonObject json = jsonReader.readObject();
	jsonReader.close();
	is.close();
	return json;
    }
   

    @Override
    public void saveData(AppDataComponent data, String filePath) throws IOException {
        
        CodeCheckerCreatorData dataManager = (CodeCheckerCreatorData)data;

	// NOW BUILD THE SLIDES JSON OBJECTS TO SAVE
        
        //STEP ONE
	JsonArrayBuilder slidesArrayBuilder = Json.createArrayBuilder();
	ObservableList<String> files = dataManager.getFiles();
	for (String file : files) {	    
	    JsonObject slideJson = Json.createObjectBuilder()
		    .add(JSON_FILE_NAME, file)
                    //.add(JSON_PATH, slide.getPath())
                   .build();
	    slidesArrayBuilder.add(slideJson);
	}
	JsonArray slidesArray = slidesArrayBuilder.build();
        
        // STEP 2
        JsonArrayBuilder files2Builder = Json.createArrayBuilder();
	ObservableList<String> files2 = dataManager.getFiles2();
	for (String file : files2) {	    
	    JsonObject slideJson2 = Json.createObjectBuilder()
		    .add(JSON_FILE_NAME2, file)
                    //.add(JSON_PATH, slide.getPath())
                   .build();
	    files2Builder.add(slideJson2);
	}
	JsonArray files2Array = files2Builder.build();

        
        JsonArrayBuilder files4Builder = Json.createArrayBuilder();
	ObservableList<String> files4 = dataManager.getFiles4();
	for (String file : files4) {	    
	    JsonObject slideJson4 = Json.createObjectBuilder()
		    .add(JSON_FILE_NAME4, file)
                    //.add(JSON_PATH, slide.getPath())
                   .build();
	    files4Builder.add(slideJson4);
	}
	JsonArray files4Array = files4Builder.build();
        
        //STEP 5
        
        JsonArrayBuilder files5Builder = Json.createArrayBuilder();
	ObservableList<String> files5 = dataManager.getFiles5();
	for (String file : files5) {	    
	    JsonObject slideJson5 = Json.createObjectBuilder()
		    .add(JSON_FILE_NAME5, file)
                    //.add(JSON_PATH, slide.getPath())
                   .build();
	    files5Builder.add(slideJson5);
	}
	JsonArray files5Array = files5Builder.build();
        

        //CC NAME
       JsonArrayBuilder nameBuilder = Json.createArrayBuilder(); 
       JsonObject nameJson = Json.createObjectBuilder()
		    .add(JSON_CCNAME, app.getGUI().getCodeCheckName())
                    .build();
       nameBuilder.add(nameJson);
       
        JsonArray NameArray= nameBuilder.build();
        
	// THEN PUT IT ALL TOGETHER IN A JsonObject
        
	JsonObject dataManagerJSO = Json.createObjectBuilder() 
                .add(JSON_FILES, slidesArray)
                .add(JSON_FILES2, files2Array)
                .add(JSON_FILES4, files4Array)
                .add(JSON_FILES5, files5Array)
                //.add(JSON_FILESTEMP, filesTArray)
                .add(JSON_CCNAME, NameArray)
		.build();
       
     
	// AND NOW OUTPUT IT TO A JSON FILE WITH PRETTY PRINTING
	Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
	StringWriter sw = new StringWriter();
	JsonWriter jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(dataManagerJSO);
        //jsonWriter.writeObject(dataManagerJSO2);
	jsonWriter.close();

	// INIT THE WRITER
	OutputStream os = new FileOutputStream(filePath);
	JsonWriter jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(dataManagerJSO);
        //jsonFileWriter.writeObject(dataManagerJSO2);
	String prettyPrinted = sw.toString();
	PrintWriter pw = new PrintWriter(filePath);
	pw.write(prettyPrinted);
	pw.close();
	
    }
    
    @Override
    public void importData(AppDataComponent data, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportData(AppDataComponent data, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}