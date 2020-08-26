package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoNumberUtilTest {


    @Test
    void getDefaultLottoNumsTest() {
        List<Integer> list = LottoNumberUtil.getDefaultLottoNums();
        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(45);
    }
}