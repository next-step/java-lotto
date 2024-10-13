package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LottoTest {

    @DisplayName("매개변수로 넣은 숫자가 로또번호에 있는지 확인 가능하다")
    @Test
    void createLotto() {
        LottoNumbersGenerater numbersGenerater = () -> List.of(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(7),
                LottoNumber.valueOf(9),
                LottoNumber.valueOf(11)
        );
        Lotto lotto = Lotto.create(numbersGenerater);

        assertTrue(lotto.hasNumber(1));
        assertTrue(lotto.hasNumber(3));
        assertTrue(lotto.hasNumber(5));
        assertTrue(lotto.hasNumber(7));
        assertTrue(lotto.hasNumber(9));
        assertTrue(lotto.hasNumber(11));
    }

    @DisplayName("로또는 6개의 숫자만 입력되어야 한다")
    @Test
    void limitCount(){
        LottoNumbersGenerater numbersGenerater = () -> List.of(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3)
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.create(numbersGenerater))
                .withMessage("로또 번호를 6개 입력하세요");
    }

}
