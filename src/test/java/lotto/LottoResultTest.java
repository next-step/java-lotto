package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        // given
        int lottoTicketCount = 5;
        lottoResult = new LottoResult(lottoTicketCount);

        // when
        lottoResult.saveLottoResult(3, false);
        lottoResult.saveLottoResult(3, false);
        lottoResult.saveLottoResult(4, false);
        lottoResult.saveLottoResult(5, false);
        lottoResult.saveLottoResult(6, false);

        lottoResult.saveLottoResult(0, false);
        lottoResult.saveLottoResult(1, false);
        lottoResult.saveLottoResult(2, false);
    }

    @DisplayName(value = "로또 등수별 당첨 개수를 카운팅 했는지 확인한다.")
    @Test
    void 등수별_카운팅() {
        // then
        assertThat(lottoResult.getResult().get(Rank.FIRST).intValue()).isEqualTo(1);
        assertThat(lottoResult.getResult().get(Rank.THIRD).intValue()).isEqualTo(1);
        assertThat(lottoResult.getResult().get(Rank.FOURTH).intValue()).isEqualTo(1);
        assertThat(lottoResult.getResult().get(Rank.FIFTH).intValue()).isEqualTo(2);

        assertThat(lottoResult.getResult().get(Rank.MISS).intValue()).isEqualTo(3);
    }

    @Test
    void 수익률() {
        // given
        int expectProfitRatio = 400_312;

        // when
        int profitRatio = lottoResult.getProfitRatio();

        // then
        assertThat(profitRatio).isEqualTo(expectProfitRatio);
    }
}