package lotto.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void 문자열변경테스트() {
        assertThat(Utils.getIntListFromString("43, 22, 33, 14, 36, 7")).hasSize(6);

    }

    @Test
    public void 스트링인트리스트반환() {
        assertThat(Utils.getIntListFromString("1, 2, 3, 4, 5, 6")).hasSize(6);
    }

    @Test
    public void 수익률구하기() {
        assertThat(Utils.getProfit(15000,1000)).isEqualTo(15);
    }
}
