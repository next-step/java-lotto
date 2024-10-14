package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.number.LottoNumber.FIRST_NUMBER;
import static lotto.domain.number.LottoNumber.LAST_NUMBER;
import static lotto.domain.ticket.LottoTicket.SIZE_OF_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoNumberGeneratorTest {

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
