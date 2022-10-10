package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoLottoTest {

    @DisplayName("자동 로또 생성 시 6개의 번호를 가진 로또가 생성된다")
    @Test
    void test(){
        AutoLotto autoLotto = AutoLotto.newAutoLottoInstance();
        Assertions.assertThat(autoLotto.getLottoNumbers().size()).isEqualTo(6);
    }
}
