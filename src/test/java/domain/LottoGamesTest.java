package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGamesTest {

    @Test
    void makeLottoTicketTest() {
        assertThatThrownBy(() -> new LottoGames(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Price ERR");
    }

    @DisplayName("보너스 번호 찾기 테스트")
    @Test
    void findBonusTest() {
        Set<Integer> onelotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 9));
        Set<Integer> nomallotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));

        Lottos lottos = new Lottos();
        Lotto one = new Lotto(onelotto);
        lottos.setWinnerNumber(new Lotto(nomallotto));

        assertThat(lottos.findBonus(one)).isEqualTo(9);
    }
}
