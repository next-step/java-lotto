package step3;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.LottoNumberDuplicateException;
import step3.exception.LottoNumberSizeMismatchException;
import step3.model.Lotto;
import step3.model.LottoNumber;
import step3.model.Reward;

@DisplayName("Lotto 클래스 테스트")
public class LottoTest {

    @DisplayName("예외 - 로또 번호가 6개 아닐 경우")
    @ParameterizedTest(name = "[{index}] - numbers = {0}")
    @MethodSource("lottoNumbersThatSizeIsNot6")
    void exception_lottoNumberSizeIsNot6(List<Integer> invalidLottoNumbers) {
        assertThatThrownBy(() -> getLottoFromNumbers(invalidLottoNumbers))
            .isInstanceOf(LottoNumberSizeMismatchException.class);
    }

    private static Stream<Arguments> lottoNumbersThatSizeIsNot6() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("예외 - 로또 번호가 중복되는 경우")
    @Test
    void exception_lottoNumberIsDuplicate() {
        assertThatThrownBy(() -> getLottoFromNumbers(Arrays.asList(1, 1, 1, 1, 1, 1)))
            .isInstanceOf(LottoNumberDuplicateException.class);
    }

    @DisplayName("예외 - 보너스 번호 입력시 로또 번호가 중복되는 경우")
    @ParameterizedTest(name = "[{index}] number = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void exception_bonusNumberIsDuplicate(int duplicate) {
        Lotto lotto = getLottoFromNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> lotto.checkDuplicate(new LottoNumber(duplicate)))
            .isInstanceOf(LottoNumberDuplicateException.class);
    }

    @DisplayName("어떤 보상을 받는지 확인")
    @ParameterizedTest(name = "[{index}] winner = {0}, bonusNumber = {1} res = {2}")
    @MethodSource("rewards")
    void getReward(Lotto winner, LottoNumber bonusNumber, Reward reward) {
        Lotto lotto = getLottoFromNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getReward(winner, bonusNumber)).isEqualTo(reward);
    }

    private static Stream<Arguments> rewards() {
        return Stream.of(
            getArguments(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Reward.FIRST),
            getArguments(Arrays.asList(1, 2, 3, 4, 5, 7), 6, Reward.SECOND),
            getArguments(Arrays.asList(1, 2, 3, 4, 5, 7), 8, Reward.THIRD),
            getArguments(Arrays.asList(1, 2, 3, 4, 7, 8), 9, Reward.FOURTH),
            getArguments(Arrays.asList(1, 2, 3, 7, 8, 9), 10, Reward.FIFTH),
            getArguments(Arrays.asList(1, 2, 7, 8, 9, 10), 11, Reward.BANG)
        );
    }

    private static Arguments getArguments(List<Integer> numbers, Integer bonusNumber, Reward reward) {
        Lotto lotto = getLottoFromNumbers(numbers);
        return Arguments.of(lotto, new LottoNumber(bonusNumber), reward);
    }

    private static Lotto getLottoFromNumbers(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(toList());
        return new Lotto(lottoNumbers);
    }
}
