package lotto;

import lotto.service.LottoGenerator;
import lotto.utility.Validator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoGeneratorTest {

    @Test
    public void 로또번호_생성() {
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        assertThat(numbers.size()).isEqualTo(6);
        assertDoesNotThrow(() -> Validator.isValidNumbers(numbers));

        numbers.forEach(number -> {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(45);
        });
    }
}
