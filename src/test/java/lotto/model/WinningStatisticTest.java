package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


class WinningStatisticTest {


    @Test
    @DisplayName("두 배열을 입력 받아 일치하는 숫자 갯수를 반환한다")
    void return_count_two_input_value_equal_number(){
        Set<Integer> source = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> target = new HashSet<>(Arrays.asList(10,2,1,4,9));

        assertThat(WinningStatistic.getEqualCount(source, target)).isEqualTo(3);
    }
}