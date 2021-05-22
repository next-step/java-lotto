package lotto.ui;

public class StandardOutput implements Output {

    @Override
    public void printLine(String text) {
        System.out.println(text);
    }
}
