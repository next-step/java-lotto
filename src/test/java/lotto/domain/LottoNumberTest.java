package lotto.domain;

//- [ ] 로또 번호는 총 6개이다
//- [ ] 로또 번호는 1부터 45 사이의 숫자이다
//    - [ ] 로또 번호 범위를 벗어나면 IllegalArgumentException을 발생시킨다
//- [ ] 로또 번호는 중복되지 않아야 한다
//    - [ ] 로또 번호 중복 시 IllegalArgumentException을 발생시킨다

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void 로또_번호_생성() {
        LottoNumber lottoNumber = LottoNumber.of(1);

        assertThat(lottoNumber.getValue()).isEqualTo(1);
    }

    @Test
    void 로또_번호의_범위를_벗어나면_예외발생1to45() {
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 한다");

        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 한다");
    }

    @Test
    void 같은_번호는_동등성을_가진다() {
        LottoNumber number1 = LottoNumber.of(1);
        LottoNumber number2 = LottoNumber.of(1);

        assertThat(number1).isEqualTo(number2);
    }

}
