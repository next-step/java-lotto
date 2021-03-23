package lotto;

import lotto.domain.LottoGames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoGamesTest {
    @DisplayName("입력한 금액만큼 로또 게임을 생성한다")
    @Test
    public void make() {
        LottoGames lottoGames = new LottoGames(14500);

        assertThat(lottoGames.getGameCount()).isEqualTo(14);
    }
}
