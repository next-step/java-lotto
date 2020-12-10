package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.VO.ManualLottoNumbers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ManualLottoNumbersTest {
    @Test
    @DisplayName("ManualLottoNumbers default test")
    void CheckResultNumberTest() {
        ManualLottoNumbers manualLottoNumbers = new ManualLottoNumbers("1, 3, 5, 6, 8, 9");
        assertThat(manualLottoNumbers.getManualLottoNumbers()).hasSize(LottoGenerator.lottoSize);
    }

    @Test
    @DisplayName("ManualLottoNumbers size error test")
    void CheckBonusNumberTest() {
        assertThatThrownBy(() -> new ManualLottoNumbers("1, 3, 5, 6, 8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
