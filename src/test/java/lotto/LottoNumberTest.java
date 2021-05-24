package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @DisplayName("로또 번호 생성 테스트")
    @Test
    void createLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber).isEqualTo(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호 유효성 체크 ( 6자리 / 중복 )")
    @Test
    void isRightNumber_로또_번호_유효성_체크() {
        assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 6, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
