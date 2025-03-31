package lotto.strategy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.LottoGenerationException;
import lotto.exception.LottoNumberException;
import lotto.vo.LottoManualTicket;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoManualStrategyTest {

    @Test
    @DisplayName("유효한 수동 입력으로 로또 생성")
    void createWithValidNumbers() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoManualStrategy strategy = new LottoManualStrategy(new LottoManualTicket(lottoNumbers));
        List<Integer> result = strategy.generate().getLottoNumbers();

        assertThat(result)
            .containsExactlyElementsOf(lottoNumbers)
            .isSorted();
    }

    @Test
    @DisplayName("null 입력 시 예외 발생")
    void nullInput_ThrowsException() {
        assertThatThrownBy(() -> new LottoManualStrategy(null))
            .isInstanceOf(LottoGenerationException.class);
    }

    @Test
    @DisplayName("6개 미만의 숫자 입력 시 예외 발생")
    void insufficientNumbers_ThrowsException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new LottoManualStrategy(new LottoManualTicket(numbers)).generate())
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("6개 초과의 숫자 입력 시 예외 발생")
    void excessiveNumbers_ThrowsException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new LottoManualStrategy(new LottoManualTicket(numbers)).generate())
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("범위를 벗어난 숫자 포함 시 예외 발생")
    void outOfRangeNumber_ThrowsException() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 46);

        assertThatThrownBy(() -> new LottoManualStrategy(new LottoManualTicket(numbers)).generate())
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("중복된 숫자 포함 시 예외 발생")
    void duplicateNumbers_ThrowsException() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new LottoManualStrategy(new LottoManualTicket(numbers)).generate())
            .isInstanceOf(LottoNumberException.class);
    }
}
