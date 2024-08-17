package org.example;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.ArrayList;
import java.util.List;

//Обрабатываем параметры коммандной строки и сохраняем в статические переменные
public class AnalysisParametr {
    public static List<String> listfiles = new ArrayList<>();    //список файлов

    public List<String> getListfiles() {
        return listfiles;
    }  //геттер

    //Files
    static String patchAn;                           //Путь
    static String prefixAn;                          //Префикс имени
    static boolean rewrite;                         //Флаг добавления/перезаписи в файлы
    static boolean statbrief;                       //Флаг краткая статистика
    static boolean statfull;                        //Полная статистика


    public void analisys(String[] argsAnalysis) {

        try {
            Param jArgs = new Param();                  //Структура для разбора парамтров коман.строки
            JCommander paramCmd = JCommander.newBuilder()
                    .addObject(jArgs)
                    .build();
            paramCmd.parse(argsAnalysis);               //Передаем в построенный обьект наши параметры


            listfiles = jArgs.getFiles();                     //Список фалов
            patchAn = jArgs.getPatchresult();                 //Путь
            prefixAn = jArgs.getPrefix();                       //Префикс имени
            rewrite = jArgs.isA();                              //Перезапись
            statbrief = jArgs.isS();                            //Статистика краткая
            statfull = jArgs.isF();                             //Статистика полная
        } catch (ParameterException e) {                        //Если что то не так выводим сообщение
            System.out.println(e.getMessage());
        }
    }
}
