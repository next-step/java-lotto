package lotto.domain.winning;

import lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
    private WinningNumbers winningNumbers;

    @BeforeEach
    void before() {
        winningNumbers = getWinningNumbers();
    }

    @Test
    @DisplayName("보너스번호의 일치여부를 반환한다.")
    void 보너스번호_일치여부() {
        boolean match = winningNumbers.matchBonus(new LottoNumber(40));
        boolean notMatch = winningNumbers.matchBonus(new LottoNumber(41));

        assertThat(match).isTrue();
        assertThat(notMatch).isFalse();
    }

    private WinningNumbers getWinningNumbers() {
        return new WinningNumbers(List.of(10, 39, 4, 1, 23, 31),
                                  new LottoNumber(40));
    }
}
