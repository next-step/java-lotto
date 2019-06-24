package edu.nextstep.step2;

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

    @DisplayName("LotteryNumber의 Number리스트와 각 index별 당첨번호 확인하는 기능")
    @Test
    void getMatchCountExtractNumberFromLotteryNumber() {
        List<Number> numbers = new ArrayList<>();
        numbers.add(new Number(1));
        numbers.add(new Number(2));
        numbers.add(new Number(3));
        numbers.add(new Number(4));
        numbers.add(new Number(5));
        numbers.add(new Number(6));

        LotteryNumber lotteryNumber = new LotteryNumber(new ArrayList<>(numbers));
        ExtractionNumber exNumber = new ExtractionNumber(new ArrayList<>(numbers));

        Lotto lotto = new Lotto(Arrays.asList(exNumber));
        assertThat(lotto
                .getMatchCountExtractNumberFromLotteryNumber(lotteryNumber)
                .get(0)).isEqualTo(6);
    }
}
