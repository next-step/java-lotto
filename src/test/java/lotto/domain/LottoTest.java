package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoTest {

    @Test
    void 로또_생성_사이즈() {
        List<Long> zeroSizeList = new ArrayList<>();
        Assertions.assertThatThrownBy(() -> new Lotto(zeroSizeList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성_중복번호() {
        List<Long> duplicateNumberList = List.of(1L, 1L, 2L, 3L, 4L, 5L);
        Assertions.assertThatThrownBy(() -> new Lotto(duplicateNumberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
