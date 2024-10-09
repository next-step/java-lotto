package lotto.view;

import lotto.domain.LottoBundle;
import lotto.domain.LottoPurchaseResult;
import lotto.io.ConsoleMessageReader;
import lotto.io.ConsoleMessageWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoInputViewTest {
    @Test
    @DisplayName("구입 금액을 입력하면 지정된 수량만큼의 로또번들 객체가 반환된다.")
    void shouldReturnLottoBundleBasedOnPurchaseAmount() {
        final String money = "3000\n";
        final LottoInputView lottoInputView = new LottoInputView(
            new ConsoleMessageReader(new ByteArrayInputStream(money.getBytes())),
            new ConsoleMessageWriter()
        );

        final LottoPurchaseResult lottoPurchaseResult = lottoInputView.inputMoney();
        assertThat(lottoPurchaseResult.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("지난 주 당첨 번호가 입력되지 않은 경우 예외가 발생한다.")
    void shouldThrowExceptionWhenWinningNumbersNotProvided() {
        final String lottoNumbers = "\n";
        final LottoInputView lottoInputView = new LottoInputView(
            new ConsoleMessageReader(new ByteArrayInputStream(lottoNumbers.getBytes())),
            new ConsoleMessageWriter()
        );

        assertThatIllegalArgumentException()
            .isThrownBy(lottoInputView::inputLastWeekWinningLotto);
    }

    @Test
    @DisplayName("지난 주 당첨 번호를 구분하는 구분자가 존재하지 않는다면 예외가 발생한다.")
    void shouldThrowExceptionWhenWinningNumbersDelimiterIsMissing() {
        final String lottoNumbers = "123456";
        final LottoInputView lottoInputView = new LottoInputView(
            new ConsoleMessageReader(new ByteArrayInputStream(lottoNumbers.getBytes())),
            new ConsoleMessageWriter()
        );

        assertThatIllegalArgumentException()
            .isThrownBy(lottoInputView::inputLastWeekWinningLotto);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7" })
    @DisplayName("지난 주 당첨 번호가 6개가 아니라면 예외가 발생한다.")
    void shouldThrowExceptionWhenWinningNumbersCountIsNotSix(final String lottoNumbers) {
        final LottoInputView lottoInputView = new LottoInputView(
            new ConsoleMessageReader(new ByteArrayInputStream(lottoNumbers.getBytes())),
            new ConsoleMessageWriter()
        );

        assertThatIllegalArgumentException()
            .isThrownBy(lottoInputView::inputLastWeekWinningLotto);
    }

    @Test
    @DisplayName("지난 주 당첨번호에 대한 Lotto 객체가 만들어진다.")
    void shouldCreateLottoNumbersFromWinningNumbersInput() {
        final String lottoNumbers = "1, 2, 3, 4, 5, 6";
        final LottoInputView lottoInputView = new LottoInputView(
            new ConsoleMessageReader(new ByteArrayInputStream(lottoNumbers.getBytes())),
            new ConsoleMessageWriter()
        );

        assertThat(lottoInputView.inputLastWeekWinningLotto().toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}