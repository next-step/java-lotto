package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTicketTest {

    @Test
    @DisplayName("숫자가 6개가 아니면 예외를 반환한다.")
    void validateSizeTest_notLottoSize() {
        List<LottoNumber> input = IntStream.rangeClosed(1, 7)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(input))
                .withMessageContaining("로또 번호는 6개만 가능합니다.");
    }

    @Test
    @DisplayName("중복된 숫자가 존재하면 예외를 반환한다.")
    void validateDuplicate_duplicateNumber() {
        List<LottoNumber> input = IntStream.of(1, 2, 3, 4, 6, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(input))
                .withMessageContaining("중복인 로또 번호가 존재합니다.");
    }

    @Test
    @DisplayName("숫자가 6개 있고, 중복된 숫자가 없고, 숫자가 1~45 범위의 숫자이면 예외를 반환하지 않는다.")
    void constructorTest_validInput() {
        List<LottoNumber> input = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        assertDoesNotThrow(() -> new LottoTicket(input));
    }
}
