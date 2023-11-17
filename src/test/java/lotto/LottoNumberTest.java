package lotto;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @DisplayName("랜덤값이 1이상 45이하이다.")
    @Test
    void randomNumber() {
        List<Integer> lottoNumber = new LottoNumber().pickLotto();

        for (Integer number:lottoNumber) {
            assertThat(number >= 1 && number <= 45).isTrue();
        }
    }
}
