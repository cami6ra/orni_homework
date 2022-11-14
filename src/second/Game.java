package second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    // заданное пользователем количество попыток
    int givenAttempts;
    // номер текущей попытки
    int actualAttemptsNumber;
    // разница между сгенерерованным числом и введенным пользователем
    int difference;
    //сгенерированное компьютером значение
    int generatedValue;
    // число пользователя
    int guessedValue;

    Computer computer = new Computer();
    Scanner scan = new Scanner(System.in);

    //меню
    void startGame() throws FileNotFoundException {
        String file = "src/second/text";
        Scanner scanner = new Scanner(new File(file));

        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            System.out.println(text);
        }

        //обнуляем с каждой новой игрой
        actualAttemptsNumber = 1;

        getAttemptsCount();
        generateNumber();
        play();
    }

    // запрос на количество попыток
    void getAttemptsCount() {
        System.out.print("Введи количество попыток (значение должно быть натуральным числом): ");
        try {
            givenAttempts = scan.nextInt();
            if (givenAttempts > 0) {
                printAnswer(computer.sayFirstPhrase(givenAttempts));
            } else {
                System.out.println("Число должно быть натуральным. Повтори ввод.");
                printStripe();
                getAttemptsCount();
            }
        } catch (Exception e) {
            System.out.println("Символы и буквы недопустимы. Повтори ввод.");
            printStripe();
            scan.next();
            getAttemptsCount();
        }
    }

    public String printActualAttemptsNumber(int actualAttemptsNumber) {
        return "                                                                               Осталось попыток: " + (actualAttemptsNumber + 1);
    }

    //разделители в консоли
    private void printStripe() {
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
    }

    //ответы компьютера
    private void printAnswer(String answer) {
        printStripe();
        System.out.println(answer);
        printStripe();
    }

    private int generateNumber() {
        //генерация числа от 1 до 100
//        Random r = new Random();
//        generatedValue = r.nextInt(100) + 1;

//        для тестов
        generatedValue = 55;
        return generatedValue;
    }

    //спрашиваем пользователя о продолжении
    public void askForContinue() throws FileNotFoundException {
        printAnswer(computer.sayPlayAgain());
        if (scan.hasNext()) {
            String answer = scan.next();
            switch (answer) {
                case "n":
                    printAnswer(computer.sayBye());
                    //для выхода из цикла
                    actualAttemptsNumber = givenAttempts + 1;
                    break;
                case "y":
                    startGame();
                    break;
                default:
                    System.out.println("Введите одно из перечисленных значений (y/n)");
                    askForContinue();
            }
        } else System.out.println("первый if не сработал :((");
    }

    void play() throws FileNotFoundException {
        scan = new Scanner(System.in);

        for (; actualAttemptsNumber <= givenAttempts; actualAttemptsNumber++) {

            //выводим номер попытки
            System.out.println(printActualAttemptsNumber(givenAttempts - actualAttemptsNumber));
            System.out.print("Введи число: ");

            if (scan.hasNextInt()) {
                //хранит число игрока
                guessedValue = scan.nextInt();

                //если число попадает в отрезок [1; 100]
                if (guessedValue > 0 && guessedValue < 101) {

                    if (guessedValue != generatedValue) {

                        //замена на switch
                        switch (actualAttemptsNumber) {
                            //первая попытка
                            case 1:
                                difference = Math.abs(guessedValue - generatedValue);

                                // для первой попытки - если число попадает в окрестность = 10
                                if (difference > 10) {
                                    printAnswer(computer.sayCold());
                                } else {
                                    printAnswer(computer.sayHot());
                                }
                                break;

                            //остальные попытки
                            default:
                                int previousDifference = difference;
                                difference = Math.abs(guessedValue - generatedValue);

                                // замена на switch
                                switch (Double.compare(previousDifference, difference)) {
                                    case 0:
                                        printAnswer(computer.saySame());
                                        break;
                                    case 1:
                                        printAnswer(computer.sayHotter());
                                        break;
                                    case -1:
                                        printAnswer(computer.sayColder());
                                        break;
                                }
                                break;
                        }
                        if (actualAttemptsNumber == givenAttempts) {
                            printAnswer(computer.sayLost(generatedValue));
                            askForContinue();
                            break;
                        }
                    } else {
                        printAnswer(computer.sayWon(actualAttemptsNumber));
                        askForContinue();
                        break;
                    }
                } else {
                    System.out.println("Введи натуральное число от 1 до 100.");
                    printStripe();
                    play();
                }
            } else {
                System.out.println("Символы и буквы недопустимы. Повтори ввод.");
                printStripe();
                scan.next();
                play();
            }
        }
    }
}
