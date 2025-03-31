package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("로또 넘버를 숫자를 인자로 생성하면 해당 숫자의 로또 넘버를 생성한다.")
    void getNumber() {
         assertThat(new LottoNumber(1).getNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 넘버의 범위를 넘어가는 숫자를 인자로 생성하면, 예외가 발생한다.")
    void createWithOutOfBoundNumber() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("equals 와 hashCode 는 반드시 동시에 overriding 되어야 한다")
    void test() {
        // given
        LottoNumber number = new LottoNumber(5);
        LottoNumber targetNumber = new LottoNumber(5);
        Set<LottoNumber> numbers = new HashSet<>();

        // when
        numbers.add(number);

        // then
        // 아래 코드는 민지님 코드 기준으로 LottoNumber에 hashCode를 주석처리하고 테스트를 해보시면
        // equals는 성공하는데 contains는 실패하는 것을 볼 수 있으실 겁니다 :-)
        assertThat(number.equals(targetNumber)).isTrue();
        assertThat(numbers.contains(targetNumber)).isTrue();
    }
}