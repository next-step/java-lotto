package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @DisplayName("수익률을 계산한다.")
    @Test
    void ratio() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.increase(LottoRank.FOURTH);

        final double actual = lottoResult.ratio(new Price(14000));

        assertThat(actual).isEqualTo(0.35);
    }

}