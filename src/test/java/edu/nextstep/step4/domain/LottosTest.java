package edu.nextstep.step4.domain;

import edu.nextstep.step3.Rank;
import edu.nextstep.step3.domain.Lotto;
import edu.nextstep.step3.domain.LottoNumber;
import edu.nextstep.step3.domain.Number;
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
        numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));
        numbers.add(new Number(4));
        numbers.add(new Number(5));
        numbers.add(new Number(6));

        lotteryNumbers = new ArrayList<>();
        lotteryNumbers.add(new Number(1));
        lotteryNumbers.add(new Number(2));
        lotteryNumbers.add(new Number(3));
        lotteryNumbers.add(new Number(4));
        lotteryNumbers.add(new Number(5));
        lotteryNumbers.add(new Number(7));
    }

    @DisplayName("발행된 로또번호들과 당첨로또를 비교하여 Map에 LottoNumber와 Rank를 key, value로 반환")
    @Test
    void getLotteryLottoNumberResultCount() {
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(numbers));
        LottoNumber lotteryNumber = new LottoNumber(new ArrayList<>(numbers));
        Lotto lotto = new Lotto(Arrays.asList(lottoNumber));

        assertThat(lotto.getLotteryLottoNumberResultCount(lotteryNumber).get(lottoNumber)).isEqualTo(Rank.SIX);
    }

    @DisplayName("5개 당첨된 로또들 중 보너스 번호와 비교하여 Map에 LottoNumber와 Rank를 key, value로 반환")
    @Test
    void addBonusNumberMatchLotto() {
        Number bonus = new Number(6);
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(numbers));
        LottoNumber lotteryNumber = new LottoNumber(new ArrayList<>(lotteryNumbers));
        Lotto lotto = new Lotto(Arrays.asList(lottoNumber));

        Map<LottoNumber, Rank> lotteryInfo = new HashMap<>();
        lotteryInfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lotteryNumber)));

        assertThat(lotto.addBonusNumberMatchLotto(lotteryInfo, bonus).get(lottoNumber)).isEqualTo(Rank.BONUS);
    }

    @DisplayName("당첨 금액 반환")
    @Test
    void fetchIncome() {
        Number bonus = new Number(6);
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(numbers));
        LottoNumber lotteryNumber = new LottoNumber(new ArrayList<>(lotteryNumbers));
        Lotto lotto = new Lotto(Arrays.asList(lottoNumber));

        Map<LottoNumber, Rank> lotteryInfo = new HashMap<>();
        lotteryInfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lotteryNumber)));

        Map<LottoNumber, Rank> incomeInfo = lotto.addBonusNumberMatchLotto(lotteryInfo, bonus);
        lotteryInfo.put(lottoNumber, Rank.matchCheck(lottoNumber.compareMatchNumberCount(lotteryNumber)));

        assertThat(lotto.fetchIncome(incomeInfo)).isEqualTo(30_000_000);
    }
}
