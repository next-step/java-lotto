package step3.domain;

import step3.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoGame {

    private static final String DEFAULT_REGEX = ", ";

    public static final int THREE_MATCH = 5_000;
    public static final int FOUR_MATCH = 50_000;
    public static final int FIVE_MATCH = 1_500_000;
    public static final int SIX_MATCH = 2_000_000_000;

    private final List<Lotto> lottos;
    private final LottoCount lottoCount;


    public LottoGame(Money money) {
        ResultView resultView = new ResultView();
        lottos = new ArrayList<>();
        lottoCount = new LottoCount();

        while (money.hasEnoughMoney()) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
            money.buyOneLotto();
        }

        resultView.showLottos(lottos);
    }


    public void getStatistics(Lotto winLotto) {
        for (Lotto lotto : lottos) {
            int count = SameLottoChecker.countSameLottoNumber(lotto, winLotto);
            lottoCount.sameCount(count);
        }

        ResultView.showStatistics(lottoCount);
        ResultView.showRate(lottoCount.earningRate(lottos.size()));
    }

    private Lotto createLotto() {
        return new Lotto(RandomLottoNumGenerator.createLottoNums());
    }

    public Lotto getWinLottoNum(String winNum) {
        return new Lotto(Arrays.stream(winNum.split(DEFAULT_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new)));
    }
}
