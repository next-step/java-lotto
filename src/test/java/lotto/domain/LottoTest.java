package lotto.domain;

import lotto.exception.NumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    @DisplayName("생성될 로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void create_list_exception() {
        List<LottoNumber> numbers = new ArrayList<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));

        assertThatExceptionOfType(NumberCountException.class).isThrownBy(
                () -> new Lotto(numbers));
    }

    @DisplayName("지난주 당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void create_string_exception() {
        String lastWeekNumber = "1,2,3";
        assertThatExceptionOfType(NumberCountException.class).isThrownBy(
                () -> new Lotto(lastWeekNumber));
    }
}