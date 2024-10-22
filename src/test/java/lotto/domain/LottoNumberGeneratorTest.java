package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberGeneratorTest {
    @Test
    void genBy_AutoLottoNumberGenerator() {
        AutoLottoNumberGenerator generator = new AutoLottoNumberGenerator(3);
        assertThat(generator.generate()).hasSize(3);
    }

    @Test
    void generate() {
        class ManualLottoNumberGeneratorTest implements LottoNumberGenerator {
            private List<LottoNumbers> lottoNumbers;

            public ManualLottoNumberGeneratorTest(List<LottoNumbers> lottoNumbers) {
                this.lottoNumbers = lottoNumbers;
            }

            @Override
            public List<LottoNumbers> generate() {
                return lottoNumbers;
            }
        }
        List<LottoNumbers> numbers  = Arrays.asList(new LottoNumbers(new int[] {1,2,3,4,5,6}));
        assertThat(new ManualLottoNumberGeneratorTest(numbers).generate()).hasSize(1);
        assertThat(new ManualLottoNumberGeneratorTest(numbers).generate()).isEqualTo(numbers);
    }



}
