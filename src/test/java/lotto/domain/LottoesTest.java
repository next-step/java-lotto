package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoesTest {

    @Test
    @DisplayName("Lottoes 를 생성한다.")
    void test01() {
        Lottoes lottoes = new Lottoes(1000);

        assertThat(lottoes).isNotNull();
    }

    @Test
    @DisplayName("구입금액으로 Lottoes 를 생성한다.")
    void test02() {
        Lottoes lottoes = new Lottoes(10100);

        assertThat(lottoes.lottoes()).hasSize(10);
    }

    @Test
    @DisplayName("구입금액이 천원보다 적으면 에러를 발생한다.")
    void test03() {
        assertThatThrownBy(() -> new Lottoes(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
