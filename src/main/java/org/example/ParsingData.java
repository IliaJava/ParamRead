package org.example;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParsingData {
    private List<String> datalistparsing = new ArrayList<>();   //Список с данными
    private final List<String> datastring = new ArrayList<>();  //Список строк
    private boolean flagl, flagd, flags = false;
    private final ArrayList<Double> data = new ArrayList<>(); //Массив double +long общий
    private int longcount = 0;
    private int doublecount = 0;
    private int stringcount = 0;     //число элементов в файлах
    private Long resultlong;       //Переменные для проверки парсинга
    private Double resultdouble;
    private String resultstring;

    public void ParsingD(List<String> datalistparsing) {
        this.datalistparsing = datalistparsing;   //приняли данные для анализа
        if (!StringUtils.isBlank(AnalysisParametr.patchAn)) {//есть ли путь проверка на null и пробелы
            Path dir = Paths.get(AnalysisParametr.patchAn);   //анализируем
            if (Files.notExists(dir)) {                  //если директории не существует,создаем ее
                try {
                    Files.createDirectories(dir);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        if (AnalysisParametr.rewrite) flagl = flagd = flags = true;  //флаг перезаписи
        WriteInFile interwitefile = new WriteResult();     //переменная интерфейса записи в файл
        for (String stroka :
                datalistparsing) {
            try {
                resultlong = Long.parseLong(stroka);
                data.add((double) resultlong);         //сохраняем в общий массив числа
                longcount++;                         //число элементов в integer
                interwitefile.writeinfile(stroka, "integer.txt", flagl);
                flagl = true;
                continue;

            } catch (NumberFormatException e) {
            }
            try {
                resultdouble = Double.parseDouble(stroka);
                data.add(resultdouble);                     //сохраняем в общий массив числа
                doublecount++;                          //число элементов в double
                interwitefile.writeinfile(stroka, "double.txt", flagd);
                flagd = true;
                continue;

            } catch (NumberFormatException e) {
            }
            if (stroka != null && !stroka.trim().isEmpty()) {  //проверка на пробелы и пустую строку
                stringcount++;
                datastring.add(stroka);                             //сохраняем строки в список
                interwitefile.writeinfile(stroka, "string.txt", flags);
                flags = true;
            }
        }
        new PrintResult(data, longcount, doublecount, datastring, stringcount);  //Создаем оьбект вывода результата

    }
}
