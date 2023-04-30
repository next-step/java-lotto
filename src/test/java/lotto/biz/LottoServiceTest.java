package lotto.biz;

import lotto.mock.InputUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class LottoServiceTest {

    @Test
    @DisplayName("구입금액 입력후 Lotto 갯수 결과 출력")
    void when_input_purchase_value_print_lotto_game_count() {
        InputUtil.mockInputStream("14000");
        LottoService service = new LottoService();
        service.setPurchaseValue();
    }

    @Test
    void setWinningNumbers() {
    }

    @Test
    void getWinningStatistics() {
    }
}