package lotto;

import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {
    @Test
    void generateLottoNumbers() {
        int rangeNumberMin = 1;
        int rangeNumberMax = 45;
        List<Integer> lottoNumbers = LottoNumberGenerator.generate();
        System.out.printf("lottoNumbers : %s\r\n", lottoNumbers);
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers.get(0) >= rangeNumberMin).isTrue();
        assertThat(lottoNumbers.get(5) <= rangeNumberMax).isTrue();
    }
}
