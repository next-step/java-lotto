package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNoTest {

    @DisplayName("로또 범위에 해당되지 않을 경우 예외를 발생한다")
    @Test
    void validationLottoNo() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNo(0);
            new LottoNo(46);
        });
    }

    @DisplayName("로또 넘버를 생성하고 가져온다.")
    @Test
    void getLottoNo() {
        int no = 5;
        LottoNo lottoNo = new LottoNo(no);

        assertAll(() -> assertThat(lottoNo).isEqualTo(new LottoNo(no)),
                  () -> assertThat(lottoNo.getNo()).isEqualTo(no));
   
    }
}
