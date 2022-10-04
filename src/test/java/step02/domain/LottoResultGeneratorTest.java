package step02.domain;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class LottoResultGeneratorTest {

    @Test
    @DisplayName("로또 결과가 각 순위별로 잘 추출되는지 테스트.")
    void generate() {
        // given
        Lotto winners = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoList lottoList = new LottoList(
            List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 15, 16)), // 3등
                new Lotto(List.of(1, 2, 5, 6, 7, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 10, 11, 12)), // 4등
                new Lotto(List.of(4, 5, 6, 7, 8, 9)), // 4등
                new Lotto(List.of(1, 4, 6, 7, 41, 42)), // 4등
                new Lotto(List.of(1, 2, 11, 12, 13, 14)),// 순위 외
                new Lotto(List.of(1, 6, 41, 42, 43, 44)),// 순위 외
                new Lotto(List.of(31, 32, 33, 34, 35, 36)),// 순위 외
                new Lotto(List.of(6, 7, 8, 14, 26, 37)) // 순위 외
            )
        );

        Map<LottoGrade, Integer> lottoGradeResultMap = Map.of(
            LottoGrade.FIRST, 1,
            LottoGrade.THIRD, 2,
            LottoGrade.FOURTH, 3,
            LottoGrade.OTHER_GRADE, 4
        );

        // when
        LottoResult lottoResult = new LottoResult(lottoGradeResultMap);

        // then
        then(LottoResultGenerator.generate(lottoList, winners)).isEqualTo(lottoResult);
    }
}