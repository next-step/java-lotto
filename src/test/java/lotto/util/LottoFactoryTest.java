package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winning;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    private static int LOTTO_COUNT = 3;
    private static int WINNING_NUM = 6;

    @Test
    void createLottoTest() {
        //given, when
        Lotto lotto = LottoFactory.lotto(() -> {
            return Collections.emptyList();
        });

        //then
        assertThat(lotto).isEqualTo(new Lotto(Collections.emptyList()));
    }

    @Test
    void createLottosTest() {
        //given
        List<Lotto> testList = new ArrayList<>();
        for (int i = 0; i<LOTTO_COUNT; i++) {
            testList.add(new Lotto(Collections.emptyList()));
        }

        //when
        Lottos lottos = LottoFactory.lottos(LOTTO_COUNT, () -> {
            return Collections.emptyList();
        });

        //then
        assertThat(lottos).isEqualTo(new Lottos(testList));
    }

    @Test
    void createWinningTest() {
        //given
        List<Integer> winningNumber = new ArrayList<>();
        for (int i = 1; i<=WINNING_NUM; i++) {
            winningNumber.add(i);
        }

        //when
        Winning winning = LottoFactory.winning(winningNumber);

        //then
        assertThat(winning.getWinningNumbers()).containsAll(winningNumber);
    }
}
