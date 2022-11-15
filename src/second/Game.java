package second;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.ResourceBundle;
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

    ResourceBundle rb;

    Language language = new Language();
    Computer computer = new Computer();
    Scanner scan = new Scanner(System.in);

    //меню
    void startGame() throws FileNotFoundException, UnsupportedEncodingException {
        rb = language.chooseLanguage();

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
        System.out.print(language.encodeText(rb, "attempts.request"));
        try {
            givenAttempts = scan.nextInt();
            if (givenAttempts > 0) {
                printAnswer(computer.sayFirstPhrase(rb, givenAttempts));
            } else {
                System.out.println(language.encodeText(rb, "warning.natural"));
                printStripe();
                getAttemptsCount();
            }
        } catch (Exception e) {
            System.out.println(language.encodeText(rb, "warning.symbol"));
            printStripe();
            scan.next();
            getAttemptsCount();
        }
    }

    public String printActualAttemptsNumber(int actualAttemptsNumber) {
        return language.encodeText(rb, "attempts.remained") + (actualAttemptsNumber + 1);
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
    public void askForContinue() throws FileNotFoundException, UnsupportedEncodingException {
        printAnswer(computer.sayPlayAgain(rb));
        if (scan.hasNext()) {
            String answer = scan.next();
            switch (answer) {
                case "n":
                    printAnswer(computer.sayBye(rb));
                    //для выхода из цикла
                    actualAttemptsNumber = givenAttempts + 1;
                    break;
                case "y":
                    startGame();
                    break;
                default:
                    System.out.println(language.encodeText(rb, "warning.continue"));
                    askForContinue();
            }
        } else System.out.println("первый if не сработал :((");
    }

    void play() throws FileNotFoundException, UnsupportedEncodingException {
        scan = new Scanner(System.in);

        for (; actualAttemptsNumber <= givenAttempts; actualAttemptsNumber++) {

            //выводим номер попытки
            System.out.println(printActualAttemptsNumber(givenAttempts - actualAttemptsNumber));
            System.out.print(language.encodeText(rb, "number.request"));

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
                                    printAnswer(computer.sayCold(rb));
                                } else {
                                    printAnswer(computer.sayHot(rb));
                                }
                                break;

                            //остальные попытки
                            default:
                                int previousDifference = difference;
                                difference = Math.abs(guessedValue - generatedValue);

                                // замена на switch
                                switch (Double.compare(previousDifference, difference)) {
                                    case 0:
                                        printAnswer(computer.saySame(rb));
                                        break;
                                    case 1:
                                        printAnswer(computer.sayHotter(rb));
                                        break;
                                    case -1:
                                        printAnswer(computer.sayColder(rb));
                                        break;
                                }
                                break;
                        }
                        if (actualAttemptsNumber == givenAttempts) {
                            printAnswer(computer.sayLost(rb, generatedValue));
                            askForContinue();
                            break;
                        }
                    } else {
                        printAnswer(computer.sayWon(rb));
                        askForContinue();
                        break;
                    }
                } else {
                    System.out.println(language.encodeText(rb, "warning.interval"));
                    printStripe();
                    play();
                }
            } else {
                System.out.println(language.encodeText(rb, "warning.symbol"));
                printStripe();
                scan.next();
                play();
            }
        }
    }
}
