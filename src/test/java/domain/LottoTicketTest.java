package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {

    LottoTicket mockLottoTicket;

    List<Integer> mockLottoNumbers;
    List<Integer> mockOverSixNumbers;
    List<Integer> mockRedundantNumbers;

    @DisplayName("로또 번호가 6자리이면서 모두 다 다른 값이다.")
    @Test
    void correctLottoNumbers() {
        mockLottoNumbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        mockLottoTicket = new LottoTicket(mockLottoNumbers);
    }

    @DisplayName("로또 번호가 6자리를 넘긴다.")
    @Test
    void lottoNumbersOverSix() {
        mockOverSixNumbers = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            mockLottoTicket = new LottoTicket(mockOverSixNumbers);
        });
    }

    @DisplayName("로또 번호가 동일한 숫자가 있다.")
    @Test
    void lottoNumbersAreOverlapping() {
        mockRedundantNumbers = new LinkedList<>(Arrays.asList(1, 1, 3, 4, 5, 6));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            mockLottoTicket = new LottoTicket(mockRedundantNumbers);
        });
    }
}