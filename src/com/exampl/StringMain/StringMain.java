//Написать класс, в котором как поле объявлен массив строк. Вводим количество строк с консоли.
// Организовать ввод строк с консоли до тех пор, пока в какой-то строке не встретится слово end,
// остальные строки заполняются цифрами = номер строки. Отсортируйте строки по длине. Определите,
// есть ли среди строк одинаковые. Выведите 3 последних элемента самой длинной строки.
// Преобразуйте 2 строку к верхнему регистру. Разделите самую длинную строку на слова.
// Определить является ли второй символ самой короткой строки цифрой.
package com.exampl.StringMain;

import java.util.Scanner;

public class StringMain {
    private String[] stringMass;
    private String[] stringWorld;
    private int num, x = 0;

    public static void main(String[] args) {
        StringMain r = new StringMain();
        r.initArray();
        r.sortStr();
        r.write();
        r.compare();
        r.thryElements();
        r.toUp();
        r.words();
        r.toNumber();
    }

    private void initArray() {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число строк: ");
        if (sc.hasNextInt()) {
            num = sc.nextInt();
            x = num;
        }
        stringMass = new String[num + 1];

        System.out.print("Введите  строку: ");
        int b = 0;
        for (int i = 0; i < stringMass.length; i++) {
            if (b != 1) {
                stringMass[i] = sc.nextLine();
                if (stringMass[i].endsWith("end")) {
                    b = 1;
                }
            } else {
                stringMass[i] = "" + i;
            }
        }
    }

    private void write() {
        for (String stringMass1 : stringMass) {
            System.out.println(stringMass1);
        }
    }

    private void thryElements() {
        num = x;
        x = stringMass[x].length();
        System.out.println(stringMass[num].substring(x - 3, x));
    }

    private void compare() {
        for (int j = 1; j < stringMass.length; j++) {
            if (stringMass[j - 1].length() == stringMass[j].length()) {

                System.out.println("Строка " + (j - 1) + " и строка " + j + " одинаковы");
            }
        }
    }

    private void toUp() {
        System.out.println(stringMass[2].toUpperCase());
    }

    private void words() {
        stringWorld = new String[3];
        stringWorld = stringMass[num].split("g", 3);
        for (int i = 0; i < stringWorld.length; i++) {
            System.out.print(stringWorld[i] + " ");
        }
    }

    private void toNumber() {
        System.out.println();
        Character chr = stringMass[1].charAt(1);

        if (Character.isDigit(chr)) {
            System.out.println("Второй элемент цифра");
        }

    }

    private void sortStr() {
        String str = "";
        for (int i = 1; i < stringMass.length; i++) {
            for (int j = 1; j < stringMass.length; j++) {
                if (stringMass[j - 1].length() > stringMass[j].length()) {
                    str = stringMass[j - 1];
                    stringMass[j - 1] = stringMass[j];
                    stringMass[j] = str;
                }
            }
        }
    }
}
