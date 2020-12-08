package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.VO.LottoNumber;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("Lotto Generator initial Test")
    void lottoGeneratorTest(){
        LottoGenerator lottoGenerator = new LottoGenerator();

        assertThat(lottoGenerator.numbers).hasSize(LottoNumber.maxNumber);
    }

    @Test
    @DisplayName("get lotto number Test")
    void lottoNumberTest(){
        LottoGenerator lottoGenerator = new LottoGenerator();

        List<LottoNumber> lottoNumbers = lottoGenerator.getLottoNumbers();

        for(LottoNumber lottoNumber: lottoNumbers) {
            assertThat(Integer.parseInt(lottoNumber.toString())).isLessThan(LottoNumber.maxNumber + 1);
        }

        assertThat(lottoNumbers).hasSize(LottoGenerator.lottoSize);

    }
}
