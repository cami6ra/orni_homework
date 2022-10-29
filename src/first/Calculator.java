package first;

import java.util.Scanner;

public class Calculator {
    Scanner scanner = new Scanner(System.in);

    //текст
    void printText(){
        System.out.println("                       Калькулятор               ");
        printStripe();
        System.out.println("Выберите операцию (введите номер), где: \n" + "1 - сложение \n" + "2 - вычитание \n" + "3 - умножение  \n" + "4 - деление");
        printStripe();
    }

    //разделители в консоли
    private void printStripe(){
        System.out.println("---------------------------------------------------------------");
    }

    //ввод членов выражения
    private int enterNumber(){
        int n;

        System.out.print("Введите целое число: ");

        if (scanner.hasNextInt()){
            n = scanner.nextInt();
        }
        else {
            System.out.println("Введенное значение не является целым числом. Повторите попытку.");
            printStripe();
            scanner.next();
            n = enterNumber();
        }
        return n;
    }

    //выбор операции
    void chooseOperation(){
        System.out.print("№ операции: ");

        if (scanner.hasNextInt()){
            switch (scanner.nextInt()){
                case 1:
                    System.out.println("Сумма: " + sum(enterNumber(), enterNumber()));
                    break;
                case 2:
                    System.out.println("Разница: " + sub(enterNumber(), enterNumber()));
                    break;
                case 3:
                    System.out.println("Произведение: " + mult(enterNumber(), enterNumber()));
                    break;
                case 4:
                    System.out.println("Частное: " + div(enterNumber(), enterNumber()));
                    break;
                default:
                    System.out.println("Выберите одно из значений, перечисленных выше.");
                    printStripe();
                    chooseOperation();
                    break;
            }
        } else {
            System.out.println("Введенное значение не является целым числом. Повторите попытку.");
            printStripe();
            scanner.next();
            chooseOperation();
        }
    }

    //сумма чисел
    private int sum(int n1, int n2){
        return n1+n2;
    }

    //разница чисел
    private int sub(int n1, int n2){
        return n1-n2;
    }

    //произведение чисел
    private int mult(int n1, int n2){
        return n1*n2;
    }

    //частное чисел
    private int div(int n1, int n2){
        return n1/n2;
    }
}


