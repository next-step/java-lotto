package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    @Test
    void test_자동생성() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.numbers()).hasSize(6);
    }

    @Test
    void test_번호일치여부() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.isNumberMatched(new LottoNumber(4))).isTrue();
    }
}
