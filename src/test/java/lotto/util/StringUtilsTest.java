package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsTest {

    @Test
    @DisplayName("space 제거 확인")
    void testIfGetStringWithoutSpace() {
        String result = StringUtils.removeSpace("j a ck son");
        assertThat(result).isEqualTo("jackson");
    }

    @Test
    @DisplayName("split 하여 스프링 배열 생성 확인")
    void testIfGetSplitSpring() {
        String[] result = StringUtils.splitStringToLottoNumbers("1,2,3,4,5,6");
        assertThat(result).isEqualTo(new String[]{"1","2","3","4","5","6"});
    }

    @Test
    @DisplayName("문자열 정제 후 숫자 반환 확인")
    void testIfGetNumbersFromString(){
        String text = "1, 2, 3, 12, 34, 31";
        Set<Integer> result = StringUtils.refineNumbers(text);
        Set<Integer> expected = new TreeSet<>(Set.of(1,2,3,12,34,31));

        assertThat(result).isEqualTo(expected);
    }

}
