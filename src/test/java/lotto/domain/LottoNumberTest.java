package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("보너스 번호가 일치하면 true반환")
    @Test
    void 번호_확인() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }
}