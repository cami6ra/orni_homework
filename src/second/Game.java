package second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    int n;
    int dif;
    int k;
    int i;
    int generated_value;

    Computer computer = new Computer();
    Scanner scan = new Scanner(System.in);

    //меню
    void startGame() throws FileNotFoundException {
        String file = "src/second/text";
        Scanner scanner = new Scanner(new File(file));
        i = 0;
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            System.out.println(text);
        }
        getAttemptsCount();
        play();
    }

    // запрос на количество попыток
    void getAttemptsCount() {
        System.out.print("Введи количество попыток (значение должно быть натуральным числом): ");
        try {
            n = scan.nextInt();
            if (n > 0) {
                printAnswer(computer.sayFirstPhrase(n));
                k = n;
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

    public String printRemainingAttempts(int k) {
        return "Осталось попыток: " + (k - 1);
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
        Random r = new Random();
        generated_value = r.nextInt(100) + 1;

        //для тестов
//        generated_value = 55;

        return generated_value;
    }

    //спрашиваем пользователя о продолжении
    public void askForContinue() throws FileNotFoundException {
        printAnswer(computer.sayPlayAgain());
        if (scan.hasNext()) {
            String answer = scan.next();

            switch (answer) {
                case "n":
                    printAnswer(computer.sayBye());
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

    void play() {
        generateNumber();

        Scanner scan = new Scanner(System.in);

        for (; i < n; i++) {

            System.out.print("Введи число: ");

            try {
                //хранит число игрока
                int guessed_value = scan.nextInt();

                //если число попадает в отрезок [1; 100]
                if (guessed_value > 0 && guessed_value < 101) {
                    if (guessed_value != generated_value) {

                        //если это не первая попытка
                        if (i > 0) {
                            int prev_dif = dif;
                            dif = Math.abs(guessed_value - generated_value);

                            // если предыдущее число было дальше загаданного
                            if (prev_dif > dif) {
                                System.out.println(printRemainingAttempts(k));
                                printAnswer(computer.sayHotter());
                            }

                            //если предыдущее число так же близко, как новое
                            else if (prev_dif == dif) {
                                System.out.println(printRemainingAttempts(k));
                                printAnswer(computer.saySame());
                            }

                            //если предыдущее число ближе к загаданному
                            else {
                                System.out.println(printRemainingAttempts(k));
                                printAnswer(computer.sayColder());
                            }
                        }

                        // если первая попытка
                        else {
                            //выводим оставшиеся попытки
                            System.out.println(printRemainingAttempts(k));

                            //вычитаем из догадки загаданное, чтобы запомнить
                            dif = Math.abs(guessed_value - generated_value);

                            // для первой попытки - если число попадает в окрестность = 10
                            if (dif > 10) {
                                //довольно холодно
                                printAnswer(computer.sayCold());
                            } else {
                                //довольно тепло
                                printAnswer(computer.sayHot());
                            }
                        }

                        //потраченная попытка вычитается из счетчика
                        k -= 1;

                        //если осталось 0 попыток - объявляем проигрыш
                        if (k == 0) {
                            printAnswer(computer.sayLost(generated_value));
                            askForContinue();
                            break;
                        }

                    } else {
                        printAnswer(computer.sayWon(i + 1));
                        askForContinue();
                        break;
                    }
                } else {
                    System.out.println("Введи натуральное число от 1 до 100.");
                    printStripe();
                    play();
                }
            } catch (Exception e) {
                System.out.println("Символы и буквы недопустимы. Повтори ввод.");
                printStripe();
                scan.next();
                play();
            }
        }
    }
}
