package lotto.step2;

import lotto.step2.domain.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @Test
    @DisplayName("로또 당첨 번호의 개수가 6개인지 검증")
    void isCorrectLottoCount() {
        List<Integer> list1 = Arrays.asList(3, 4, 8, 9, 10);
        assertThatThrownBy(() ->
                Validation.isCorrectLottoCount(list1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨 번호의 개수가 6개인지 검증 2")
    void isCorrectLottoCount2() {
        List<Integer> list2 = Arrays.asList(3, 4, 8, 9, 10, 32, 40);
        assertThatThrownBy(() ->
                Validation.isCorrectLottoCount(list2)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복인지 검증")
    void isValidLotto() {
        List<Integer> list3 = Arrays.asList(3, 10, 10, 32, 40, 10);
        assertThatThrownBy(() -> Validation.isValidLotto(list3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복인지 검증2")
    void isValidLotto2() {
        List<Integer> list3 = Arrays.asList(3, 10, 15, 32, 3, 11);
        assertThatThrownBy(() -> Validation.isValidLotto(list3)).isInstanceOf(IllegalArgumentException.class);
    }
}
