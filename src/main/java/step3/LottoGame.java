package step3;

import step3.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static step3.LottoConstants.*;

public class LottoGame {

    List<Lotto> lottos;

    private int threeCount;
    private int fourCount;
    private int fiveCount;
    private int sixCount;


    public LottoGame(Money money) {
        lottos = new ArrayList<>();

        while (money.hasEnoughMoney()) {
            Lotto lotto = createLotto();
            lotto.shuffle();
            lottos.add(lotto);
            money.buyOneLotto();
        }

        ResultView.showLottos(lottos);
    }


    public void getStatistics(Lotto winLotto) {
        for (int i = 0; i < lottos.size(); ++i) {
            int count = SameLottoChecker.countSameLottoNum(lottos.get(i), winLotto);
            sameCount(count);
        }
        ResultView.showStatistics(threeCount, fourCount, fiveCount, sixCount);
        ResultView.showRate(earningRate());
    }

    private double earningRate() {
        long sum = 0;
        sum += threeCount * THREE_MATCH;
        sum += fourCount * FOUR_MATCH;
        sum += fiveCount * FIVE_MATCH;
        sum += sixCount * SIX_MATCH;

        return sum / (double) (lottos.size() * 1000);
    }

    private void sameCount(int count) {
        if (count == THREE_COUNT) threeCount++;
        else if (count == FOUR_COUNT) fourCount++;
        else if (count == FIVE_COUNT) fiveCount++;
        else if (count == SIX_COUNT) sixCount++;
    }

    private Lotto createLotto() {
        return new Lotto(RandomLottoNumGenerator.createLottoNums());
    }

    public Lotto getWinLottoNum(String winNum) {
        return new Lotto(Arrays.stream(winNum.split(DEFAULT_REGEX)).map(Integer::parseInt).collect(Collectors.toList()));
    }
}
