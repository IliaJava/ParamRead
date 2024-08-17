package org.example;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
                                //Вывод результатов
public class PrintResult {

    private ArrayList<Double> data = new ArrayList<>();
    private final int longcount;     //Число int
    private final int doublecount;   //Число float элементов
    private List<String> datastring = new ArrayList<>();
    private final int stringcount;     //число элементов строк
    double max = Double.MIN_VALUE;
    double min = Double.MAX_VALUE;
    double average;
    double summa;
    String strokamax;
    String strokamin;

    public PrintResult(ArrayList<Double> data, int longcount, int doublecount,
                       List<String> datastring, int stringcount) {
        this.data = data;               //Общий список с целыми и вещ.числами
        this.longcount = longcount;       //число элементов int
        this.doublecount = doublecount;   //Число элементов double
        this.datastring = datastring;     // Список строк
        this.stringcount = stringcount;   //Число строк
        resultconsole();

    }

    void resultconsole() {
        if (AnalysisParametr.statbrief) {
            System.out.println("Число элементов в файле integer.txt:" + " " + longcount);
            System.out.println("Число элементов в файле float.txt:" + " " + doublecount);
            System.out.println("Число элементов в файле string.txt:" + " " + stringcount);
        } else if (AnalysisParametr.statfull) {
            if (data.size() <= 1) {
                System.out.println("Для полной статистики недостаточно данных int и loat");
            } else {

                System.out.println("Число элементов в файле integer.txt:" + " " + longcount);
                System.out.println("Число элементов в файле float.txt:" + " " + doublecount);
                System.out.println("Число элементов в файле string.txt:" + " " + stringcount);
                for (double value : data) {
                    max = value > max ? value : max;
                    min = value < min ? value : min;
                    summa = summa + value;
                }
                average = summa / data.size();
                System.out.println("Максимальное число:" + " " + NumberFormat.getInstance().format(max));
                System.out.println("Среднее число:" + " " + NumberFormat.getInstance().format(average));
                System.out.println("Сумма всех чисел:" + " " + NumberFormat.getInstance().format(summa));
            }
            if (stringcount <= 1) {
                System.out.println("Для полной статистики недостаточно данных string");
            } else {
                strokamax = strokamin = datastring.get(0);
                for (String value :
                        datastring) {
                    strokamax = strokamax.length() < value.length() ? value : strokamax;
                    strokamin = strokamin.length() > value.length() ? value : strokamin;
                }
                System.out.println("Максимальная строка из " + strokamax.length() + " элементов: " + strokamax);
                System.out.println("Минимальная строка из " + strokamin.length() + " элементов: " + strokamin);

            }


        }
    }

}
