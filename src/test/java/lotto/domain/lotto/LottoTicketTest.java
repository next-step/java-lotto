package lotto.domain.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @Test
    void 생성_테스트() {
        assertThatCode(() -> LottoTicket.create(1)).doesNotThrowAnyException();
    }

    @Test
    void 구입_장수만큼_로또번호를_생성한다() {
        int quantity = 5;
        LottoTicket lottoTicket = LottoTicket.create(quantity);

        assertThatCode(() -> lottoTicket.tellLottoNumbers(quantity-1)).doesNotThrowAnyException();
        assertThatThrownBy(() -> lottoTicket.tellLottoNumbers(quantity)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 구입_장수가_0이하인경우(int quantity) {
        assertThatThrownBy(() -> LottoTicket.create(quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨결과를_생성한다() {
        String enteredWinNumber = "1, 11, 17, 23, 31, 43";
        LottoTicket lottoTicket = LottoTicket.create(1);
        assertThatCode(() -> {
            lottoTicket.makeWinningResult(enteredWinNumber);
        }).doesNotThrowAnyException();
    }
}