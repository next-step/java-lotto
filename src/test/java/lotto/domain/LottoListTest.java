package lotto.domain;

import lotto.util.DivisionNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {
    @ValueSource(ints = {
            0, 10, 100
    })
    @ParameterizedTest
    void LottoListTest_newAuto(int size) {
        assertThat(
                LottoList.newAuto(6).size()
        ).isEqualTo(size);
    }
}