package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("6개의 숫자를 입력해 로또를 생성할 수 있다. - String")
    void lottoCreateTest1() {
        assertThat(new Lotto("1,2,3,4,5,6")).isEqualTo(new Lotto("1,2,3,4,5,6"));
    }

    @Test
    @DisplayName("6개의 숫자를 입력해 로또를 생성할 수 있다. - Array")
    void lottoCreateTest2() {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        assertThat(new Lotto(numbers)).isEqualTo(new Lotto(numbers));
    }

    @Test
    @DisplayName("랜덤 숫자로 로또를 생성할 수 있다.")
    void lottoCreateTest3() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers().length).isEqualTo(6);
    }


}
