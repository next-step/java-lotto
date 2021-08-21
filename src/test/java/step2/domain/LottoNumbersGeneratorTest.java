package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("로또 넘버 생성이 되는지 테스트한다.")
    void LottoNumbersGeneratorTest() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        LottoNumbersGenerator lottoNumbersGenerator = () -> {
            Ticket ticket = new Ticket();
            ticket.saveLottoNumbers(numbers);
            return ticket;
        };

        assertThat(lottoNumbersGenerator.generateLottoTicket().getLottoNumbers()).isEqualTo(numbers);
    }
}
