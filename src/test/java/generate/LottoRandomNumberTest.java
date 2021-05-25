package generate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoRandomNumberTest {
    @Test
    public void 로또번호자동생성() {
        Integer[] numbers = LottoRandomNumber.numbers();

        assertThat(numbers.length).isEqualTo(6);

        assertThat(numbers)
                .containsOnlyOnce(
                        numbers[0],
                        numbers[1],
                        numbers[2],
                        numbers[3],
                        numbers[4],
                        numbers[5]
                );
    }

}