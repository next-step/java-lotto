package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"14000,14", "1100,1"})
    void 로또_구입_성공(int gameMoney, int expectedCount) {
        int buyingCount = LottoGame.of(gameMoney).getTicketsString().size();
        assertThat(buyingCount).isEqualTo(expectedCount);
    }

    @Test
    void 로또_구입_실패() {
        assertThatThrownBy(() -> {
            LottoGame.of(0);
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> {
            LottoGame.of(2000, Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,7", "1,2,3,4,5,8"));
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 유효하지_않은_보너스숫자(int bonusNumber) {
        LottoGame lottoGame = LottoGame.of(1000);
        assertThatThrownBy(() -> {
            lottoGame.doGame("1,2,3,4,5,6", bonusNumber);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 당첨_확인() {
        List<String> ticketTexts = Arrays.asList("1,2,3,4,5,7", "1,2,3,14,15,17");
        LottoGame game = LottoGame.of(2000, ticketTexts);
        LottoStatistics statistics = game.doGame("1,2,3,4,5,6", 7);

        double winPercent = Math.round((double) 30005000 / 2000 * 10000) / 100.0;

        assertThat(statistics.getWinPercents()).isEqualTo(winPercent);
    }


}
