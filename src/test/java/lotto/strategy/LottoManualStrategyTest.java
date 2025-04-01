package lotto.strategy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
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
        List<LottoNo> expectedNumbers = List.of(
            new LottoNo(1),
            new LottoNo(2),
            new LottoNo(3),
            new LottoNo(4),
            new LottoNo(5),
            new LottoNo(6)
        );
        LottoManualStrategy strategy = new LottoManualStrategy(List.of(LottoManualTicket.from(lottoNumbers)));
        List<Lotto> result = strategy.generateLottos();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getLottoNumbers())
            .containsExactlyElementsOf(expectedNumbers)
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

        assertThatThrownBy(() -> new LottoManualStrategy(List.of(LottoManualTicket.from(numbers))).generateLottos())
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("6개 초과의 숫자 입력 시 예외 발생")
    void excessiveNumbers_ThrowsException() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

        assertThatThrownBy(() -> new LottoManualStrategy(List.of(LottoManualTicket.from(numbers))).generateLottos())
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("범위를 벗어난 숫자 포함 시 예외 발생")
    void outOfRangeNumber_ThrowsException() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 46);

        assertThatThrownBy(() -> new LottoManualStrategy(List.of(LottoManualTicket.from(numbers))).generateLottos())
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("중복된 숫자 포함 시 예외 발생")
    void duplicateNumbers_ThrowsException() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new LottoManualStrategy(List.of(LottoManualTicket.from(numbers))).generateLottos())
            .isInstanceOf(LottoNumberException.class);
    }

    @Test
    @DisplayName("여러 개의 수동 티켓으로 로또 생성")
    void createWithMultipleTickets() {
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6);
        List<LottoNo> expectedNumbers1 = List.of(
            new LottoNo(1),
            new LottoNo(2),
            new LottoNo(3),
            new LottoNo(4),
            new LottoNo(5),
            new LottoNo(6)
        );

        List<Integer> numbers2 = List.of(7, 8, 9, 10, 11, 12);
        List<LottoNo> expectedNumbers2 = List.of(
            new LottoNo(7),
            new LottoNo(8),
            new LottoNo(9),
            new LottoNo(10),
            new LottoNo(11),
            new LottoNo(12)
        );

        LottoManualStrategy strategy = new LottoManualStrategy(List.of(
            LottoManualTicket.from(numbers1),
            LottoManualTicket.from(numbers2)
        ));

        List<Lotto> result = strategy.generateLottos();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getLottoNumbers())
            .containsExactlyElementsOf(expectedNumbers1)
            .isSorted();
        assertThat(result.get(1).getLottoNumbers())
            .containsExactlyElementsOf(expectedNumbers2)
            .isSorted();
    }
}
