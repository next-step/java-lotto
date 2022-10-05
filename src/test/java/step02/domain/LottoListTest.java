package step02.domain;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class LottoListTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("LottoList를 빈 값으로 생성시 에러 발생 테스트.")
    void validateIsEmpty(List<Lotto> lotto) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoList(lotto));
    }

    static LottoList lottoListFixture = new LottoList(
        List.of(
            Lotto.of(List.of(1, 2, 3, 4, 5, 6)), // 1등
            Lotto.of(List.of(1, 2, 3, 4, 5, 7)), // 2등
            Lotto.of(List.of(1, 2, 3, 4, 15, 16)), // 4등
            Lotto.of(List.of(1, 2, 5, 6, 7, 8)), // 4등
            Lotto.of(List.of(1, 2, 3, 10, 11, 12)), // 5등
            Lotto.of(List.of(4, 5, 6, 7, 8, 9)), // 5등
            Lotto.of(List.of(1, 4, 6, 7, 41, 42)), // 5등
            Lotto.of(List.of(1, 2, 11, 12, 13, 14)),// 순위 외
            Lotto.of(List.of(1, 6, 41, 42, 43, 44)),// 순위 외
            Lotto.of(List.of(31, 32, 33, 34, 35, 36)),// 순위 외
            Lotto.of(List.of(6, 7, 8, 14, 26, 37)) // 순위 외
        )
    );

    @Test
    void generateLottoResult() {
        // given
        Lotto winners = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winners, new LottoNumber(7));

        Map<LottoGrade, Integer> lottoGradeResultMap = Map.of(
            LottoGrade.FIRST, 1,
            LottoGrade.SECOND, 1,
            LottoGrade.FOURTH, 2,
            LottoGrade.FIFTH, 3,
            LottoGrade.OTHER_GRADE, 4
        );

        // when
        LottoResult lottoResult = new LottoResult(lottoGradeResultMap);

        // then
        then(lottoListFixture.generateLottoResult(winningLottoNumbers)).isEqualTo(lottoResult);
    }

}