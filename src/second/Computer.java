package second;

public class Computer {

    public String sayFirstPhrase(int n) {
        return "                          «Kᴏличᴇᴄтʙᴏ пᴏпытᴏᴋ: " + n + ". Tᴘᴀть ᴄ умᴏм.»";
    }

    public String sayHotter() {
        return "                                            «Tᴇплᴇᴇ.»";
    }

    public String sayColder() {
        return "                                           «Xᴏлᴏдʜᴇᴇ.»";
    }

    public String saySame() {
        return "                                            «Tᴀᴋ жᴇ.»";
    }

    public String sayWon(int i) {
        return "                            «Пᴏздᴘᴀʙляю, ты пᴏбᴇдил. Hᴀ " + i + " пᴏпытᴋᴇ.»";
    }

    public String sayLost(int i) {
        return "                     «Tы пᴘᴏигᴘᴀл. Hᴀдᴇюᴄь, ʙ гᴏлᴏᴄ. 3ᴀгᴀдᴀʜʜᴏᴇ чиᴄлᴏ: " + i + ".»";
    }

    public String sayPlayAgain(){
        return "                                       «Cыгᴘᴀᴇм ᴇщё? (ʏ/ɴ)»";
    }

    public String sayHot(){
        return "                                   «Дᴏᴄтᴀтᴏчʜᴏ тᴇплᴏ, дᴘʏг мᴏй.»";
    }

    public String sayCold(){
        return "                                        «Cлишᴋᴏм xᴏлᴏдʜᴏ.»";
    }

    public String sayBye(){
        return "                                 «Tы этᴏ... 3ᴀxᴏди... Eᴄли чтᴏ...»";
    }

}
