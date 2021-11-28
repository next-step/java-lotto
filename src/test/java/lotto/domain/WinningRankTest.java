package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningRankTest {

    private List<LottoResult> results = new ArrayList<>();

    @BeforeEach
    void setUp() {
        WinnerLottoTicket winnerLottoTicket = WinnerLottoTicket.of("1, 2, 3, 4, 5, 6", 7);

        results.add(
            LottoResult.of(winnerLottoTicket, LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))));
        results.add(
            LottoResult.of(winnerLottoTicket, LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7)))));
        results.add(
            LottoResult.of(winnerLottoTicket, LottoTicket.from(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 8)))));
    }

    @Test
    @DisplayName("getMoney 값 일치 확인")
    void getMoney() {
        WinningRank winningRank = new WinningRank();
        winningRank.updateRank(results);
        assertThat(winningRank.getMoney()).isEqualTo(3000);
    }

    @Test
    @DisplayName("getMoney 값 일치 확인")
    void getPrizeMoney() {
        WinningRank winningRank = new WinningRank();
        winningRank.updateRank(results);
        assertThat(winningRank.getPrizeMoney()).isEqualTo(2_031_500_000);
    }
}
