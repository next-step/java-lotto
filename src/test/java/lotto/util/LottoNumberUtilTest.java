package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberUtilTest {

    @Test
    void getAutoLottoNums() {
        Assertions.assertThat(LottoNumberUtil.getAutoLottoNums().size())
                .isEqualTo(6);
    }
}