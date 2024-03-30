package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("매번 shuffle된 List가 생성된다")
    void shuffle_test() {
        LottoNumbers lottoNumberList1 = new LottoNumbers();
        LottoNumbers lottoNumberList2 = new LottoNumbers();

        assertThat(lottoNumberList1.getNumbers()).isNotEqualTo(lottoNumberList2.getNumbers());
    }

}
