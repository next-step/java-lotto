package lotto;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 생성 예외 테스트")
    void 로또_생성_예외_테스트() {
        assertThatThrownBy(()->{
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()->{
            new LottoNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
