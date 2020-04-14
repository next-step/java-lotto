package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    @DisplayName("로또에 사용 되는 숫자는 값 객체로 생성한다")
    void createLottoNumberByConstructor() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(new LottoNumber(1)).isEqualTo(lottoNumber);
    }
}
