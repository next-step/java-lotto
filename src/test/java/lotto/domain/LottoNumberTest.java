package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void getNumber() {
         assertThat(new LottoNumber(1).getNumber()).isEqualTo(1);
    }
}