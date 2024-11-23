package main;


import client.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;
import java.util.Arrays;

/**
 * @author Kalud
 * @website pixelskider.github.io/
 * @since 2024/11/22
 */
public class Config {
    public static String getPath(){
        return System.getProperty("user.dir");
    }
    private final File configFile = new File(getPath() + "\\config.txt");
    public Boolean iconBoolean = false,taskBarBoolean = false,stateBoolean = false;
    public Boolean init(){
        if (!configFile.exists()){
            Logger.error("Config File Not Exist");
            try {
                if (configFile.createNewFile()){
                    Logger.info("Config File Create Successfully");
                    saveConfig();
                    return true;
                }else {
                    Logger.error("Config File Create Successfully");
                    return false;
                }
            } catch (IOException e) {
                Logger.error("Config File Create Unsuccessfully");
                Logger.error(e.getMessage());
                return false;
            }
        }else {
            Logger.info("Config File Exist");
            return true;
        }
    }

    public void readConfig(){
        try {
            FileInputStream fileInputStream = new FileInputStream(configFile);
            int i;
            StringBuilder read = new StringBuilder();
            while ((i=fileInputStream.read()) != -1){
                read.append((char) i);
            }
            JsonObject resultObject = new Gson().fromJson(read.toString(),JsonObject.class);
            iconBoolean = resultObject.get("Icon").getAsBoolean();
            taskBarBoolean = resultObject.get("TaskBar").getAsBoolean();
        } catch (FileNotFoundException e) {
            Logger.error("Config File NotFound");
        } catch (IOException e) {
            Logger.error("Config File Read Unsuccessfully");
        }
    }

    public void saveConfig() {
        try {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Icon",iconBoolean);
            jsonObject.addProperty("TaskBar",taskBarBoolean);
            FileOutputStream fileOutputStream = new FileOutputStream(configFile);
            fileOutputStream.write(jsonObject.toString().getBytes(),0,jsonObject.toString().getBytes().length);
        } catch (FileNotFoundException e) {
            Logger.error("Config File NotFound");
        } catch (IOException e) {
            Logger.error("Config File Read Unsuccessfully");
        }

    }
}
