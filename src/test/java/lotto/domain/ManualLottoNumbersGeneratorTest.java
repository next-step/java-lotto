package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoNumbersGeneratorTest {

    @Test
    @DisplayName("수동으로 입력한 로또 번호를 발급한다")
    void createManualLottoNumbersTest() {
        int manualLottoCount = 2;
        List<String> lottos = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        ManualLottoNumbersGenerator lottoNumbersGenerator = new ManualLottoNumbersGenerator(manualLottoCount, lottos);

        List<LottoNumbers> manualLottoNumbers = lottoNumbersGenerator.generate();
        assertThat(manualLottoNumbers).hasSize(manualLottoCount);
    }
}
