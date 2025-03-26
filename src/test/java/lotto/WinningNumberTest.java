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

        WinningNumber winningNumber = new WinningNumber(List.of(1, 2, 3, 4, 5, 6));

        LottoRow row1 = new LottoRow(List.of(1, 2, 3, 10, 11, 12)); // 3개 일치
        LottoRow row2 = new LottoRow(List.of(7, 8, 9, 10, 11, 12)); // 0개
        LottoRow row3 = new LottoRow(List.of(4, 5, 6, 7, 8, 9));    // 3개 일치

        LottoTicket lottoTicket = new LottoTicket(List.of(row1, row2, row3));

        Map<Prize, Integer> winningList = winningNumber.calculate(lottoTicket);

        assertThat(winningList.get(Prize.FOUR)).isEqualTo(2);

    }
}