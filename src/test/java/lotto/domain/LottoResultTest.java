package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void before() {
        lottoResult = new LottoResult();
    }

    @Test
    @DisplayName("addCorrectLottoCount 호출하면 매개변수에 로또 하나 당 맞춘 개수가 넘어가고 해당하는 변수 가산")
    void addCorrectLottoCount() {
        lottoResult.addCorrectLottoCount(3);

        lottoResult.addCorrectLottoCount(4);
        lottoResult.addCorrectLottoCount(4);

        lottoResult.addCorrectLottoCount(5);
        lottoResult.addCorrectLottoCount(5);

        lottoResult.addCorrectLottoCount(6);

        assertAll(
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.THREE_NUMBER_CORRECT)).isEqualTo(1),
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.FOUR_NUMBER_CORRECT)).isEqualTo(2),
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.FIVE_NUMBER_CORRECT)).isEqualTo(2),
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.SIX_NUMBER_CORRECT)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("rateOfReturn 호출 시 수익률을 소숫점 이하 2자리로 반환")
    void rateOfReturn() {
        lottoResult.addCorrectLottoCount(3);
        assertThat(lottoResult.rateOfReturn()).isEqualTo(5);
    }
}
