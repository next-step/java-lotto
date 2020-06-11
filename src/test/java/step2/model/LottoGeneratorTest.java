package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("입력한 자동 로또 개수와 생성된 자동 개수는 동일")
    @ValueSource(ints = {1, 20, 100})
    @ParameterizedTest
    void generateAutoType(int autoCount) {
        LottoTicket lottoTicket = LottoTicketGenerator.generate(autoCount, ManualLottoNumbers.empty());
        assertThat(lottoTicket.getAutoCount()).isEqualTo(autoCount);
    }

    @DisplayName("입력한 수동 로또 개수와 생성된 수동 개수는 동일")
    @Test
    void generateManualType() {
        ManualLottoNumbers manualLottoNumbers = LottoData.createManualLottoNumbers(10);
        LottoTicket lottoTicket = LottoTicketGenerator.generate(0, manualLottoNumbers);
        assertThat(lottoTicket.getManualCount()).isEqualTo(10);
    }
}
