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
        String result = ConstTest.LOTTERY_NUMBER_DEFAULT.toString();

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

    @Test(expected = IllegalArgumentException.class)
    public void 로또에_보너스넘버가_있으면_에러() {
        //Given
        Set<Integer> resultLottoNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        //When
        new LotteryNumber(resultLottoNumbers, bonusNumber);
    }
}