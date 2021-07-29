package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    private static Numbers numbers;

    @BeforeAll
    static void setUp() {
        numbers = () -> Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
    }

    @DisplayName("로또 생성 성공")
    @Test
    void new_success() {
        assertThat(new Lottos(new Money(1000), numbers));
    }

    @DisplayName("로또 구입 개수 확인")
    @Test
    void size() {
        assertThat(new Lottos(new Money(10000), numbers).size()).isEqualTo(10);
    }

}