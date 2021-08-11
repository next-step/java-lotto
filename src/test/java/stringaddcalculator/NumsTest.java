package stringaddcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class NumsTest {

    @Test
    void create() {
        // given
        String[] numsArr = {"1", "2", "3"};

        // when
        Nums nums = Nums.of(numsArr);

        // then
        assertThat(nums.getNums()).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void invalid(){
        // given
        String[] numsArr = {"-1", "2", "3"};

        // when, then
        assertThatThrownBy(() -> Nums.of(numsArr)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void sum() {
        // given
        Nums nums = Nums.of(new String[]{"1", "2", "3"});

        // when
        int result = nums.sum();

        // then
        assertThat(result).isEqualTo(6);
    }
}
