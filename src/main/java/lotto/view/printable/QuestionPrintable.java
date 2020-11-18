package lotto.view.printable;

public class QuestionPrintable extends Printable {
    private final String question;

    public QuestionPrintable(String question) {
        this.question = question;
    }

    @Override
    public void print() {
        println(question);
    }
}
