package lotto;

import lotto.exception.InvalidLottoNumberException;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("1~45 사이의 숫자가 아니면 로또 생성시 예외를 던진다")
    void 로또_생성_예외_테스트() {
        assertThatThrownBy(()->{
            new LottoNumber(46);
        }).isInstanceOf(InvalidLottoNumberException.class);

        assertThatThrownBy(()->{
            new LottoNumber(0);
        }).isInstanceOf(InvalidLottoNumberException.class);
    }
}
