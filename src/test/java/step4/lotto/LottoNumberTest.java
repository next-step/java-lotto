package step4.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.lotto.domain.LottoNumber;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {


    @Test
    void init() {
        LottoNumber lottoNumber = LottoNumber.of("3");
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(3));
        assertThat(LottoNumber.of(3) == lottoNumber).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 75})
    void 로또번호_예외값_입력(int number) {
        assertThatThrownBy(() -> {
            LottoNumber.of(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동번호_6개_추출() {

        Set<LottoNumber> auto = LottoNumber.autoNumber();
        assertThat(auto.size()).isEqualTo(6);
    }
}
