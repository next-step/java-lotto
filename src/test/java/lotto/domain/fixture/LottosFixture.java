package lotto.domain.fixture;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinnerLotto;
import lotto.enums.LottoPrize;
import lotto.strategy.AutoLotto;
import lotto.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottosFixture {

    static Lotto 로또_자동_1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    static Lotto 로또_자동_2 = new Lotto(Arrays.asList(1, 11, 13, 24, 5, 6));

    static Lotto 로또_자동_3 = new Lotto(Arrays.asList(1, 12, 13, 24, 35, 6));
    public static Lottos 로또_티켓;

    private static List<Lotto> lottoList = new ArrayList<>(Arrays.asList(로또_자동_1, 로또_자동_2, 로또_자동_3));

    private static final LottoStrategy 자동 = new AutoLotto();

    static {
        로또_티켓 = new Lottos(자동, 3) {
            @Override
            public List<Lotto> createLotto(LottoStrategy lottoStrategy, int count) {
                return lottoList;
            }

            @Override
            public Map<LottoPrize, Integer> getMatchCounts(WinnerLotto winnerLotto) {
                return super.getMatchCounts(winnerLotto);
            }
        };
    }
}
