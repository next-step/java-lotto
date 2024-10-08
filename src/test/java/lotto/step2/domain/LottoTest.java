package lotto.step2.domain;

import org.junit.jupiter.api.Assertions;
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
        List<Integer> numbers = List.of(1, 3, 5, 7, 9, 11);

        Lotto lotto = new Lotto(numbers);

        assertTrue(lotto.hasNumber(1));
        assertTrue(lotto.hasNumber(3));
        assertTrue(lotto.hasNumber(5));
        assertTrue(lotto.hasNumber(7));
        assertTrue(lotto.hasNumber(9));
        assertTrue(lotto.hasNumber(11));
    }
}
