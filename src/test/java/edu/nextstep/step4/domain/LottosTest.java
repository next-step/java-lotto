package edu.nextstep.step4.domain;

import edu.nextstep.step4.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 23:53
 */
public class LottosTest {

    private Set<Number> numbers;
    private Set<Number> lotteryNumbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>(Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)));

        lotteryNumbers = new HashSet<>(Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(7)));
    }

    @DisplayName("발행된 로또번호들과 당첨로또를 비교하여 Map에 LottoNumber와 Rank를 key, value로 반환")
    @Test
    void getLotteryLottoNumberResultCount() {
        Lotto lottoNumber = new Lotto(new HashSet<>(numbers));
        Lottos lottos = new Lottos(Arrays.asList(lottoNumber));

        Lotto lotteryNumber = new Lotto(new HashSet<>(numbers));
        WinLotto winLotto = WinLotto.of(lotteryNumber, Number.of(9));

        assertThat(lottos.getLotteryLottoNumberResultCount(winLotto).isRank(lottoNumber, Rank.SIX)).isTrue();
    }

    @DisplayName("5개 당첨된 로또들 중 보너스 번호와 비교하여 Map에 LottoNumber와 Rank를 key, value로 반환")
    @Test
    void addBonusNumberMatchLotto() {
        Lotto lottoNumber = new Lotto(new HashSet<>(numbers));
        Lottos lottos = new Lottos(Arrays.asList(lottoNumber));

        Lotto lotteryNumber = new Lotto(new HashSet<>(lotteryNumbers));
        WinLotto winLotto = WinLotto.of(lotteryNumber, Number.of(6));

        Map<Lotto, Rank> lotteryInfo = new HashMap<>();
        lotteryInfo.put(lottoNumber, Rank.matchCheck(winLotto.compareMatchNumberCount(lottoNumber)));
        WinInfo winInfo = new WinInfo(lotteryInfo);

        assertThat(lottos.addBonusNumberMatchLotto(winInfo, winLotto).isRank(lottoNumber, Rank.BONUS)).isTrue();
    }

    @DisplayName("당첨 금액 반환")
    @Test
    void fetchIncome() {
        Money money = new Money(1_000);
        Lotto lottoNumber = new Lotto(new HashSet<>(numbers));
        Lottos lottos = new Lottos(Arrays.asList(lottoNumber));

        Lotto lotteryNumber = new Lotto(new HashSet<>(lotteryNumbers));
        WinLotto winLotto = WinLotto.of(lotteryNumber, Number.of(6));

        Map<Lotto, Rank> lotteryInfo = new HashMap<>();
        lotteryInfo.put(lottoNumber, Rank.matchCheck(winLotto.compareMatchNumberCount(lottoNumber)));
        WinInfo winInfo = new WinInfo(lotteryInfo);

        WinInfo incomeInfo = lottos.addBonusNumberMatchLotto(winInfo, winLotto);
        lotteryInfo.put(lottoNumber, Rank.matchCheck(winLotto.compareMatchNumberCount(lottoNumber)));

        assertThat(lottos.fetchIncome(incomeInfo, money)).isEqualTo(30_000);
    }
}
