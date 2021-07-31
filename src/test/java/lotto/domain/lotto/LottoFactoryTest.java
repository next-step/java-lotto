package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import lotto.domain.lotto.exception.InvalidBonusLottoNumberException;
import lotto.domain.lotto.exception.InvalidLottoNumberException;
import lotto.domain.lotto.exception.InvalidTotalAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 팩토리")
class LottoFactoryTest {

    public static Stream<Arguments> validLottoNumbers() {
        return Stream.of(
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 7),
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 4, 15, 20, 45)), 44)
        );
    }

    @DisplayName("[성공] 당첨 로또 생성")
    @ParameterizedTest
    @MethodSource("validLottoNumbers")
    public void createWinning(Set<Integer> numbers, int bonusNumber) {
        // given

        // when
        WinningLotto winningLotto = LottoFactory.createWinning(numbers, bonusNumber);

        // then
        assertThat(winningLotto).isNotNull();
    }

    public static Stream<Arguments> notValidLottoNumbers() {
        return Stream.of(
            Arguments.of(new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5)), 6),
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 5)), 6),
            Arguments.of(new HashSet<>(Arrays.asList(0, 5, 6, 7, 15, 46)), 9),
            Arguments.of(new HashSet<>(Arrays.asList(1, 2, 6, 7)), 10)
        );
    }

    @DisplayName("[실패] 당첨 로또 생성 - 유효하지 않은 로또 번호")
    @ParameterizedTest
    @MethodSource("notValidLottoNumbers")
    public void createWinning_notValid(Set<Integer> numbers, int bonusNumber) {
        // given

        // when
        assertThrows(InvalidLottoNumberException.class, () -> LottoFactory.createWinning(numbers, bonusNumber));

        // then

    }

    public static Stream<Arguments> notValidBonusLottoNumbers() {
        return Stream.of(
            Arguments.of(new HashSet<>(Arrays.asList(10, 1, 2, 3, 4, 5)), 5),
            Arguments.of(new HashSet<>(Arrays.asList(10, 1, 2, 3, 4, 5)), 46)
        );
    }

    @DisplayName("[실패] 당첨 로또 생성 - 유효하지 않은 보너스 번호")
    @ParameterizedTest
    @MethodSource("notValidBonusLottoNumbers")
    public void createWinning_notValidBonusNumber(Set<Integer> numbers, int bonusNumber) {
        // given

        // when
        assertThrows(InvalidBonusLottoNumberException.class, () -> LottoFactory.createWinning(numbers, bonusNumber));

        // then

    }

    @DisplayName("[성공] 로또 구매 가능 매수")
    @ParameterizedTest
    @CsvSource(value = {
        "1000,1",
        "2000,2",
        "3500,3",
    })
    public void possiblePurchaseLottoCount(int totalAmount, int expected) {
        // given

        // when
        int purchaseLottoCount = LottoFactory.possiblePurchaseLottoCount(totalAmount);

        // then
        assertThat(purchaseLottoCount).isEqualTo(expected);
    }

    @DisplayName("[실패] 로또 구매 가능 매수 - 너무 적은 액수")
    @ParameterizedTest
    @CsvSource(value = {
        "500",
        "-1000",
    })
    public void possiblePurchaseLottoCount_tooSmallAmount(int totalAmount) {
        // given

        // when
        assertThrows(InvalidTotalAmountException.class, () -> LottoFactory.possiblePurchaseLottoCount(totalAmount));

        // then
    }
}
