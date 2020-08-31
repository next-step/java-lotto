package lotto.domain;

import lotto.utils.LottoValidationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @ParameterizedTest
    @DisplayName("지불 가격에 따른 로또 장 수 확인")
    @CsvSource(value = {"14000:14", "10000:10", "5000:5"}, delimiter = ':')
    void buyLottoTicket(int price, int expected) {
        int result = lottoService.getLottoBuyCount(price);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("천원 단위의 값을 지불하지 않았을 경우 Exception 발생")
    void validateInputPrice() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoValidationUtils.validateLottoTicketPrice(11500, LottoService.LOTTO_TICKET_PRICE);
                });
    }

    @Test
    @DisplayName("음수를 입력할 경우 Exceptino 발생")
    void validateInputPriceToNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoValidationUtils.validateInputNegativeNumber(-1);
                });
    }

    @Test
    @DisplayName("총 로또 장 수에서 수동 로또 장 수 제외")
    void buyAutoLottoTicket() {
        int result = lottoService.getAutoLottoBuyCount(3, 14);
        assertThat(result).isEqualTo(11);
    }
}
