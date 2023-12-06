package lotto;

import lotto.model.RandomLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoTest {
    @DisplayName("로또 숫자 체크")
    @Test
    void randomNumber() {
        List<Integer> lottoNumber = RandomLotto.pickLotto();

        for (Integer number : lottoNumber) {
            assertThat(number >= 1 && number <= 45).isTrue();
        }
    }
}
