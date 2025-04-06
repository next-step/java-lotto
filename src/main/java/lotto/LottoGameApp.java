package lotto;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGameApp {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int money = InputView.receiveMoney();
        int manualTicketCount = InputView.receiveManualTicketCount();
        LottoTickets lottoTickets = new LottoTickets(money, manualTicketCount);
        List<LottoNumbers> manualLottoNumbersList = Arrays.stream(InputView.lottoTickets(lottoTickets.getManualTicketCount()))
                .map(LottoNumbers::new)
                .collect(Collectors.toList());
        Lotto[] lottos = lottoGame.buyLottos(lottoTickets, manualLottoNumbersList);

        OutputView.printBoughtLottos(lottos);

        WinningLotto winningLotto = lottoGame.getWinningLotto(
                InputView.receiveWinningLottoNumbers(),
                InputView.receiveBonusNumber()
        );

        LottoRank[] lottoResults = lottoGame.getResults(lottos, winningLotto);
        OutputView.printResult(lottoResults);
    }
}
