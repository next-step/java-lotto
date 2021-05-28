package step3.domain;

import step3.ui.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoGame {

    private static final String DEFAULT_REGEX = ", ";

    private final List<Lotto> lottos;


    public LottoGame(Money money) {
        ResultView resultView = new ResultView();
        lottos = new ArrayList<>();

        while (money.hasEnoughMoney()) {
            Lotto lotto = createLotto();
            lottos.add(lotto);
            money.buyOneLotto();
        }

        resultView.showLottos(lottos);
    }


    public Ranks getRanks(Lotto winningLotto, BonusNumber bonusNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto boughtLotto : lottos) {
            int count = SameLottoChecker.countSameLottoNumber(boughtLotto, winningLotto);
            ranks.add(Rank.valueOf(count, bonusNumber.isMatchedWithLotto(boughtLotto)));
        }
        return Ranks.of(ranks);


    }

    private Lotto createLotto() {
        return new Lotto(RandomLottoNumGenerator.createLottoNums());
    }

    public Lotto getWinLottoNum(String winNum) {
        return new Lotto(Arrays.stream(winNum.split(DEFAULT_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new)));
    }

    public BonusNumber getBonusNum(Lotto winningNumbers, int bonusNum) {
        return new BonusNumber(winningNumbers, bonusNum);
    }
}
