package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Test
    void purchase() {
        int result = Lotto.purchase("14000");

        assertThat(result).isEqualTo(14);
    }

    @Test
    void makeLottoNumber() {
        List<Integer> result = Lotto.generate();

        assertThat(result).hasSize(6);
        assertThat(result.stream().distinct().count()).isEqualTo(6);
        for (int number : result) {
            assertThat(number).isBetween(1, 45);
        }
    }
}
