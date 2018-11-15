package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionsTest {

    @Test
    public void Collections_shuffle_테스트() {
        int num = 50;
        List<Integer> beforeLotto = new ArrayList<>();
        List<Integer> afterLotto = beforeLotto;
        for(int i = 1; i <= num; i++) {
            beforeLotto.add(i);
        }

        Collections.shuffle(afterLotto);
        assertThat(beforeLotto).isEqualTo(afterLotto);
    }

    @Test
    public void Collections_Sort_테스트() {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(2);
        nums.add(3);
        Collections.sort(nums);
        assertThat(nums.get(0)).isEqualTo(2);
        Collections.reverse(nums);
        assertThat(nums.get(0)).isEqualTo(5);
    }

    @Test
    public void Collections_Contains_테스트() {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(2);
        nums.add(3);
        assertThat(nums.contains(2)).isEqualTo(true);
    }

}
