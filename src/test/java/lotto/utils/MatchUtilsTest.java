package lotto.utils;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchUtilsTest {

    @Test
    public void 중복제거된_갯수반환() {
        assertThat(MatchUtils.getDuplicateCount(Arrays.asList(1,2,3,4,5,6,7,8,8,7,9,6,5))).isEqualTo(3);
        assertThat(MatchUtils.getDuplicateCount(Arrays.asList(1,2,3,4,5,6,1,2,3))).isEqualTo(3);
        assertThat(MatchUtils.getDuplicateCount(Arrays.asList(1,2,3,4,5,6,1,2,3,4))).isEqualTo(4);
    }

    @Test
    public void 중복된숫자리스트반환() {
        System.out.println(Arrays.toString(MatchUtils.getDuplicateNums(Arrays.asList(1,1,2,2,3)).toArray()));
        assertThat(MatchUtils.getDuplicateNums(Arrays.asList(1,1,2,2,3))).hasSize(2);
    }

    @Test
    public void 리스트숫자포함유무() {
        assertThat(MatchUtils.isContains(Arrays.asList(1,2,3,4),4)).isEqualTo(true);
    }
}
