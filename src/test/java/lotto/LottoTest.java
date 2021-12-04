package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("숫자 6개가 담긴 Lotto 객체를 생성한다.")
    void shouldCreateLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }
}