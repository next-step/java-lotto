package lotto.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void 문자열변경테스트() {
        assertThat(Utils.getCommaLottoNums((new ArrayList<Integer>(Arrays.asList(43,22,33,14,36,7))))).isEqualTo("43, 22, 33, 14, 36, 7");

    }

    @Test
    public void 스트링인트리스트반환() {
        assertThat(Utils.getIntListFromString("1, 2, 3, 4, 5, 6")).hasSize(6);
    }
}
