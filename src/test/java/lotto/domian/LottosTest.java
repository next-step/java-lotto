package lotto.domian;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottosTest {

    @DisplayName("Lotto 게임 구매 횟수 만큼 로또가 있어야한다. ")
    @ParameterizedTest
    @ValueSource(ints = {5, 7})
    public void lotto_게임_구매_테스트(int games) {
        Lottos lottos = new Lottos(games);

        assertEquals(games, lottos.getTickets().size());
    }
}
