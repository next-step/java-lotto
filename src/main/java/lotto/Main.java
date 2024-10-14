package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        JavaLotto javaLotto = new JavaLotto(new InputView(), new ResultView());
        javaLotto.playLotto();
    }
}
