package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;


class LottoNumberAutoTest {

    @Test
    @DisplayName("로또가 제대로 생성되는지 테스트")
    void generateLottoNumber() {
        assertThat((LottoNumber) () -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
    }
}