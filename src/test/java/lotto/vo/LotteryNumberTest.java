package lotto.vo;

import lotto.utils.ConstTest;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class LotteryNumberTest {
    @Test
    public void 로또생성() {
        //When
        String result = ConstTest.lottery1.toString();

        //Then
        assertThat("[1,2,3,4,5,6]").isEqualTo(result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또가6개이하면_에러() {
        //Given
        List<Integer> givenData = Arrays.asList(1, 2, 3, 4, 5);

        //When
        Set<Integer> lottoNumbers = new HashSet<>(givenData);

        //Then
        new LotteryNumber(lottoNumbers);
    }
}