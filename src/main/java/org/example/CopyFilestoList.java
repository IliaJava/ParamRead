package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyFilestoList {
    List<String> datafile = new ArrayList<>();           //список данных из файлов
    List<BufferedReader> br = new ArrayList<>();          //бегунок чтения
    AnalysisParametr dataparam = new AnalysisParametr();    //переменная с данными ввода
    String line;

    public List<String> filestolist() {

        try {
            for (String filename : AnalysisParametr.listfiles)         //проходим по списку имен файлов
                br.add(new BufferedReader(new FileReader(filename)));   //открываем для чтения
                                                                        // (можно не закрывать try-resourse)

            boolean flag;
//Читаем по всем файлам по всем строчкам,пока все строчки не будут NULL или пустые
//    тогда flag=false и выходим из цикла
            do {
                flag = false;
                int nomerfile = 0;                                      //номер файла
                for (String filename : AnalysisParametr.listfiles) {   //по файлам по каждой строчке
                    if ((line = br.get(nomerfile).readLine()) != null) {
                        flag = true;               //если хотя бы одна строчка не пустая
                        datafile.add(line);         //Сохраняем по строчно в список
                        nomerfile++;                                    //следующий файл
                    }
                }
            }
            while (flag);

        } catch (IOException e) {                        //Если недопустимые параметры-выходим
            System.out.println(e.getMessage());
            System.out.println("Недопустимые параметры");
            System.out.println("Попробуйте запустить с другими параметрами");
            System.exit(0);
        }
        return datafile;                      //Возвращаем все данные из файлов в списке
    }

}
