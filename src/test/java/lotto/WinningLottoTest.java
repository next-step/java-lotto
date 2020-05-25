package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningLottoTest {

    private LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("당첨 로또를 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_당첨_번호_생성_테스트() {
        assertThatCode(() -> WinningLotto.of(lottoTicket)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 개수 검증를 검증한다.")
    void 로또_당첨_번호_검증_테스트() {
        WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(Arrays.asList(1, 2, 3, 6, 7, 8)));
        assertThat(winningLotto.containsNumberCount(lottoTicket)).isEqualTo(4);
    }
}
