package util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    @Test
    void testGetLottoNumbersProducesDifferentResults() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        List<Integer> firstRun = lottoNumberGenerator.getLottoNumbers();
        List<Integer> secondRun = lottoNumberGenerator.getLottoNumbers();
        List<Integer> thirdRun = lottoNumberGenerator.getLottoNumbers();

        assertThat(firstRun).isNotEqualTo(secondRun);
        assertThat(secondRun).isNotEqualTo(thirdRun);
        assertThat(firstRun).isNotEqualTo(thirdRun);
    }
}
