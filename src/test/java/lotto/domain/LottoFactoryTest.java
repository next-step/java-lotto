package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    private static int LOTTO_COUNT = 3;
    private static int WINNING_NUM = 6;

    @BeforeEach
    void setUp() {
        LottoFactory.setLottoStrategy(() -> {
            return Collections.emptyList();
        });
    }

    @Test
    void createLottoTest() {
        //given, when
        Lotto lotto = LottoFactory.lotto();

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
        Lottos lottos = LottoFactory.lottos(LOTTO_COUNT);

        //then
        assertThat(lottos).isEqualTo(new Lottos(testList));
    }

    @Test
    void createWinningTest() {
        //given
        List<LottoNumber> winningNumber = new ArrayList<>();
        for (int i = 1; i<=WINNING_NUM; i++) {
            winningNumber.add(new LottoNumber(i));
        }

        //when
        Winning winning = LottoFactory.winning(winningNumber);

        //then
        assertThat(winning.getWinningNumbers()).containsAll(winningNumber);
    }
}
