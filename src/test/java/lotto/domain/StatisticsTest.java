package lotto.domain;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StatisticsTest {

    private final LottoNumberGroup lottoNumberGroup = new LottoNumberGroup();

    @Test
    @DisplayName("당첨 통계 테스트")
    void statisticsWinner() {

        List<Integer> givenLottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = WinnerLotto.of(lottoNumberGroup, givenLottoNumberList);

        Statistics statistics = new Statistics(winnerLotto);

        List<Lotto> lottoList = List.of(
                Lotto.of(lottoNumberGroup, List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(lottoNumberGroup, List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(lottoNumberGroup, List.of(1, 2, 3, 4, 5, 6))
        );


        assertThat(statistics.statisticsWinner(lottoList)).hasEntrySatisfying(Prize.FIRST_PLACE, new Condition<>() {
            @Override
            public boolean matches(Long value) {
                return value == 3;
            }
        });
    }

    @Test
    @DisplayName("수익률 테스트 - 손해")
    void getProfitLoseTest() {
        List<Integer> givenLottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = WinnerLotto.of(lottoNumberGroup, givenLottoNumberList);

        Statistics statistics = new Statistics(winnerLotto);

        List<Lotto> lottoList = List.of(
                Lotto.of(lottoNumberGroup, List.of(8, 21, 23, 41, 42, 43)),
                Lotto.of(lottoNumberGroup, List.of(1, 3, 5, 14, 22, 45)),
                Lotto.of(lottoNumberGroup, List.of(5, 9, 38, 41, 43, 44))
        );

        assertAll(
                () -> assertThat(statistics.getProfit(Money.wons(14000), lottoList)).isLessThan(1.0)
        );

    }

    @Test
    @DisplayName("수익률 테스트 - 본전")
    void getProfitPrincipalTest() {
        List<Integer> givenLottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = WinnerLotto.of(lottoNumberGroup, givenLottoNumberList);

        Statistics statistics = new Statistics(winnerLotto);

        List<Lotto> lottoList = List.of(
                Lotto.of(lottoNumberGroup, List.of(8, 21, 23, 41, 42, 43)),
                Lotto.of(lottoNumberGroup, List.of(1, 3, 5, 14, 22, 45)),
                Lotto.of(lottoNumberGroup, List.of(5, 9, 38, 41, 43, 44))
        );


        assertAll(
                () -> assertThat(statistics.getProfit(Money.wons(5000), lottoList)).isEqualTo(1.0)
        );

    }


    @Test
    @DisplayName("수익률 테스트 - 수익")
    void getProfitTest() {
        List<Integer> givenLottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        WinnerLotto winnerLotto = WinnerLotto.of(lottoNumberGroup, givenLottoNumberList);

        Statistics statistics = new Statistics(winnerLotto);

        List<Lotto> lottoList = List.of(
                Lotto.of(lottoNumberGroup, List.of(8, 21, 23, 41, 42, 43)),
                Lotto.of(lottoNumberGroup, List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(lottoNumberGroup, List.of(5, 9, 38, 41, 43, 44))
        );


        assertAll(
                () -> assertThat(statistics.getProfit(Money.wons(5000), lottoList)).isGreaterThan(1.0)
        );

    }

}