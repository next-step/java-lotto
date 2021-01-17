package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "34"})
    void create_test(String bonusNumber) {
        BonusNumber bonusNumber1 = new BonusNumber(bonusNumber);

        Assertions.assertThat(bonusNumber1.getLottoNumber()).isEqualTo(new LottoNumber(bonusNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"55", "-1"})
    void create_test_exception(String bonusNumber) {

        Assertions.assertThatThrownBy(() -> {
            BonusNumber bonusNumber1 = new BonusNumber(bonusNumber);
        }).isInstanceOf(IllegalArgumentException.class);


    }

}
