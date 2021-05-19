package lotto;

import lotto.domain.Amount;
import lotto.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @ParameterizedTest
    @CsvSource(value = {"14000,14", "13500,13", "12001,12"}, delimiter = ',')
    @DisplayName("금액을 입력받아 로또를 생성할 수 있다.")
    public void 금액을_입력받아_로또를_생성할_수_잇다(int source, int countOfLotto) {
        Amount total = new Amount(source);

        assertThat(Game.createByMoney(total)
                        .getLottoTickets()
                        .size())
                .isEqualTo(countOfLotto);
    }
}
