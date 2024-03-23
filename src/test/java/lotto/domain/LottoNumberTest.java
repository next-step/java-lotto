package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    private LottoNumber[] values;

    @BeforeEach
    public void beforeEach() {
        values = LottoNumber.values();
    }

    @Test
    @DisplayName("로또번호는 1부터 45까지의 범위의 값만 가질수 있다")
    public void Lotto_Number_Should_Have_Values_1_To_45(int input) {
        assertThat(values)
            .extracting(LottoNumber::getLottoNumber)
            .allSatisfy(lottoNumber -> assertThat(lottoNumber).isBetween(1, 45));
    }
}
