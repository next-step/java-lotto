package lotto;

import calculator.PositiveNumber;
import lotto.domain.Credit;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberFactory;
import lotto.domain.PurchaseMachine;
import lotto.domain.Statistics;
import lotto.domain.WonLotto;
import lotto.dto.LottoDto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        ResultView resultView = new ResultView();

        Credit credit = inputView.getCredit();
        PositiveNumber manualLottoCount = inputView.getManualLottoCount();
        List<LottoDto> lottoDtos = inputView.insertManualLotto(manualLottoCount);

        PurchaseMachine purchaseByCredit = new PurchaseMachine(credit.substractLottocount(new Credit(manualLottoCount)));
        LottoNumberFactory lottoNumberFactory = new LottoNumberFactory();

        List<Lotto> lotto = purchaseByCredit.purchase(lottoNumberFactory);

        resultView.printPurchaseLottos(toLotto(lottoDtos), lotto);

        WonLotto wonLotto = inputView.insertWonLotto().toWonLotto();
        Statistics statistics = new Statistics(credit, lotto, wonLotto);

        resultView.printResultStatics(statistics);
    }

    private static List<Lotto> toLotto(List<LottoDto> lottoDtos) {
        if (lottoDtos == null || lottoDtos.isEmpty()) {
            return Collections.emptyList();
        }

        return lottoDtos.stream()
            .map(LottoDto::toLotto)
            .collect(Collectors.toList());
    }
}
