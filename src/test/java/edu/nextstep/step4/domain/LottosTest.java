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

    private List<Number> numbers;
    private List<Number> lotteryNumbers;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6));

        lotteryNumbers = Arrays.asList(
                Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(7));
    }

    @DisplayName("발행된 로또번호들과 당첨로또를 비교하여 Map에 LottoNumber와 Rank를 key, value로 반환")
    @Test
    void getLotteryLottoNumberResultCount() {
        Lotto lottoNumber = new Lotto(new ArrayList<>(numbers));
        Lotto lotteryNumber = new Lotto(new ArrayList<>(numbers));
        Lottos lottos = new Lottos(Arrays.asList(lottoNumber));

        assertThat(lottos.getLotteryLottoNumberResultCount(lotteryNumber).get(lottoNumber)).isEqualTo(Rank.SIX);
    }

    @DisplayName("5개 당첨된 로또들 중 보너스 번호와 비교하여 Map에 LottoNumber와 Rank를 key, value로 반환")
    @Test
    void addBonusNumberMatchLotto() {
        Number bonus = Number.of(6);
        Lotto lottoNumber = new Lotto(new ArrayList<>(numbers));
        Lotto lotteryNumber = new Lotto(new ArrayList<>(lotteryNumbers));
        Lottos lottos = new Lottos(Arrays.asList(lottoNumber));

        Map<Lotto, Rank> lotteryInfo = new HashMap<>();
        lotteryInfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lotteryNumber)));

        assertThat(lottos.addBonusNumberMatchLotto(lotteryInfo, bonus).get(lottoNumber)).isEqualTo(Rank.BONUS);
    }

    @DisplayName("당첨 금액 반환")
    @Test
    void fetchIncome() {
        Number bonus = Number.of(6);
        Lotto lottoNumber = new Lotto(new ArrayList<>(numbers));
        Lotto lotteryNumber = new Lotto(new ArrayList<>(lotteryNumbers));
        Lottos lottos = new Lottos(Arrays.asList(lottoNumber));

        Map<Lotto, Rank> lotteryInfo = new HashMap<>();
        lotteryInfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lotteryNumber)));

        Map<Lotto, Rank> incomeInfo = lottos.addBonusNumberMatchLotto(lotteryInfo, bonus);
        lotteryInfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lotteryNumber)));

        assertThat(lottos.fetchIncome(incomeInfo)).isEqualTo(30_000_000);
    }
}
