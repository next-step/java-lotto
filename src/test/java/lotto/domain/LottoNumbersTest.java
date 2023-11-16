package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("로또번호 객체 주소가 아닌 번호 값으로 비교한다.")
    void numbers_randomly() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoNumbers1).isEqualTo(lottoNumbers2);
    }
}