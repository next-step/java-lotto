package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoManualServiceTest {

    @Test
    @DisplayName("수동로또 - 구매번호 미입력 : null")
    void nullInput() {
        // given
        LottoManualService lottoManualService = new LottoManualService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoManualService.purchaseLottoTicket(null));
    }

    @Test
    @DisplayName("수동로또 - 구매번호 미입력 : 빈 리스트")
    void emptyInput() {
        // given
        LottoManualService lottoManualService = new LottoManualService();

        // when then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoManualService.purchaseLottoTicket(new ArrayList<>()));
    }
}