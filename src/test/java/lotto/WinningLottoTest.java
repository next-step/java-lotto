package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningLottoTest {

    private LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("당첨 로또를 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_당첨_번호_생성_테스트() {
        assertThatCode(() -> WinningLotto.of(lottoTicket)).doesNotThrowAnyException();
    }
}
