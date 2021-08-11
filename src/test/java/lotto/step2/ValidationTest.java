package lotto.step2;

import lotto.step2.domain.LottoNumber;
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
        List<LottoNumber> list1 = Arrays.asList(new LottoNumber(3), new LottoNumber(4), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10));
        assertThatThrownBy(() ->
                Validation.isCorrectLottoCount(list1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복인지 검증")
    void isValidLotto() {
        List<LottoNumber> list3 = Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(10),
                new LottoNumber(4),
                new LottoNumber(3),
                new LottoNumber(7),
                new LottoNumber(24));
        assertThatThrownBy(() -> Validation.isValidLotto(list3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복인지 검증2")
    void isValidLotto2() {
        List<LottoNumber> list3 = Arrays.asList(
                new LottoNumber(15),
                new LottoNumber(10),
                new LottoNumber(4),
                new LottoNumber(15),
                new LottoNumber(7),
                new LottoNumber(24));
        assertThatThrownBy(() -> Validation.isValidLotto(list3)).isInstanceOf(IllegalArgumentException.class);
    }
}
