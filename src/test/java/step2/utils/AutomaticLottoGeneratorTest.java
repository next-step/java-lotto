package step2.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.model.LottoNumber;
import lotto.model.PurchasedLottoTicket;

class AutomaticLottoGeneratorTest {
    @DisplayName("로또 생성 테스트")
    @Test
    public void generateLottoTest() {
        assertThatCode(PurchasedLottoTicket::create).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호 생성 테스트")
    @Test
    public void generateLottoNumberTest() {
        PurchasedLottoTicket purchasedLottoTicket = PurchasedLottoTicket.create();
        assertThat(purchasedLottoTicket.getNumbers())
            .hasSize(PurchasedLottoTicket.LOTTO_NUMBER_SIZE)
            .allMatch(number -> number.toInt() >= LottoNumber.LOTTO_MIN_NUMBER && number.toInt() <= LottoNumber.LOTTO_MAX_NUMBER);
    }
}