package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    LottoResult lottoResult;
    List<LottoTicket> lottoTickets;
    LastWeekLottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();

        lottoTickets = List.of(
                new LottoTicket(List.of(1, 3, 5, 7, 9, 22)),
                new LottoTicket(List.of(1, 3, 8, 22, 48, 32)),
                new LottoTicket(List.of(1, 3, 5, 12, 9, 21))
        );

        lottoNumbers = LastWeekLottoNumbers.createLottoNumbers(new String[]{"1", "3", "8", "12", "22", "42"});
    }

    @Test
    @DisplayName("4개 맞은 사람이 1명, 3개맞은 사람이 2명인지 확인")
    void 로또_결과_테스트() {
        lottoResult.calculateLottoResult(lottoTickets,lottoNumbers,3000);
        Map<Integer, Integer> lottoRankings = lottoResult.getLottoRankings();
        assertThat(lottoRankings.get(4)).isEqualTo(1);
        assertThat(lottoRankings.get(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("복권 수익/구입금액 확인")
    void 로또_수익률_테스트() {
        lottoResult.calculateLottoResult(lottoTickets,lottoNumbers,3000);
        assertThat(lottoResult.getWinPercentage()).isEqualTo(20.0);
    }
}