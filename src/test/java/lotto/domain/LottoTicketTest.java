package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTicketTest {
    static final int LOTTO_SIZE = 6;
    static final int LOTTO_MIN_NUMBER = 1;
    static final int LOTTO_MAX_NUMBER = 45;

    @Test
    @DisplayName("숫자가 6개가 아니면 예외를 반환한다.")
    void validateSizeTest_notLottoSize() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(input))
                .withMessageContaining("로또 번호는 6개만 가능합니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 존재하면 예외를 반환한다.")
    void validateDuplicate_duplicateNumber() {
        List<Integer> input = List.of(1, 1, 2, 3, 4, 5);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(input))
                .withMessageContaining("중복인 로또 번호가 존재합니다.");
    }

    @Test
    @DisplayName("1~45 범위의 숫자가 아니면 예외를 반환한다.")
    void validateNumberRange_notInRange() {
        List<Integer> input = List.of(50, 1, 2, 3, 4, 5);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(input))
                .withMessageContaining("로또 번호는 1 이상 45 이하의 정수만 가능합니다.");
    }

    @Test
    @DisplayName("숫자가 6개 있고, 중복된 숫자가 없고, 숫자가 1~45 범위의 숫자이면 예외를 반환하지 않는다.")
    void constructorTest_validInput() {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(() -> new LottoTicket(input));
    }
}
