package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    @Test
    @DisplayName("정상적인 숫자로 LottoNumber를 생성시 정상 생성된다.")
    void createLottoNumber() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    @DisplayName("허용범위(1~45) 외의 숫자로 LottoNumber을 생성시 오류가 발생한다.")
    void createLottoNumber_초과범위() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(99))
                .withMessage("로또의 번호 범위를 벗어났습니다.");
    }
}