package lotto;

import calculator.PositiveNumber;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

/**
 * @author han
 */
public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void create() {
        List<PositiveNumber> numbers = Arrays.asList(new PositiveNumber("8"), new PositiveNumber("23"), new PositiveNumber("41"), new PositiveNumber("42"), new PositiveNumber("43"));
        Lotto l = new Lotto(numbers);
        assertThat(l.getNumbers().size()).isEqualTo(5);
    }
}
