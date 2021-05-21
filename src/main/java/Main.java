import step3.game.Lotto;
import step3.io.InputView;
import step3.io.ResultView;
import step3.io.impl.ConsoleInputView;
import step3.io.impl.ConsoleResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();
        Lotto lotto = new Lotto(inputView, resultView);
        lotto.buy();
    }

}
