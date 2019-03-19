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
        int amount = InputView.getAmount();

        OutputView.numberOfTickets(amount);


        LottoMachine lottoMachine = new LottoMachine(new LottoRandomNumGenerator());

        List<LottoTicket> lottoTickets = lottoMachine.buyLottoTicket(amount);

        OutputView.buyLottoNumberPrint(lottoTickets);

//        List<Integer> winningNumber = InputView.getwinningNumber();




//        OutputView.printWinningNumber(winningNumber);


    }
}
