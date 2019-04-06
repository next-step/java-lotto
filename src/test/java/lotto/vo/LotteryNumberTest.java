package lotto.vo;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class LotteryNumberTest {
    private static final Set<Integer> lottoNumberManual1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final Set<Integer> lottoNumberManual2 = new HashSet<>(Arrays.asList(2, 10, 28, 34, 35, 44));
    public static final LotteryNumber lottery1 = new LotteryNumber(LotteryNumberTest.lottoNumberManual1);
    public static final LotteryNumber lottery2 = new LotteryNumber(LotteryNumberTest.lottoNumberManual2);

    @Test
    public void 로또생성() {
        LotteryNumber lotteryNumber = new LotteryNumber(lottoNumberManual1);
        assertThat("[1,2,3,4,5,6]").isEqualTo(lotteryNumber.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또가6개이하면_에러() {
        Set<Integer> lottoNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        new LotteryNumber(lottoNumbers);
    }
}