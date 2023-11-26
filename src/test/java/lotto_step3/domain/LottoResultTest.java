package lotto_step3.domain;

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

    @DisplayName("당첨 순위를 전달하면 해당 수위의 로또 개수를 반환한다.")
    @Test
    void countingPrizeTest() {
        LottoResult result = new LottoResult(List.of(
                LottoPrize.from(2),
                LottoPrize.from(0),
                LottoPrize.from(3),
                LottoPrize.from(5)
        ));

        assertThat(result.countingPrize(LottoPrize.FOURTH)).isEqualTo(1);
        assertThat(result.countingPrize(LottoPrize.NONE)).isEqualTo(2);
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
}