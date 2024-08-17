package org.example;

import com.beust.jcommander.Parameter;
//Разбор всех введных параметров и создания геттеров
//  для вызова
import java.util.ArrayList;
import java.util.List;

public class Param {
    @Parameter(
            description = "Files",              //Введенные имена файлов
            required = true)
    private List<String> files = new ArrayList<>();

    public List<String> getFiles() {
        return files;
    }
    //***********************


    //***********************

    @Parameter(
            names = "-o",
            description = "Patch"                //Путь
            //required = true
    )
    private String patchresult = "";

    public String getPatchresult() {
        return patchresult;
    }

    //***********************
    @Parameter(
            names = "-p",
            description = "Prefix name")           //Префикс имени
    private String prefix = "";

    public String getPrefix() {
        return prefix;
    }

    //***********************
    @Parameter(
            names = "-a",
            description = "rewrite")                    //Флаг перезаписи
    private boolean a = false;

    public boolean isA() {                          //Getter rewrite
        return a;
    }

    //***********************
    @Parameter(
            names = "-s",
            description = "Statics brief")          //Краткая статистика
    private boolean s = false;

    public boolean isS() {                          //Getter statics
        return s;
    }

    //***********************
    @Parameter(
            names = "-f",
            description = "Statics full")          //Полная статистика
    private boolean f = false;

    public boolean isF() {                          //Getter statics full
        return f;
    }
}
