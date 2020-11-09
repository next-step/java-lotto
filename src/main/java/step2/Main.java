package step2;

import step2.controller.LottoController;
import step2.domain.lotto.LottoTicketMachine;
import step2.domain.lotto.LottoTickets;
import step2.domain.lotto.WinningNumber;
import step2.strategy.LottoNumberMakeStrategy;
import step2.view.InputView;
import step2.view.LottoInputView;
import step2.view.LottoResultView;
import step2.view.ResultView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.ticketing();
    }
}
