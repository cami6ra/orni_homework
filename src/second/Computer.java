package second;

import java.util.ResourceBundle;

public class Computer {

    Language language = new Language();

    public String sayHotter(ResourceBundle rb) {
        return language.encodeText(rb, "phrase.hotter");
    }

    public String sayColder(ResourceBundle rb) {
        return language.encodeText(rb, "phrase.colder");
    }

    public String saySame(ResourceBundle rb) {
        return language.encodeText(rb, "phrase.same");
    }

    public String sayWon(ResourceBundle rb) {
        return language.encodeText(rb, "phrase.won");
    }

    public String sayPlayAgain(ResourceBundle rb) {
        return language.encodeText(rb, "phrase.restart");
    }

    public String sayHot(ResourceBundle rb) {
        return language.encodeText(rb, "phrase.hot");
    }

    public String sayCold(ResourceBundle rb) {
        return language.encodeText(rb, "phrase.cold");
    }

    public String sayBye(ResourceBundle rb) {
        return language.encodeText(rb, "phrase.goodbye");
    }

    public String sayLost(ResourceBundle rb, int guessedValue) {
        return language.encodeTextWithNumber(rb, "phrase.lost", guessedValue);
    }

    public String sayFirstPhrase(ResourceBundle rb, int givenAttempts) {
        return language.encodeTextWithNumber(rb, "phrase.first", givenAttempts);
    }

}