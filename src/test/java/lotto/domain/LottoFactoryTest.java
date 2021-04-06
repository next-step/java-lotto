package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoNumber.LOWER_LOTTONUMBER_BOUND;
import static lotto.domain.LottoNumbers.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    private static int LOTTO_COUNT = 3;
    private static int WINNING_NUM = 6;


    private LottoNumbers lottoNumbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        Set<LottoNumber> lottoNumberSet = new LinkedHashSet<>();
        for (int i = LOWER_LOTTONUMBER_BOUND; i <= LOTTO_SIZE; i++) {
            lottoNumberSet.add(new LottoNumber(i));
        }
        lottoNumbers = new LottoNumbers(lottoNumberSet);
        lotto = new Lotto(lottoNumbers);
        LottoFactory.setLottoStrategy(() -> {
            return lotto;
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
        for (int i = LOWER_LOTTONUMBER_BOUND; i <= LOTTO_COUNT; i++) {
            testList.add(LottoFactory.lotto());
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
        ArrayList<Integer> testWinningNumbers = new ArrayList<>();
        for (int i = LOWER_LOTTONUMBER_BOUND; i <= WINNING_NUM; i++) {
            winningNumber.add(new LottoNumber(i));
            testWinningNumbers.add(i);
        }
        LottoNumber bonusNumber = new LottoNumber(WINNING_NUM + 1);
        int bonusTestNumber = WINNING_NUM + 1;


        //when
        WinningNumbers winning = LottoFactory.winning(testWinningNumbers, bonusTestNumber);

        //then
        assertThat(winning).isEqualTo(new WinningNumbers(new LottoNumbers(winningNumber), bonusNumber));
    }

    @Test
    void createMixLottosTest() {
        //given
        int manualNum = 2, testLowerBound = 10, testUpperBound = 15;
        ArrayList<Integer> manualNumbers = new ArrayList<>();
        for (int i = testLowerBound; i <= testUpperBound; i++) {
            manualNumbers.add(i);
        }

        //when
        Lottos lottos = LottoFactory.mixLottos(LOTTO_COUNT, manualNum);

        //then
        assertThat(lottos.lottoList().size()).isEqualTo(LOTTO_COUNT);
        assertThat(lottos.lottoList()).contains(new Lotto(LottoNumbers.of(manualNumbers)));
    }

}
