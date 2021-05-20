package lotto.ui.output;

public class GameOutput implements Output {

    @Override
    public void println(String text) {
        System.out.println(text);
    }

    @Override
    public void print(String text) {
        System.out.print(text);
    }
}
