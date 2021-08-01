package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTests {

    @DisplayName("로또 번호 생성 테스트")
    @Test
    void generateLottoNumberTest() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        assertThat(lottoNumber.value()).isEqualTo(Arrays.asList(8, 21, 23, 41, 42, 43).toString());
    }
}
