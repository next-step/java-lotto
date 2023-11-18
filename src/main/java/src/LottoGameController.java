package src;

import src.domain.GameNumber;
import src.domain.Lotto;
import src.domain.AutoLottoGameNumberGenerator;
import src.domain.LottoMachine;
import src.domain.Lottos;
import src.domain.MatchStatus;
import src.domain.Money;
import src.domain.WinningLotto;
import src.view.InputView;
import src.view.ManualLottoGameNumberGenerator;
import src.view.ResultView;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoGameController {

    public static void main(String[] args) {
        int purchasePrice = InputView.inputPurchasePrice();
        int manualLottoCount = InputView.inputPurchaseManualLottoCount();
        Map<String, Money> moneyMap = inputMoneys(purchasePrice, manualLottoCount);
        Money moneyOfAutoLotto = moneyMap.get("AUTO");
        Money moneyOfManualLotto = moneyMap.get("MANUAL");

        LottoMachine lottoMachine = new LottoMachine(new AutoLottoGameNumberGenerator());

        Lottos autoLottos = lottoMachine.buyLottos(moneyOfAutoLotto);


        Lottos manualLottos = buyManualLottos(manualLottoCount, lottoMachine, moneyOfManualLotto);

        Lottos lottos = autoLottos.addLottos(manualLottos);
        printLottos(lottos, autoLottos.size(), manualLottos.size());

        WinningLotto winningLotto = inputWinningLotto();

        MatchStatus matchStatus = lottos.match(winningLotto);
        double profitRate = matchStatus.profitRate(Lotto.PRICE_OF_LOTTO);
        ResultView.printMatchResult(matchStatus, profitRate);
    }

    private static Lottos buyManualLottos(int manualLottoCount, LottoMachine lottoMachine, Money moneyOfManualLotto) {
        if (manualLottoCount <= 0) {
            return Lottos.of(List.of());
        }

        InputView.inputPurchaseManualLottoNumber(manualLottoCount);
        lottoMachine.changeLottoGameNumberGenerator(new ManualLottoGameNumberGenerator());
        return lottoMachine.buyLottos(moneyOfManualLotto);
    }

    private static Map<String, Money> inputMoneys(int purchasePrice, int manualLottoCount) {
        Money totalMoney = Money.of(purchasePrice);
        Money moneyOfManualLotto = Money.of(manualLottoCount * Lotto.PRICE_OF_LOTTO);

        try {
            Money moneyOfAutoLotto = totalMoney.minus(moneyOfManualLotto);

            return Map.of("AUTO", moneyOfAutoLotto, "MANUAL", moneyOfManualLotto);
        } catch (IllegalArgumentException e) {
            int maximumLottoCount = totalMoney.lottoCount(Lotto.PRICE_OF_LOTTO);
            throw new IllegalArgumentException("최대 " + maximumLottoCount + "개 구매 가능합니다.");
        }
    }

    private static void printLottos(Lottos lottos, int autoLottoSize, int manualLottoSize) {
        ResultView.printPurchaseLottoGameCount(autoLottoSize, manualLottoSize);
        ResultView.printLottos(lottos);
    }

    private static WinningLotto inputWinningLotto() {
        Set<GameNumber> winningNumbers = new HashSet<>(Lotto.LOTTO_GAME_NUMBER_SIZE);
        for (Integer number : InputView.inputWinningNumbers()) {
            winningNumbers.add(GameNumber.of(number));
        }
        GameNumber bonusNumber = GameNumber.of(InputView.inputBonusNumber());

        return WinningLotto.of(Lotto.of(winningNumbers), bonusNumber);
    }
}
