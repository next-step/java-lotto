package lotto.domain;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTicketTest {

    @DisplayName("LottoNumber 리스트의 크기가 6이 아니면 IllegalArgumentException Throw")
    @Test
    void lottoTicketThrowsExceptionWhenSizeOver() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .withMessage("로또 번호는 6개만 가능합니다.");
    }

    @DisplayName("LottoNumber 리스트에 중복된 번호가 있으면 IllegalArgumentExceptionThrow")
    @Test
    void lottoTicketThrowsExceptionWhenDuplicateNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .withMessage("로또 번호는 중복 될 수 없습니다.");
    }

    @DisplayName("LottoNumber 리스트에 매개값으로 받은 번호가 존재하는지 판단.")
    @ParameterizedTest
    @CsvSource({"3, true", "7, false"})
    void isContainingLottoNumber(int number, boolean expectResult) {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoTicket.isContainingLottoNumbers(LottoNumber.valueOf(number))).isEqualTo(expectResult);
    }

    @DisplayName("가지고있는 LottoNumber 리스트를 Integer 리스트로 반환")
    @Test
    void getLottoNumbers() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoTicket.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}