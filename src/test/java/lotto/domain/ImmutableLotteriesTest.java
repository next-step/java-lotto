package lotto.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.core.WinLotto;

import static lotto.domain.LottoWinningAndPrizeMoney.FIFTH;
import static lotto.domain.LottoWinningAndPrizeMoney.LOSE;
import static lotto.domain.core.LottoGenerator.from;
import static lotto.domain.core.LottoGenerator.fromIntList;
import static lotto.domain.core.LottoGenerator.winLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.list;

class ImmutableLotteriesTest {
    @DisplayName("로또 리스트 생성 및 일반, 자동 로또 생성 테스트")
    @Test
    void add() {
        ImmutableLotteries lottos = ImmutableLotteries.builder()
                                                      .lotto(from(1, 2, 3, 4, 5, 6))
                                                      .lotto(fromIntList(list(7, 8, 9, 10, 11, 12)))
                                                      .autoLottos(3)
                                                      .build();
        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("등록된 모든 로또 목록와 지난주 당첨 로또 비교 테스트")
    @Test
    void all_compare() {
        WinLotto wonLotto = winLotto(from(1, 2, 3, 4, 5, 6));

        ImmutableLotteries lottos = ImmutableLotteries.builder()
                                                      .lotto(from(8, 21, 23, 41, 42, 43))
                                                      .lotto(from(3, 5, 11, 16, 32, 38))
                                                      .lotto(from(7, 11, 16, 35, 36, 44))
                                                      .lotto(from(1, 8, 11, 31, 41, 42))
                                                      .lotto(from(1, 3, 5, 14, 22, 45))
                                                      .build()
                          ;
        List<LottoWinningAndPrizeMoney> compareResult = lottos.compareToEachLottoWithWonLotto(wonLotto);
        assertThat(compareResult).containsExactly(LOSE, LOSE, LOSE, LOSE, FIFTH);
    }
}
