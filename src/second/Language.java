package second;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Language {

    ResourceBundle resourceBundle;

    //выбор языка
    public ResourceBundle chooseLanguage(){
        Locale chosenLanguage;

        System.out.println("Выбери язык (введи число) / Choose a language (enter a number): \n1 - ru \n2 - en ");

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int lang = scanner.nextInt();
            switch (lang) {
                case 1:
                    chosenLanguage = new Locale("ru", "RU");
                    resourceBundle = ResourceBundle.getBundle("text", chosenLanguage);
                    break;
                case 2:
                    chosenLanguage = new Locale("en", "US");
                    resourceBundle = ResourceBundle.getBundle("text", chosenLanguage);
                    break;
                default:
                    System.out.println("Некорректное значение. Повтори попытку.");
                    System.out.println("Uncorrect. Try again.");
                    chooseLanguage();
            }
        } else {
            System.out.println("Некорректное значение. Повтори попытку.");
            System.out.println("Uncorrect. Try again.");
            chooseLanguage();
        }
        return resourceBundle;
    }

    public String encodeText(ResourceBundle rb, String key) {
        String s1 = rb.getString(key);
        return new String(s1.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    public String encodeTextWithNumber(ResourceBundle rb, String key, int n) {
        String s1 = rb.getString(key);
        return new String(s1.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8) + n;
    }
}
