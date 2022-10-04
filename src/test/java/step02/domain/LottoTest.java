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
        List<LottoNumber> numbers = Lotto.create().getValue();
        then(numbers.size()).isEqualTo(6); // 6개의 번호를 생성했는지
        then(numbers.size()).isEqualTo(new HashSet<>(numbers).size()); // 중복된 번호가 없는지
        then(numbers).isSorted(); // 정렬되어있는지
    }

    @Test
    @DisplayName("로또의 생성한 번호가 6개가 아닌 경우 에러 발생")
    void validateSizeIsSixFail() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            Lotto.of(List.of(1, 2, 3, 4, 5))
        );

        assertThatIllegalArgumentException().isThrownBy(() ->
            Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @Test
    @DisplayName("로또의 생성한 번호가 정렬되어 있지 않은 경우 에러 발생")
    void validateIsSorted() {
        assertThatIllegalArgumentException().isThrownBy(() ->
            Lotto.of(List.of(1, 2, 4, 3, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("NumbersByLottoGrade")
    @DisplayName("각 일치하는 개수별로 해당하는 로또 등급이 나오는지 검증")
    void getLottoGrade(LottoGrade lottoGrade, WinningLottoNumbers winningLottoNumbers) {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        then(lotto.getGradeByComparison(winningLottoNumbers)).isEqualTo(lottoGrade);
    }

    static Stream<Arguments> NumbersByLottoGrade() {
        return Stream.of(
            Arguments.of(LottoGrade.FIRST, new WinningLottoNumbers(Lotto.of(List.of(1,2,3,4,5,6)), new LottoNumber(7))),
            Arguments.of(LottoGrade.SECOND, new WinningLottoNumbers(Lotto.of(List.of(1,2,3,4,5,7)), new LottoNumber(6))),
            Arguments.of(LottoGrade.THIRD, new WinningLottoNumbers(Lotto.of(List.of(1,2,3,4,5,7)), new LottoNumber(8))),
            Arguments.of(LottoGrade.FOURTH, new WinningLottoNumbers(Lotto.of(List.of(1,2,3,4,7,8)), new LottoNumber(6))),
            Arguments.of(LottoGrade.FIFTH, new WinningLottoNumbers(Lotto.of(List.of(1,2,3,10,11,12)), new LottoNumber(6))),
            Arguments.of(LottoGrade.OTHER_GRADE, new WinningLottoNumbers(Lotto.of(List.of(3,10,11,12,13,14)), new LottoNumber(7))),
            Arguments.of(LottoGrade.OTHER_GRADE, new WinningLottoNumbers(Lotto.of(List.of(2,3,7,8,9,10)), new LottoNumber(6)))
        );
    }
}
