package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 45})
    void 로또_객체가_잘_생성되는지_확인한다(int arg) {
        assertThat(LottoNumber.of(arg).getValue()).isEqualTo(arg);
    }
}
