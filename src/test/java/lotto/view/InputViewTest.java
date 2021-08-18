package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
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
                .isThrownBy(inputView::getTotalPurchaseQuantity)
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
        LottoNumbers winningLottoNumbers = inputView.getLottoNumbers();
        assertThat(winningLottoNumbers.countOfMatch(expected))
                .isEqualTo(6);
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

    @DisplayName("수동 로또 번호 입력 테스트")
    @Test
    public void getManualLottoNumbersTest() {
        int quantity = 3;
        int[][] mockNumbers = new int[][] {{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18}};
        List<String> mockLottoNumbersInput = createMockLottoNumbersInput(mockNumbers);
        List<LottoNumbers> expectedLottoNumbers = createExpectedLottoNumbers(mockNumbers);
        String mockInput = String.join(System.getProperty("line.separator"), mockLottoNumbersInput);
        InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
        InputView inputView = InputView.of(inputStream);
        assertThat(inputView.getManualLottoNumbers(quantity))
                .anyMatch(lottoNumbers -> lottoNumbers.countOfMatch(expectedLottoNumbers.get(0)) == 6)
                .anyMatch(lottoNumbers -> lottoNumbers.countOfMatch(expectedLottoNumbers.get(1)) == 6)
                .anyMatch(lottoNumbers -> lottoNumbers.countOfMatch(expectedLottoNumbers.get(2)) == 6)
                .hasSize(quantity);
    }

    private List<String> createMockLottoNumbersInput(int[][] mockNumbers) {
        return Arrays.stream(mockNumbers)
                .map(this::createInput)
                .collect(Collectors.toList());
    }

    private List<LottoNumbers> createExpectedLottoNumbers(int[][] mockNumbers) {
        return Arrays.stream(mockNumbers)
                .map(numbers -> LottoNumbers.of(createLottoNumbers(numbers)))
                .collect(Collectors.toList());
    }

}