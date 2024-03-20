package lotto;

import lotto.domain.LottoPrize;
import lotto.domain.LottoTicket;
import lotto.exception.IllegalLottoNumbersException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    @Nested
    @DisplayName("당첨 번호와 매칭")
    class MatchNumber {

        @Test
        @DisplayName("[성공] 당첨 번호와 3개 일치하면 3을 리턴한다.")
        void 당첨_3개() {
            LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
            assertThat(lottoTicket.getPrize(new LottoTicket(List.of(1, 2, 3, 43, 44, 45)))).isEqualTo(LottoPrize.lookup(3));
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 4개 일치하면 4를 리턴한다.")
        void 당첨_4개() {
            LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
            assertThat(lottoTicket.getPrize(new LottoTicket(List.of(1, 2, 3, 4, 44, 45)))).isEqualTo(LottoPrize.lookup(4));
        }

        @Test
        @DisplayName("[성공] 당첨 번호와 모두 일치하면 6을 리턴한다.")
        void 모두_일치() {
            LottoTicket lottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
            assertThat(lottoTicket.getPrize(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(LottoPrize.lookup(6));
        }

        @Test
        @DisplayName("[실패] 로또 번호에 0이 포함되어 있으면 IllegalLottoNumberException 예외가 발생한다.")
        void 로또_번호_범위_0포함() {
            assertThatExceptionOfType(IllegalLottoNumbersException.class)
                    .isThrownBy(() -> new LottoTicket(List.of(0, 2, 3, 4, 5, 6)));
        }

        @Test
        @DisplayName("[실패] 로또 번호에 46이 포함되어 있으면 IllegalLottoNumberException 예외가 발생한다.")
        void 로또_번호_범위_46포함() {
            assertThatExceptionOfType(IllegalLottoNumbersException.class)
                    .isThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5, 46)));
        }

        @Test
        @DisplayName("[실패] 로또 번호에 0과 46이 포함되어 있으면 IllegalLottoNumberException 예외가 발생한다.")
        void 로또_번호_범위_0과_46포함() {
            assertThatExceptionOfType(IllegalLottoNumbersException.class)
                    .isThrownBy(() -> new LottoTicket(List.of(0, 2, 3, 4, 5, 46)));
        }
    }


}
