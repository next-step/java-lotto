package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersGeneratorTest {

    @Test
    @DisplayName("매번 shuffle된 List가 생성된다")
    void shuffle_test() {
        NumbersGenerator lottoNumberList1 = new NumbersGenerator();

        assertThat(lottoNumberList1.shuffle()).isNotEqualTo(lottoNumberList1.shuffle());
    }

}
