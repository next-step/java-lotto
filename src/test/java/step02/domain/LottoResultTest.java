package step02.domain;

import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class LottoResultTest {

    @Test
    void getTotalAmount() {
        LottoResult lottoResult = new LottoResult(
            Map.of(
                LottoGrade.FIRST, 1,
                LottoGrade.SECOND, 5,
                LottoGrade.THIRD, 2,
                LottoGrade.FOURTH, 3,
                LottoGrade.OTHER_GRADE, 4
            )
        );

        then(lottoResult.getTotalAmount()).isEqualTo(2_153_150_000L);
    }
}