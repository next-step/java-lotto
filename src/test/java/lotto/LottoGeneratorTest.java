package lotto;

import lotto.service.LottoGenerator;
import lotto.utility.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoGeneratorTest {

    @Test
    @DisplayName("1에서 45사이의 랜덤한 로또번호 생성 테스트")
    public void generateLottoNumbers() {
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        assertThat(numbers.size()).isEqualTo(6);
        assertDoesNotThrow(() -> Validator.isValidNumbers(numbers));

        numbers.forEach(number -> {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(45);
        });
    }

}