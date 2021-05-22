package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    void 생성자_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers).isNotNull();
    }

    @Test
    void 로또번호_1부터_45이외의_숫자_체크_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,46));
    }
}
