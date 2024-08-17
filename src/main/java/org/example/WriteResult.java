package org.example;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class WriteResult implements WriteInFile {
    String patchnamefile;

    private String stroka;
    private String namefile;
    private boolean flag;

    public void writeinfile(String stroka, String namefile, boolean flag) {
        this.stroka = stroka;   //Получаем строку данных
        this.namefile = namefile; //Имя файла
        this.flag = flag;       //Флаг добавления и перезаписи

            //Если путь пустой то имя это просто префикс
        if ((AnalysisParametr.patchAn) == "") patchnamefile = AnalysisParametr.prefixAn;//
        else
            patchnamefile = AnalysisParametr.patchAn + "/" + AnalysisParametr.prefixAn; //Путь до файла

        try {


            FileWriter writer = new FileWriter(patchnamefile + namefile, flag);//создаем и записываем в файл
            writer.write(this.stroka + "\n");
            writer.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
