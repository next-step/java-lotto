package step02.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.BDDAssertions.then;

class LottoTest {

    @RepeatedTest(10)
    @DisplayName("로또의 생성한 번호가 정상적인지 검증. (랜덤한 성격을 지니고 있어 10번 반복 테스트)")
    void validateLottoSuccess() {
        List<Integer> numbers = Lotto.create().getValue();
        then(numbers.size()).isEqualTo(6); // 6개의 번호를 생성했는지
        then(numbers.size()).isEqualTo(new HashSet<>(numbers).size()); // 중복된 번호가 없는지
        then(numbers).isSorted(); // 정렬되어있는지
        numbers.forEach(n -> then(n).isBetween(1, 45)); // 1~45 사이의 번호인지
    }

    @Test
    @DisplayName("로또의 생성한 번호가 6개가 아닌 경우 에러 발생")
    void validateSizeIsSixFail() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Lotto(List.of(1,2,3,4,5))
        );

        assertThatIllegalArgumentException().isThrownBy(() ->
            new Lotto(List.of(1,2,3,4,5,6,7))
        );
    }

    @Test
    @DisplayName("로또의 생성한 번호가 정렬되어 있지 않은 경우 에러 발생")
    void validateIsSorted() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Lotto(List.of(1,2,4,3,5,6))
        );
    }

    @Test
    @DisplayName("로또의 생성한 번호가 1~45 범위를 벗어난 경우 에러 발생")
    void validateIsBetween() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Lotto(List.of(1,2,3,4,5,46))
        );

        assertThatIllegalArgumentException().isThrownBy(() ->
            new Lotto(List.of(0,2,3,4,5,46))
        );
    }

    @ParameterizedTest
    @MethodSource("NumbersByLottoGrade")
    @DisplayName("각 일치하는 개수별로 해당하는 로또 등급이 나오는지 검증")
    void getLottoGrade(LottoGrade lottoGrade, List<Integer> numbers) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        then(lotto.getGradeByComparison(new Lotto(numbers))).isEqualTo(lottoGrade);
    }

    static Stream<Arguments> NumbersByLottoGrade() {
        return Stream.of(
            Arguments.of(LottoGrade.FIRST, List.of(1, 2, 3, 4, 5, 6)),
            Arguments.of(LottoGrade.SECOND, List.of(1, 2, 3, 4, 5, 16)),
            Arguments.of(LottoGrade.THIRD, List.of(1, 2, 3, 4, 15, 16)),
            Arguments.of(LottoGrade.FOURTH, List.of(1, 2, 3, 14, 15, 16)),
            Arguments.of(LottoGrade.OTHER_GRADE, List.of(1, 2, 13, 14, 15, 16)),
            Arguments.of(LottoGrade.OTHER_GRADE, List.of(1, 12, 13, 14, 15, 16)),
            Arguments.of(LottoGrade.OTHER_GRADE, List.of(11, 12, 13, 14, 15, 16))
        );
    }
}
