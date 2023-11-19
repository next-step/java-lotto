package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

        @Test
        void 로또_번호_생성_시_중복된_번호_제거() {
                LottoNumbers lottoNumbers = new LottoNumbers(new int[]{1, 1, 2, 3, 4, 5});
                assertThat(lottoNumbers.values().size()).isEqualTo(5);
        }
}
