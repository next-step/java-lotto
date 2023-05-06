package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @DisplayName("Lotto 게임 구매 횟수 만큼 로또가 있어야한다. ")
    @ParameterizedTest
    @ValueSource(ints = {5, 7})
    public void lotto_게임_구매_테스트(int games) {
        Lotto lotto = new Lotto();

        lotto.buyLottoGames(games);

        assertEquals(games, lotto.getLottoGames().size());
    }
}
