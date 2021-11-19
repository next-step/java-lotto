package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    @DisplayName("LottoNumber를 정렬된 상태로 가지고 있는지")
    @Test
    void lottoNumbers() {
        LottoNumbers lottoNumbers = LottoNumbers.of(asList(3, 1, 2, 10, 15, 20));
        assertThat(lottoNumbers.lottoNumbers()).isEqualTo(asList(num(1), num(2), num(3), num(10), num(15), num(20)));
    }

    private static LottoNumber num(int num) {
        return LottoNumber.from(num);
    }

    @DisplayName("당첨번호개수에 맞게 등급을 잘 반환하는지")
    @ParameterizedTest(name = "[{index}] lottos: {0}, winnings: {1}, grade: {2}")
    @MethodSource("matchArguments")
    void match(LottoNumbers lottoNumbers, LottoNumbers winningNumbers, LottoNumber bonusNumber, Grade expectedGrade) {
        Grade grade = lottoNumbers.rank(winningNumbers, bonusNumber);
        assertThat(grade).isEqualTo(expectedGrade);
    }

    static Stream<Arguments> matchArguments() {
        LottoNumbers lottoNumbers = LottoNumbers.of(asList(3, 1, 2, 10, 15, 20));
        return Stream.of(
                Arguments.of(lottoNumbers, LottoNumbers.of(asList(3, 1, 2, 10, 15, 20)), LottoNumber.from(40), Grade.FIRST),
                Arguments.of(lottoNumbers, LottoNumbers.of(asList(3, 1, 2, 10, 15, 30)), LottoNumber.from(20), Grade.BONUS),
                Arguments.of(lottoNumbers, LottoNumbers.of(asList(3, 1, 2, 43, 44, 45)), LottoNumber.from(20), Grade.FOURTH),
                Arguments.of(lottoNumbers, LottoNumbers.of(asList(40, 41, 42, 43, 44, 45)), LottoNumber.from(20), Grade.BANG)
                );
    }

    @DisplayName("중복된 로또번호를 입력할 경우 예외를 던진다.")
    @Test
    void create_duplicatedLottoNumbers() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumbers.of(asList(3, 3, 2, 10, 15, 20)))
                .withMessage(LottoNumbers.DUPLICATION_ERROR_MESSAGE);
    }

    @DisplayName("당첨번호와 보너스번호가 중복이 있다면 예외를 던진다.")
    @Test
    void rank_duplicatedBonusNumber() {
        int duplicatedNumber = 1;
        LottoNumbers winningNumbers = LottoNumbers.of(asList(duplicatedNumber, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(duplicatedNumber);

        LottoNumbers lottoNumbers = LottoNumbers.of(asList(1, 2, 3, 4, 5, 6));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoNumbers.rank(winningNumbers, bonusNumber))
                .withMessage(LottoNumbers.DUPLICATION_ERROR_MESSAGE);
    }

    @DisplayName("보너스 당첨일 때 등급을 잘 반환하는지")
    @Test
    void rank_bonusWin() {
        //given
        LottoNumbers lottoNumbers = LottoNumbers.of(asList(1, 2, 3, 4, 5, 6));
        LottoNumbers winningNumbers = LottoNumbers.of(asList(1, 2, 3, 4, 5, 40));
        LottoNumber bonusNumber = LottoNumber.from(6);

        //when
        Grade grade = lottoNumbers.rank(winningNumbers, bonusNumber);

        //then
        assertThat(grade).isEqualTo(Grade.BONUS);
    }
}
