package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoMachineTest {
    static LottoMachine lottoMachine;
    static Map<WinningType, Integer> matchResultTarget;

    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void getLottoTicketNumberTest() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoMachine.getLottoTicketNumber(new Money(500)));
        Assertions.assertThat(lottoMachine.getLottoTicketNumber(new Money(14000))).isEqualTo(14);
    }

    @Test
    void getAutoLottoTicketNumberTest() {
        LottoPaper lottoPaper1 = new LottoPaper(Arrays.asList("1, 2, 3, 4, 5, 6"), 14, 3);
        LottoPaper lottoPaper2 = new LottoPaper(Arrays.asList("1, 2, 3, 4, 5, 6"), 14, 9);
        Assertions.assertThat(lottoMachine.getAutoLottoTicketNumber(lottoPaper1)).isEqualTo(11);
        Assertions.assertThat(lottoMachine.getAutoLottoTicketNumber(lottoPaper2)).isEqualTo(5);
    }

    @Test
    void createLottoTest() {
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList("1, 2, 3, 4, 5, 6"), 14, 3);
        List<LottoNumber> lottoNumbers = lottoPaper.getManualLottoNumbers().get(0);
        Assertions.assertThat(lottoMachine.createLotto(lottoNumbers).getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @Test
    void createLottoFailureTest() {
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList("1, 2, 3, 3, 5, 6"), 14, 3);
        List<LottoNumber> lottoNumbers = lottoPaper.getManualLottoNumbers().get(0);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoMachine.createLotto(lottoNumbers));
    }

    @Test
    void purchaseLottosTest() {
        //Given
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList("1, 2, 3, 4, 5, 6"), 14, 1);
        //When
        int result = lottoMachine.purchaseLottos(lottoPaper).size();
        //Then
        Assertions.assertThat(result).isEqualTo(14);
    }

    @Test
    void calculateResultTest() {

        WinningLotto winningLotto = WinningLotto.generate(new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new LottoNumber(7));
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList("1, 2, 3, 43, 44, 45",
                "1, 2, 3, 4, 44, 45", "1, 2, 3, 4, 5, 45", "1, 2, 3, 4, 5, 7", "1, 2, 3, 4, 5, 6"), 5, 5);
        List<Lotto> lottos = lottoMachine.purchaseLottos(lottoPaper);

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
        // 1, 2, 3, 4, 5, 6, 7
        WinningLotto winningLotto = WinningLotto.generate(new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new LottoNumber(7));

        // 1, 2, 3, 43, 44, 45
        LottoPaper lottoPaper = new LottoPaper(Arrays.asList("1, 2, 3, 43, 44, 45"), 1, 1);
        Lotto lotto = lottoMachine.purchaseLottos(lottoPaper).get(0);

        Assertions.assertThat(lottoMachine.winningBallMatchNumber(winningLotto, lotto)).isEqualTo(3);
    }

    @Test
    void hasBonusBallTest() {
        // 1, 2, 3, 4, 5, 6
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1),
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Assertions.assertThat(lottoMachine.hasBonusBall(new LottoNumber(1), lottoNumbers)).isTrue();
        Assertions.assertThat(lottoMachine.hasBonusBall(new LottoNumber(10), lottoNumbers)).isFalse();
    }

    @Test
    void getProfitRateTest() {
        matchResultTarget = lottoMachine.getMatchResult();
        matchResultTarget.put(WinningType.THREE, 1); // 1, 2, 3, 43, 44, 45
        matchResultTarget.put(WinningType.FOUR, 1); // 1, 2, 3, 4, 44, 45
        matchResultTarget.put(WinningType.FIVE, 1); // 1, 2, 3, 4, 5, 45
        matchResultTarget.put(WinningType.FIVE_BONUS, 1); // 1, 2, 3, 4, 5, 7
        matchResultTarget.put(WinningType.SIX, 1); // 1, 2, 3, 4, 5, 6
        Assertions.assertThat(LottoMachine.getProfitRate(matchResultTarget, new Money(5000))).isEqualTo(406311.0f);
    }
}
