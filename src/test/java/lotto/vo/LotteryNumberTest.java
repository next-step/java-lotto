package lotto.vo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class LotteryNumberTest {
    Set<Integer> lottoNumbers;

    @Before
    public void setUp() throws Exception {
        lottoNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 로또생성() {
        LotteryNumber lotteryNumber = new LotteryNumber(lottoNumbers);
        assertThat("[1,2,3,4,5,6]").isEqualTo(lotteryNumber.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또가6개이하면_에러() {
        lottoNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        new LotteryNumber(lottoNumbers);
    }
}