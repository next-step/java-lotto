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
        lottoResult.addCorrectLottoCount(3, false);

        lottoResult.addCorrectLottoCount(4, false);
        lottoResult.addCorrectLottoCount(4, false);

        lottoResult.addCorrectLottoCount(5, false);
        lottoResult.addCorrectLottoCount(5, true);

        lottoResult.addCorrectLottoCount(6, false);

        assertAll(
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.FIFTH)).isEqualTo(1),
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.FOURTH)).isEqualTo(2),
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.THIRD)).isEqualTo(1),
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.SECOND)).isEqualTo(1),
                () -> assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.FIRST)).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("rateOfReturn 호출 시 수익률을 소숫점 이하 2자리로 반환")
    void rateOfReturn() {
        lottoResult.addCorrectLottoCount(3, false);
        assertThat(lottoResult.rateOfReturn()).isEqualTo(5);
    }
}
