package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void initLottoTest() {
        assertThat(Lottos.initLottos(Money.initMoney(14000)))
                .isInstanceOf(Lottos.class);
    }

    @Test
    @DisplayName("통계 테스트")
    void findStatisticsTest() {
        Lotto winning = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));

        Lotto lotto_1 = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "6"));
        Lotto lotto_2 = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "7"));
        Lotto lotto_3 = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "5", "9"));
        Lotto lotto_4 = Lotto.initWinningLotto(List.of("1", "2", "3", "4", "8", "7"));
        Lotto lotto_5 = Lotto.initWinningLotto(List.of("1", "2", "3", "9", "8", "7"));

        Lottos lottos = new Lottos(List.of(lotto_1, lotto_2, lotto_3, lotto_4, lotto_5));

        LottoNumber bonusNumber = LottoNumber.createManualLottoNumber("7");
        WinningLotto winningLotto = WinningLotto.initWinningLotto(winning, bonusNumber);

        Map<Statistics, Integer>  winnersCount = new EnumMap<>(Statistics.class);
        winnersCount.put(Statistics.FIRST, 1);
        winnersCount.put(Statistics.SECOND, 1);
        winnersCount.put(Statistics.THIRD, 1);
        winnersCount.put(Statistics.FOURTH, 1);
        winnersCount.put(Statistics.FIFTH, 1);
        Winners winners = new Winners(winnersCount);

        assertThat(lottos.findStatistics(winningLotto))
                .usingRecursiveComparison()
                .isEqualTo(winners);

    }

}