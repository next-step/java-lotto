package step3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private static final LottoFactory lotto = new LottoFactory();

    public static void start(int input) {
        LottoAmount lottoMoney = new LottoAmount(input);
        Print.manualLotto();

        int manualLottoAmount = Integer.parseInt(InputView.input());
        checkManualLottoAmount(lottoMoney, manualLottoAmount);
        Print.makeManualLotto();
        List<Lotto> manualLotto = makeManualLotto(manualLottoAmount);
        List<Lotto> autoLotto = makeAutoLotto(lottoMoney.amountOfLottos() - manualLottoAmount);
        List<Lotto> combineLotto = Stream.of(manualLotto, autoLotto)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Print.howManyBuyLotto(manualLotto.size(), autoLotto.size(), combineLotto);

        Print.winningNumber();
        Lotto winLotto = new Lotto(InputView.inputWinningNumber());
        Print.bonusBall();
        int bonus = Integer.parseInt(InputView.input());

        Lottos lottos = new Lottos(combineLotto);

        Print.rateOfWin(input, new Result(lottos).results(winLotto, bonus));
    }

    private static void checkManualLottoAmount(LottoAmount lottoMoney, int manualLottoAmount) {
        if (manualLottoAmount > lottoMoney.amountOfLottos()) {
            throw new IllegalArgumentException(lottoMoney.amountOfLottos() + "개 초과하여 구매할 수 없습니다.");
        }
    }

    private static List<Lotto> makeManualLotto(int input) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            list.add(new Lotto(InputView.inputWinningNumber()));
        }
        return list;
    }

    public static List<Lotto> makeAutoLotto(int autoLottoAmount) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 1; i <= autoLottoAmount; i++) {
            Lotto result = new Lotto(lotto.getRandomLotto());
            list.add(result);
        }
        return list;
    }
}
