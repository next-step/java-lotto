package lotto.domain;

import lotto.util.Utility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoWinnerTest {
    @Test
    void 당첨자_확인() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new Integer[]{1, 5, 10, 15, 20, 25, 30}));
        lottos.add(new Lotto(new Integer[]{2, 5, 15, 30, 36, 42, 45}));

        assertAll(
                () -> {
                    String previousLottoString = "1, 5, 15, 20, 30, 43";
                    Lotto previousLotto = new Lotto(Utility.convertStringArrayToIntegerArray(Utility.split(previousLottoString)));

                    LottoWinner lottoMachine = LottoWinner.createLottoMachine();
                    lottoMachine.calculateWinner(lottos, previousLotto);

                    Map<LottoWinnerType, Integer> winners = new HashMap<>();
                    winners.put(LottoWinnerType.SECOND_PLACE, 1);
                    winners.put(LottoWinnerType.FOURTH_PLACE, 1);

                    assertTrue(lottoMachine.getWinners().equals(winners));
                },
                () -> {
                    String previousLottoString = "2, 5, 15, 20, 30, 43";
                    Lotto previousLotto = new Lotto(Utility.convertStringArrayToIntegerArray(Utility.split(previousLottoString)));

                    LottoWinner lottoMachine = LottoWinner.createLottoMachine();
                    lottoMachine.calculateWinner(lottos, previousLotto);

                    Map<LottoWinnerType, Integer> winners = new HashMap<>();
                    winners.put(LottoWinnerType.THIRD_PLACE, 2);

                    assertTrue(lottoMachine.getWinners().equals(winners));
                }

        );
    }

    @Test
    void 수익률_계산() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(new Integer[]{1, 5, 10, 15, 20, 25, 30}));
        lottos.add(new Lotto(new Integer[]{2, 5, 15, 30, 36, 42, 45}));

        assertAll(
                () -> {
                    String previousLottoString = "1, 5, 15, 20, 30, 43";
                    Lotto previousLotto = new Lotto(Utility.convertStringArrayToIntegerArray(Utility.split(previousLottoString)));

                    LottoWinner lottoMachine = LottoWinner.createLottoMachine();
                    lottoMachine.calculateWinner(lottos, previousLotto);
                    assertThat(lottoMachine.calculateYield(lottoMachine, 10000)).isEqualTo(150.5f);
                },
                () -> {
                    String previousLottoString = "2, 5, 15, 20, 30, 43";
                    Lotto previousLotto = new Lotto(Utility.convertStringArrayToIntegerArray(Utility.split(previousLottoString)));

                    LottoWinner lottoMachine = LottoWinner.createLottoMachine();
                    lottoMachine.calculateWinner(lottos, previousLotto);
                    assertThat(lottoMachine.calculateYield(lottoMachine, 10000)).isEqualTo(10.0f);
                }

        );
    }
}