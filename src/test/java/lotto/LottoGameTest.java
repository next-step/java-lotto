package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static lotto.LottoPrize.FIRST;
import static lotto.LottoPrize.FOURTH;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    LottoGeneration tempGeneration = new LottoGeneration() {
        List<List<Integer>> tempResult = new ArrayList<>(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(2, 3, 4, 5, 6, 7)));
        int count = 0;

        @Override
        public List<Integer> generate() {
            List<Integer> integers = tempResult.get(count);
            count++;
            return integers;
        }
    };

    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(2, tempGeneration);
    }

    @DisplayName("금액만큼 로또를 구매할 수 있다.")
    @Test
    void createLottoList() {
        List<Lotto> lottos = lottoGame.getLottos();
        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos.get(0).numbers()).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }


    @DisplayName(" 특정 등수에 당첨된 로또 갯수를 구한다.")
    @Test
    void FourthPrize() {
        Lotto prizeLotto = Lotto.create(() -> List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(lottoGame.matchLottoCount(FIRST, prizeLotto)).isEqualTo(1);
    }

    @DisplayName("수익률을 구할 수 있다.")
    @Test
    void name() {
        Lotto prizeLotto = Lotto.create(() -> List.of(1, 2, 3, 12, 13, 17));
        double rateOfReturn = lottoGame.getRateOfReturn(prizeLotto);
        assertThat(rateOfReturn).isEqualTo(5);
    }
}
