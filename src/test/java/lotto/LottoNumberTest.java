package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumberTest {
    @Test
    void create() {
        new LottoNumber(1);
    }

    @Test
    void invalid_input_over_45() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
           new LottoNumber(46);
        });
    }

    @Test
    void comparable() {
        List<LottoNumber> numbers = Arrays.asList(new LottoNumber(2), new LottoNumber(1));
        Collections.sort(numbers);

        assertThat(numbers).containsExactly(new LottoNumber(1), new LottoNumber(2));
    }
}
