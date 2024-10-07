package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LottoTest {

    @DisplayName("로또 번호 6개만 선택 가능하다")
    @Test
    void createLotto() {
        List<Integer> numbers = List.of(1, 3, 5, 7, 9, 11, 13);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage("로또 숫자는 6개만 선택 가능합니다");
    }

    @DisplayName("로또 번호의 범위는 1-45 범위 내에서 생성된다")
    @Test
    void createLottoNumberRange(){
        List<Integer> numbers = List.of(0, 46, 47, 48, 49, 50);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage("로또 숫자는 1-45이내의 숫자만 선택 가능합니다");
    }

    @DisplayName("로또 번호는 중복될 수 없습니다")
    @Test
    void duplicateLottoNumber(){
        List<Integer> numbers = List.of(45, 45, 43, 42, 41, 40);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage("로또 숫자는 중복될 수 없습니다");
    }


}
