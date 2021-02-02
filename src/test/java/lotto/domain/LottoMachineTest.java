package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoMachineTest {
    static LottoMachine lottoMachine;
    static Map<WinningType, Integer> matchResultTarget;

    @BeforeAll
    static void initAll () {
        lottoMachine = new LottoMachine();
    }

    @Test
    void getLottoTicketNumberTest () {
        Assertions.assertThat(lottoMachine.getLottoTicketNumber(14000)).isEqualTo(14);
    }

    @Test
    void getAutoLottoTicketNumberTest () {
        Assertions.assertThat(lottoMachine.getAutoLottoTicketNumber(14, 3)).isEqualTo(11);
        Assertions.assertThat(lottoMachine.getAutoLottoTicketNumber(14, 9)).isEqualTo(5);
    }

    @Test
    void createLottoTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(lottoMachine.createLotto(lottoNumbers).getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @Test
    void createLottoFailureTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoMachine.createLotto(lottoNumbers));
    }

    @Test
    void purchaseLottosTest() {
        int money = 14000;
        Assertions.assertThat(lottoMachine.purchaseLottos(money).size()).isEqualTo(14);
    }

    @Test
    void calculateResultTest() {

        WinningLotto winningLotto = WinningLotto.generate(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 44, 45));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto5 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5);

        matchResultTarget = lottoMachine.getMatchResult();
        matchResultTarget.put(WinningType.THREE, 1); // 1, 2, 3, 43, 44, 45
        matchResultTarget.put(WinningType.FOUR, 1); // 1, 2, 3, 4, 44, 45
        matchResultTarget.put(WinningType.FIVE, 1); // 1, 2, 3, 4, 5, 45
        matchResultTarget.put(WinningType.FIVE_BONUS, 1); // 1, 2, 3, 4, 5, 7
        matchResultTarget.put(WinningType.SIX, 1); // 1, 2, 3, 4, 5, 6

        Assertions.assertThat(lottoMachine.calculateResult(winningLotto, lottos)).isEqualTo(matchResultTarget);
    }

    @Test
    void winningBallMatchNumberTest() {
        WinningLotto winningLotto = WinningLotto.generate(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45));

        Assertions.assertThat(lottoMachine.winningBallMatchNumber(winningLotto, lotto)).isEqualTo(3);
    }

    @Test
    void hasBonusBallTest() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(lottoMachine.hasBonusBall(1, lotto)).isTrue();
        Assertions.assertThat(lottoMachine.hasBonusBall(10, lotto)).isFalse();
    }

    @Test
    void getProfitRateTest() {
        matchResultTarget = lottoMachine.getMatchResult();
        matchResultTarget.put(WinningType.THREE, 1); // 1, 2, 3, 43, 44, 45
        matchResultTarget.put(WinningType.FOUR, 1); // 1, 2, 3, 4, 44, 45
        matchResultTarget.put(WinningType.FIVE, 1); // 1, 2, 3, 4, 5, 45
        matchResultTarget.put(WinningType.FIVE_BONUS, 1); // 1, 2, 3, 4, 5, 7
        matchResultTarget.put(WinningType.SIX, 1); // 1, 2, 3, 4, 5, 6
        Assertions.assertThat(LottoMachine.getProfitRate(matchResultTarget, 5000)).isEqualTo(406311.0f);
    }
}
