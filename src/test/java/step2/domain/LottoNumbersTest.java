package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 일급 컬렉션 테스트")
    public void getNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));

        assertThat(lottoNumbers.getNumbers().size()).isEqualTo(6);
    }
}