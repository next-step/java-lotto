package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("로또 번호 생성부 테스트")
public class LottoNumberGeneratorTest {

    @Test
    public void generate_numbers_with_Shuffle() {
        LottoNumberGenerator g1 = new LottoNumberGenerator();
        LottoTicket a1 = g1.generatedLottoTicketByRandom();

        assertThat(a1.numbers()
                .stream()
                .mapToInt(v -> v)
                .max()
                .getAsInt()
        ).isBetween(1, 45);
    }
}
