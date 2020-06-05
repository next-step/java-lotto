package lotto;

import lotto.model.LottoPrize;
import lotto.model.Winner;
import lotto.model.WinnerCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCollectionTest {

    List<Winner> winners = new ArrayList<>();

    @BeforeEach
    void winnerTestBefore() {
        winners.add(new Winner(LottoPrize.FIRST_PRIZE, LottoPrize.FIRST_COUNT));
        winners.add(new Winner(LottoPrize.FIRST_PRIZE, LottoPrize.FIRST_COUNT));
        winners.add(new Winner(LottoPrize.SECOND_PRIZE, LottoPrize.SECOND_COUNT));
    }

    @DisplayName("당첨 리스트 일급 컬렉션 카운트 테스트")
    @Test
    void winnerCountTest() {
        assertThat(new WinnerCollection(winners).getWinnerCount(LottoPrize.SECOND_COUNT)).isEqualTo(1);
        assertThat(new WinnerCollection(winners).getWinnerCount(LottoPrize.FIRST_COUNT)).isEqualTo(2);
    }

    @DisplayName("당첨 리스트 일급 컬렉션 테스트 당첨")
    @Test
    void winner_total_prize_test() {
        int expected = LottoPrize.FIRST_PRIZE * 2 + LottoPrize.SECOND_PRIZE;
        assertThat(new WinnerCollection(winners).getTotalPrize()).isEqualTo(expected);
    }


}
