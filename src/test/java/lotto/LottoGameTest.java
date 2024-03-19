package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @DisplayName("금액만큼 로또를 구매할 수 있다.")
    @Test
    void createLottoList() {
        LottoGame lottoGame = new LottoGame(2, tempGeneration);
        List<Lotto> lottos = lottoGame.getLottos();
        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos.get(0).numbers()).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }
}
