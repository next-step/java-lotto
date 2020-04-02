package lotto;

import lotto.domain.LottoAutoGenerator;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"14", "8", "4"})
    @DisplayName("입력한 로또개수에 만큼 로또를 만들어야 한다.")
    public void createLottoNumsTest(int lottoCount) {
        LottoTicket lottoTicket = LottoAutoGenerator.generateAutoLottoTicket(lottoCount);

        assertThat(lottoTicket.getLotteryNumbers()).hasSize(lottoCount);
        assertThat(lottoTicket.size()).isEqualTo(lottoCount);
    }

}
