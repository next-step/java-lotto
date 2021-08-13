package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.MatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {

    @ParameterizedTest(name = "구매 금액은 1000의 단위로 나누어 떨어지는 정수 값이 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"-1000", "14500", "abc"})
    public void invalidPurchasePriceInputTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputView inputView = InputView.of(inputStream);
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::getPurchaseAmount)
                .withMessageContaining(input);
    }

    @DisplayName("쉼표(,)를 기준으로 당첨 번호를 입력할 수 있다.")
    @Test
    public void inputWinningLottoNumbersTest() {
        int[] numbers = new int[] {1,2,3,4,5,6};
        LottoNumbers expected = LottoNumbers.of(createLottoNumbers(numbers));
        String input = createInput(numbers);

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputView inputView = InputView.of(inputStream);
        LottoNumbers winningLottoNumbers = inputView.getWinningLottoNumbers();
        assertThat(winningLottoNumbers.match(expected))
                .isEqualTo(MatchCount.SIX);
    }

    private List<LottoNumber> createLottoNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private String createInput(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }

}