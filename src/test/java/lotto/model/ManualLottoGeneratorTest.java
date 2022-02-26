package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ManualLottoGeneratorTest {

    @DisplayName("입력된 수동로또 번호를 LottoNumber 리스트로 반환해준다")
    @Test
    void generateLotto() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(lottoNumbers);
        List<LottoNumber> manualLottoNumbers = manualLottoGenerator.generateLotto();
        assertThat(manualLottoNumbers).containsExactly(
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)
        );
    }
}
