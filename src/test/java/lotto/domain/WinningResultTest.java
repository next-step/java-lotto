package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class WinningResultTest {
    private WinningResult testWinningResult;

    @BeforeEach
    void beforeEach() {
        List<LottoNumber> testNumbers = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        );
        Lotto testLotto = Lotto.of(testNumbers);
        LottoNumber testBonus = LottoNumber.from(7);
        WinningLotto testWinningLotto = new WinningLotto(testLotto, testBonus);
        testWinningResult = new WinningResult(testWinningLotto);
    }

    @DisplayName("각 로또의 결과를 RANK와 해당 RANK의 개수로 저장한다")
    @Test
    void 결과가_1등_1개_2등_1개_3등_2개인_경우() {
        List<LottoNumber> first = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        );

        List<LottoNumber> second = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(7)
        );

        List<LottoNumber> third1 = Arrays.asList(
            LottoNumber.from(11),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        );

        List<LottoNumber> third2 = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(41),
            LottoNumber.from(5),
            LottoNumber.from(6)
        );

        List<Lotto> lottos = Arrays.asList(
            Lotto.of(first),
            Lotto.of(second),
            Lotto.of(third1),
            Lotto.of(third2)
        );

        Map<Rank, Integer> actual = testWinningResult.mapResult(lottos);
        assertThat(actual.get(Rank.FIRST)).isEqualTo(1);
        assertThat(actual.get(Rank.SECOND)).isEqualTo(1);
        assertThat(actual.get(Rank.THIRD)).isEqualTo(2);
        assertThat(actual.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(actual.get(Rank.FIFTH)).isEqualTo(0);
    }

    @DisplayName("각 로또의 결과를 토대로 당첨 상금과 수익률을 계산한다")
    @Test
    void 로또_3개_중_4등_1개_5등_1개_꽝_1개인_경우() {
        List<LottoNumber> fourth = Arrays.asList(
            LottoNumber.from(11),
            LottoNumber.from(21),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        );

        List<LottoNumber> fifth = Arrays.asList(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(14),
            LottoNumber.from(15),
            LottoNumber.from(16)
        );

        List<LottoNumber> none = Arrays.asList(
            LottoNumber.from(11),
            LottoNumber.from(12),
            LottoNumber.from(13),
            LottoNumber.from(14),
            LottoNumber.from(15),
            LottoNumber.from(6)
        );

        List<Lotto> lottos = Arrays.asList(
            Lotto.of(fourth),
            Lotto.of(fifth),
            Lotto.of(none)
        );

        testWinningResult.mapResult(lottos);

        double actualProfit = testWinningResult.calculateProfitRate(3000);
        double expectedProfit = (double) 55000 / 3000;
        long actualPrize = testWinningResult.calculatePrizeMoney();

        assertThat(actualPrize).isEqualTo(55000);
        assertThat(actualProfit).isEqualTo(expectedProfit);
    }
}
