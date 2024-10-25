package lotto;

import lotto.utility.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ValidatorTest {

    @Test
    public void 유효한_숫자인치_체크() {
        assertThatThrownBy(() -> Validator.isValidNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 수는 1부터 45까지의 숫자만 가능합니다.");

        assertThatThrownBy(() -> Validator.isValidNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 수는 1부터 45까지의 숫자만 가능합니다.");
    }

    @Test
    public void 유효한_숫자들인치_체크() {
        assertThatThrownBy(() -> Validator.isValidNumbers(List.of(1, 48, 3, 41, 15, 32)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 수는 1부터 45까지의 숫자만 가능합니다.");

        assertThatThrownBy(() -> Validator.isValidNumbers(List.of(1, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자의 개수는 반드시 6개여야 합니다.");

        assertThatThrownBy(() -> Validator.isValidNumbers(List.of(1, 3, 3, 41, 15, 32)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 당첨번호가 입력되었습니다.");
    }

}
