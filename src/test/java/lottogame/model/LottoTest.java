package lottogame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
class LottoTest {


    LottoMachine lottoMachine = new LottoMachine();
    @DisplayName("6개 초과 들어갔을때")
    @Test
    void throwIllegalArgumentException1_1() {
        assertThatThrownBy(() -> lottoMachine.generateLotto("1,2,3,4,5,6")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개 미만 들어갔을때")
    @Test
    void throwIllegalArgumentException1_2() {
        assertThatThrownBy(() ->  lottoMachine.generateLotto("1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 숫자가 들어갔을 때")
    @Test
    void throwIllegalArgumentException1_3() {
        assertThatThrownBy(() -> lottoMachine.generateLotto("1,2,3,4,5,5")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 미만 숫자가 들어갔을때")
    @Test
    void throwIllegalArgumentException2_1() {
        assertThatThrownBy(() -> lottoMachine.generateLotto("1,2,3,4,5,0")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("45 초과 숫자가 들어갔을때")
    @Test
    void throwIllegalArgumentException2_2() {
        assertThatThrownBy(() ->  lottoMachine.generateLotto("1,2,3,4,5,46")).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("생성 순서")
    @Test
    public void order() {
        final Lotto lotto = lottoMachine.generateLotto("6,1,2,3,5,4");
        assertThat(lotto.getNumbers()).containsExactly(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }

}
