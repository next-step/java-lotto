package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoNumbersTest {

    private final LottoNumbers winningLottoNumbers = LottoNumbers.of(createLottoNumbers(1,2,3,4,5,6));
    private final LottoNumber bonusBall = LottoNumber.of(7);
    private final WinningLottoNumbers winningLottoNumbersWithBonusNumber = WinningLottoNumbers.of(winningLottoNumbers, bonusBall);

    @ParameterizedTest(name = "로또 당첨 테스트")
    @MethodSource(value = "provideLottoNumbersAndExpectedRank")
    public void winningSecondTest(LottoNumbers lottoNumbers, Rank expected) {
        assertThat(winningLottoNumbersWithBonusNumber.match(lottoNumbers))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoNumbersAndExpectedRank() {
        return Stream.of(
                Arguments.of(LottoNumbers.of(createLottoNumbers(1,2,3,4,5,6)), Rank.FIRST),
                Arguments.of(LottoNumbers.of(createLottoNumbers(1,2,3,4,5,7)), Rank.SECOND),
                Arguments.of(LottoNumbers.of(createLottoNumbers(1,2,3,4,5,45)), Rank.THIRD),
                Arguments.of(LottoNumbers.of(createLottoNumbers(1,2,3,4,7,45)), Rank.FOURTH),
                Arguments.of(LottoNumbers.of(createLottoNumbers(1,2,3,7,44,45)), Rank.FIFTH),
                Arguments.of(LottoNumbers.of(createLottoNumbers(1,2,42,43,44,45)), Rank.MISS),
                Arguments.of(LottoNumbers.of(createLottoNumbers(1,41,42,43,44,45)), Rank.MISS),
                Arguments.of(LottoNumbers.of(createLottoNumbers(40,41,42,43,44,45)), Rank.MISS)
        );
    }

    @DisplayName("로또 당첨 번호에 보너스 볼이 포함되는 경우 예외가 발생한다.")
    @Test
    public void duplicateBonusBallTests() {
        LottoNumbers lottoNumbers = LottoNumbers.of(createLottoNumbers(1,2,3,4,5,6));
        LottoNumber bonusBall = LottoNumber.of(1);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLottoNumbers.of(lottoNumbers, bonusBall))
                .withMessageContaining(String.valueOf(1));
    }

    private static List<LottoNumber> createLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

}