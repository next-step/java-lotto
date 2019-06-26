package edu.nextstep.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class LottoTest {

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

    @DisplayName("LotteryNumber의 Number리스트와 각 index별 당첨번호 확인하는 기능")
    @Test
    void getMatchCountExtractNumberFromLotteryNumber() {
        LottoNumber lottoNumber = new LottoNumber(new ArrayList<>(numbers));
        LottoNumber lotteryNumber = new LottoNumber(new ArrayList<>(numbers));

        Lotto lotto = new Lotto(Arrays.asList(lotteryNumber));
        assertThat(lotto
                .getMatchCountExtractNumberFromLotteryNumber(lottoNumber)
                .get(0)).isEqualTo(6);
    }

    @DisplayName("당첨순위 별 결과같 반환")
    @Test
    void getIncomeMatchCount() {
        LottoNumber lottoNumber = new LottoNumber(numbers);
        LottoNumber lotteryNumber = new LottoNumber(lotteryNumbers);

        Lotto lotto = new Lotto(Arrays.asList(lottoNumber));
        assertThat(
                lotto.getIncomeMatchCount(lotteryNumber).get(5)
        ).isEqualTo(1);
    }

    @DisplayName("당첨 금액 반환")
    @Test
    void sumIncome() {
        LottoNumber lottoNumber = new LottoNumber(numbers);
        LottoNumber lotteryNumber = new LottoNumber(lotteryNumbers);
        Lotto lotto = new Lotto(Arrays.asList(lottoNumber));
        Money money = new Money(1000);

        List<Integer> ranks = lotto.getMatchCountExtractNumberFromLotteryNumber(lotteryNumber);

        assertThat(lotto.sumIncome(ranks, money)).isEqualTo((double) 1500000 / 1000);
    }
}
