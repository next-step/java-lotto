package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 금액 입력
        Money money = new Money(InputView.inputPurchasePrice());

        int countOfCustomLotto = InputView.inputCountOfCustomLotto(money);

        InputView.inputCustomLottoNumbers();
        List<LottoGenerator> customLottoGenerators = new ArrayList<>();
        for (int i = 0; i < countOfCustomLotto; i++) {
            customLottoGenerators.add(new CustomLottoGenerator(InputView.inputCustomLotto()));
        }

        // 총 구매 티켓 수 알림
        ResultView.announceTotalLottoTicketCount(countOfCustomLotto, money.countOfLottoPurchases());

        // 구매 티켓 번호 출력
        LottoPaper lottoPaper = new LottoMachine().buyLotto(money, customLottoGenerators);
        ResultView.announceTotalLottoNumbers(lottoPaper);

        // 지난주 당첨 번호 입력
        WinningResults winningResults = new WinningResults(lottoPaper, InputView.inputWinningNumbersLastWeek(), InputView.inputBonusNumber());

        // 결과 출력
        ResultView.resultStart();
        ResultView.WinningResult(winningResults);
    }
}
