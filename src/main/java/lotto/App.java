package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class App {
    public static void main(String[] args) {
//        LottoMachine lottoMachine = new LottoMachine();
//        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTicket(3000);
//
//        System.out.println(lottoTickets.toString());


        int startLotto = InputView.getStartLotto();

        LottoMachine lottoMachine = new LottoMachine();

        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTicket(startLotto);

        OutputView.buyLottoNumberPrint(lottoTickets);
        String s = InputView.winningNumbersInput();


    }
}
