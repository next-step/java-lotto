package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.LottoNumberGenerator;
import step3.model.LottoTicket;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("로또 번호 생성부 테스트")
public class LottoNumberGeneratorTest {

    @Test
    public void generate_numbers_with_Shuffle() {
        LottoNumberGenerator g1 = new LottoNumberGenerator();
        LottoTicket a1 = new LottoTicket(g1.retrieveLottoNumberList());

        assertThat(a1.numbers()
                .stream()
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt()
        ).isBetween(1, 45);
    }

    @Test
    void generated_LottoTicket_object_Test() {
        LottoNumberGenerator g1 = new LottoNumberGenerator();
        LottoTicket a1 = g1.generatedLottoTicket();
    }
}
