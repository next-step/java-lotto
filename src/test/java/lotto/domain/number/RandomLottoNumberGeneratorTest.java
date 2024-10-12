package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumberGeneratorTest {

    private static final int FIRST_NUMBER = 1;
    private static final int LAST_NUMBER = 45;
    private static final int SIZE_OF_LOTTO = 6;

    @DisplayName("랜덤으로 로또 번호를 생성한다.")
    @Test
    void generateRandomLottoNumbers() {
        RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();
        List<Integer> numbers = generator.create();

        assertThat(numbers).hasSize(SIZE_OF_LOTTO);
        assertThat(numbers).allMatch(number -> number >= FIRST_NUMBER && number <= LAST_NUMBER);
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
