package step2;

import step2.view.inputView.InputView;
import step2.view.outputView.OutputView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();

        int money = InputView.inputNumber("구입금액을 입력해 주세요.");
        List<Ticket> tickets = lottoGame.makeTickets(money);
        OutputView.printTickets(tickets);

        String winningNumber = InputView.inputString("지난 주 당첨 번호를 입력해 주세요.");
    }
}
