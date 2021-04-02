package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {

    LottoWinner winnerLotto;
    @BeforeEach
    public void winnerSetup() {
        winnerLotto = new LottoWinner(Lotto.of(Arrays.asList(1,2,3,4,5,6)), 7);
    }

    @Test
    @DisplayName("로또 1등 테스트")
    public void test1() {
        LottoGame lottoGame = new LottoGame(createTestLottos());
        lottoGame.reset();
        lottoGame.result(winnerLotto);

    }

    private List<Lotto> createTestLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 11, 12)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 10, 11, 12)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 3, 10, 11, 13)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 9, 10, 11, 13)));
        lottos.add(Lotto.of(Arrays.asList(1, 2, 19, 20, 21, 22)));
        return lottos;
    }

}
