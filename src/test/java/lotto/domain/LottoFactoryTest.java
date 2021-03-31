package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    private static int LOTTO_COUNT = 3;
    private static int WINNING_NUM = 6;

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        LottoFactory.setLottoStrategy(a -> {
            return lottoNumbers;
        });
    }

    @Test
    void createLottoTest() {
        //given, when
        Lotto lotto = LottoFactory.lotto();

        //then
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void createLottosTest() {
        //given
        List<Lotto> testList = new ArrayList<>();
        for (int i = 0; i < LOTTO_COUNT; i++) {
            testList.add(new Lotto(lottoNumbers));
        }

        //when
        Lottos lottos = LottoFactory.lottos(LOTTO_COUNT);

        //then
        assertThat(lottos).isEqualTo(new Lottos(testList));
    }

    @Test
    void createWinningTest() {
        //given
        Set<LottoNumber> winningNumber = new LinkedHashSet<>();
        for (int i = 1; i <= WINNING_NUM; i++) {
            winningNumber.add(new LottoNumber(i));
        }
        LottoNumber bonusNumber = new LottoNumber(WINNING_NUM + 1);

        //when
        WinningNumbers winning = LottoFactory.winning(winningNumber, bonusNumber);

        //then
        assertThat(winning).isEqualTo(new WinningNumbers(new LottoNumbers(winningNumber), bonusNumber));
    }
}
