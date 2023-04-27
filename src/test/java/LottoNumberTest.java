import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 테스트")
public class LottoNumberTest {
    @Test
    @DisplayName("6개의 번호를 가진 로또를 생성할 수 있다.")
    void generateSixLottoNumbers_test() {
        LottoNumber lottoNumber = new LottoNumber();

        Assertions.assertThat(lottoNumber.getNumbers()).hasSize(6);
    }

    @RepeatedTest(10)
    @DisplayName("매번 다른 번호를 가진 로또를 생성할 수 있다.")
    void generateRandomLottoNumbers_test() {
        LottoNumber lottoNumber1 = new LottoNumber();
        LottoNumber lottoNumber2 = new LottoNumber();

        Assertions.assertThat(lottoNumber1).isNotEqualTo(lottoNumber2);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("당첨 번호의 입력값이 null이거나 빈 공백인 경우 예외를 던진다.")
    void validateWinningNumbersNullAndEmpty_test(String input) {
        assertThatThrownBy(() -> InputView.validateInputWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1% 2% 3% 4% 5% 6", "a, b, c, d, e, f"})
    @DisplayName("당첨번호의 입력값이 공백의 유무와 상관없이 콤마(,)와 숫자의 조합이 아니라면 예외를 던진다.")
    void validateNumberCommaExpression_test(String input) {
        assertThatThrownBy(() -> InputView.validateInputWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호의 입력값의 숫자가 6개가 아니라면 예외를 던진다.")
    void validateSixWinningNumber_test() {
        String input = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> InputView.validateInputWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에서 숫자만 분리할 수 있다.")
    void extractWinningNumbers_test() {
        String input = "1, 2, 3, 4, 5, 6";
        Integer[] numbers = {1, 2, 3, 4, 5, 6};

        List<Integer> extractNumbers = InputView.extractNumbers(input);

        Assertions.assertThat(extractNumbers).contains(numbers);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("당첨 번호와 일치하는 숫자에 따라 순위를 매길 수 있다.")
    void setRank_test(int matchCount) {
        Rank rank = Rank.valueOf(matchCount);

        Assertions.assertThat(matchCount).isEqualTo(rank.getCountOfMatch());
    }

    @Test
    @DisplayName("당첨 번호가 0~6개 안의 숫자에서 확인되는 지 확인할 수 있다.")
    void checkMatchingNumbers_test() {
        LottoNumber lottoNumber = new LottoNumber();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int matchCount = lottoNumber.countMatchingNumbers(winningNumbers);
        Assertions.assertThat(matchCount).isBetween(0, 6);
    }

    @Test
    @DisplayName("수익률 계산이 동작하는지 확인할 수 있다.")
    void calculateReturnRate_test() {
        int purchaseAmount = 10_000;
        LottoTicket lottoTicket = new LottoTicket(10); // 10장의 로또 티켓 생성
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoResult lottoResult = lottoTicket.calculateResult(winningNumbers);
        double returnRate = OutputView.calculateReturnRate(purchaseAmount, lottoResult);

        Assertions.assertThat(returnRate).isGreaterThanOrEqualTo(0);
    }
}
