package lotto.application;

public class Main {

    public static void main(String[] args) {
        new Broadcast(new InputView(), new OutputView()).play();
    }
}
