package lotto.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumTest {

    @Test
    public void getRandNums_6개_숫자() {
        List<LottoNum> randNums = LottoNum.getRandNums();
        assertThat(randNums.size()).isEqualTo(6);
    }

    @Test
    public void toLottoNums() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<LottoNum> lottoNums = LottoNum.toLottoNums(nums);

        for (int i = 0; i < lottoNums.size(); i++) {
            assertThat(nums.contains(lottoNums.get(i).getNum())).isTrue();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void toLottoNums_범위초과_46() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 46);
        List<LottoNum> lottoNums = LottoNum.toLottoNums(nums);

        for (int i = 0; i < lottoNums.size(); i++) {
            assertThat(nums.contains(lottoNums.get(i).getNum())).isTrue();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void toLottoNums_범위초과_0() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 0);
        List<LottoNum> lottoNums = LottoNum.toLottoNums(nums);

        for (int i = 0; i < lottoNums.size(); i++) {
            assertThat(nums.contains(lottoNums.get(i).getNum())).isTrue();
        }
    }


    @Test
    public void toLottoNum() {
        Integer num = 1;
        LottoNum lottoNum = LottoNum.toLottoNum(num);

        assertThat(lottoNum.getNum()).isEqualTo(num);
    }

}