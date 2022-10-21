package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private Lotto lotto;
    private List<LottoNumber> winningNumbers;

    @BeforeEach
    void setUp() {
        List<LottoTicket> lottoTickets = List.of(
            new LottoTicket(1, 2, 3, 4, 5, 6),
            new LottoTicket(2, 4, 6, 8, 10, 12),
            new LottoTicket(4, 5, 6, 7, 8, 9)
        );
        lotto = new Lotto(lottoTickets);

        winningNumbers = LottoNumber.createLottoNumbers(1, 2, 3, 4, 5, 6);
    }

    @Test
    void testGetWinningStat() {
        Map<LottoRank, Long> winningStat = lotto.getWinningStat(winningNumbers);
        Map<LottoRank, Long> expected = Map.of(
            LottoRank.FIRST, 1L,
            LottoRank.SECOND, 0L,
            LottoRank.THIRD, 0L,
            LottoRank.FOURTH, 2L,
            LottoRank.NONE, 0L
        );

        assertThat(winningStat).isEqualTo(expected);
    }

    @Test
    void testGetReturnRate() {
        Map<LottoRank, Long> winningStat = lotto.getWinningStat(winningNumbers);
        BigDecimal returnRate = lotto.getReturnRate(winningStat);

        assertThat(returnRate).isEqualTo(new BigDecimal(666670).setScale(2, RoundingMode.DOWN));
    }

}
