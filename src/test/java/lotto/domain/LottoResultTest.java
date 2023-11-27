package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @DisplayName("맞춘 개수로 결과 리스트를 생성한다.")
    @Test
    void lottoResultTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(2),
                LottoPrize.from(0),
                LottoPrize.from(3)
        ));

        assertThat(result).isInstanceOf(LottoResult.class);
    }

    @DisplayName("맞춘 개수로 결과 리스트를 생성한다.(보너스추가)")
    @Test
    void lottoResultWithBonusTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(2, false),
                LottoPrize.from(3, true),
                LottoPrize.from(5, true)
        ));

        assertThat(result).isInstanceOf(LottoResult.class);
    }

    @DisplayName("당첨 순위를 전달하면 해당 수위의 로또 개수를 반환한다.")
    @Test
    void countingPrizeTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(2),
                LottoPrize.from(0),
                LottoPrize.from(3),
                LottoPrize.from(5)
        ));

        assertThat(result.countingPrize(LottoPrize.FIFTH)).isEqualTo(1);
        assertThat(result.countingPrize(LottoPrize.NONE)).isEqualTo(2);
    }

    @DisplayName("당첨 순위를 전달하면 해당 수위의 로또 개수를 반환한다.(보너스추가)")
    @Test
    void countingPrizeWithBonusTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(2, true),
                LottoPrize.from(5, false),
                LottoPrize.from(3, true),
                LottoPrize.from(5, true)
        ));

        assertThat(result.countingPrize(LottoPrize.SECOND)).isEqualTo(1);
        assertThat(result.countingPrize(LottoPrize.THIRD)).isEqualTo(1);
        assertThat(result.countingPrize(LottoPrize.FIFTH)).isEqualTo(1);
    }

    @DisplayName("전체 당첨 금액을 반환한다.")
    @Test
    void totalPrizeTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(2),
                LottoPrize.from(0),
                LottoPrize.from(3)
        ));

        assertThat(result.totalPrize()).isEqualTo(5000);
    }

    @DisplayName("전체 당첨 금액을 반환한다.(보너스추가)")
    @Test
    void totalPrizeWithBonusTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(5, false),
                LottoPrize.from(0, true),
                LottoPrize.from(5, true)
        ));

        assertThat(result.totalPrize()).isEqualTo(31500000);
    }

    @DisplayName("구매금액을 전달하면 수익률을 반환한다")
    @Test
    void rateTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(2),
                LottoPrize.from(0),
                LottoPrize.from(3)
        ));

        assertThat(result.getRate(new Money(3000))).isEqualTo(1.67);
    }

    @DisplayName("구매금액을 전달하면 수익률을 반환한다.(보너스추가)")
    @Test
    void rateWithBonusTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(5, false),
                LottoPrize.from(0, true),
                LottoPrize.from(3, true)
        ));

        assertThat(result.getRate(new Money(3000))).isEqualTo(501.67);
    }
}