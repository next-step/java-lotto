package lotto.domain.generator;

import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ManualLottoGeneratorTest {

    @Test
    public void generatorTest() {
        //given
        String input = "1, 2, 3, 4, 5, 6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator();
        Set<LottoNumber> lottoNumberSet = manualLottoGenerator.generate();

        //then
        assertThat(lottoNumberSet.size()).isEqualTo(6);
    }
}