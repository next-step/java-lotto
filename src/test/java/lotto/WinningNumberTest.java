package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class WinningNumberTest {

    @Test
    @DisplayName("당첨 로또 개수 계산")
    void 당첨_로또_개수_계산() {

        WinningNumber winningNumber = new WinningNumber(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6))
            , new LottoNumber(7));


        LottoRow row1 = new LottoRow(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))); // 3개 일치
        LottoRow row2 = new LottoRow(List.of(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12))); // 0개
        LottoRow row3 = new LottoRow(List.of(new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));    // 3개 일치

        LottoTicket lottoTicket = new LottoTicket(List.of(row1, row2, row3));

        Map<Prize, Integer> winningList = winningNumber.calculate(lottoTicket);

        assertThat(winningList.get(Prize.FIFTH)).isEqualTo(2);

    }

    @Test
    @DisplayName("당첨 로또 개수 계산_2등")
    void 당첨_로또_개수_계산_2등() {

        WinningNumber winningNumber = new WinningNumber(List.of(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6))
            , new LottoNumber(7));


        LottoRow row1 = new LottoRow(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))); // 2등
        LottoRow row2 = new LottoRow(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(8))); // 3등
        LottoTicket lottoTicket = new LottoTicket(List.of(row1, row2));

        Map<Prize, Integer> winningList = winningNumber.calculate(lottoTicket);

        assertThat(winningList.get(Prize.SECOND)).isEqualTo(1);
        assertThat(winningList.get(Prize.THIRD)).isEqualTo(1);
    }
}