package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("로또 티켓을 생성한다.")
    void generate_lottoNumbers_test() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();

        LottoTicket lottoTicket = lottoNumbersGenerator.generateLottoTicket();

        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);

    }
}
