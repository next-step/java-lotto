package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void before() {
        lottoResult = new LottoResult(14);
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

    @ParameterizedTest
    @CsvSource(value = {"false:3:0.35", "false:4:3.57", "false:5:107.14", "true:5:2142.85", "false:6:142857.14"}, delimiter = ':')
    @DisplayName("rateOfReturn 호출 시 수익률을 소숫점 이하 2자리로 반환")
    void rateOfReturn(boolean isBonus, int correctCount, double expected) {
        lottoResult.addCorrectLottoCount(correctCount, isBonus);
        assertThat(lottoResult.rateOfReturn()).isEqualTo(expected);
    }
}
