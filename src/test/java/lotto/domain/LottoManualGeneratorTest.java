package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


class LottoManualGeneratorTest {

    @Test
    void create_with_valid_number() {
        List<String> lottoNumbers = Arrays.asList("1,2,3,4,5,6", "10,15,20,25,30,35");
        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator(lottoNumbers);

        List<Lotto> actual = lottoManualGenerator.generateLottos();
        assertThat(actual.size()).isEqualTo(2);
    }

    @Test
    void create_with_invalid_text() {
        List<String> lottoNumbers = Collections.singletonList("a,b,c,d,e,f");
        LottoManualGenerator lottoManualGenerator = new LottoManualGenerator(lottoNumbers);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoManualGenerator.generateLottos());
    }
}
