package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> datalist = new ArrayList<>(); //данные из файлов

        AnalysisParametr analyssisParametr = new AnalysisParametr();   //Создаем обьект
        analyssisParametr.analisys(args);                //Передаем все введенные параметры для анализа
        CopyFilestoList copyFilestoList = new CopyFilestoList();
        datalist = copyFilestoList.filestolist(); //Сохраняем все данные из файлов в списке

        ParsingData parsingData = new ParsingData();//передаем данные для парсинга
        parsingData.ParsingD(datalist);            //Парсим каждую строку на long,double,string

    }
}