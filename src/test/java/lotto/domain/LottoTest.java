package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("Lotto 를 생성 - 1~45 숫자중에 6개를 랜덤 선택한다.")
    void test01() {
        Lotto lotto = new Lotto();

        System.out.println(lotto.numbers());
        assertThat(lotto.numbers()).hasSize(6);
    }

    @Test
    @DisplayName("Lotto 를 생성한다.")
    void test02() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.numbers()).containsExactly(this.getNumbers(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("숫자 6개는 정렬이 되어있어야 한다.")
    void test03() {
        Lotto lotto = new Lotto(6, 5, 4, 3, 2, 1);

        assertThat(lotto.numbers()).containsExactly(this.getNumbers(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또는 숫자 6개가 아니면 에러를 발생한다.")
    void test04() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private Number[] getNumbers(int number1, int number2, int number3, int number4, int number5, int number6) {
        return new Number[]{new Number(number1), new Number(number2), new Number(number3), new Number(number4),
                new Number(number5), new Number(number6)};
    }

}
