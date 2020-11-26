package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class LottoNumbersGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator;

    @DisplayName("발급할때 마다 다른 로또번호를 발급해야 한다")
    @Test
    void generateNumber2(){
        LottoNumbers num1 = lottoNumberGenerator.generate();
        LottoNumbers num2 = lottoNumberGenerator.generate();
        LottoNumbers num3 = lottoNumberGenerator.generate();
        LottoNumbers num4 = lottoNumberGenerator.generate();
        LottoNumbers num5 = lottoNumberGenerator.generate();

        assertThat(num1).isNotEqualTo(num2);
        assertThat(num1).isNotEqualTo(num3);
        assertThat(num1).isNotEqualTo(num4);
        assertThat(num1).isNotEqualTo(num5);
        assertThat(num2).isNotEqualTo(num3);
        assertThat(num2).isNotEqualTo(num4);
        assertThat(num2).isNotEqualTo(num5);
        assertThat(num3).isNotEqualTo(num4);
        assertThat(num3).isNotEqualTo(num5);
        assertThat(num4).isNotEqualTo(num5);
    }

}

class SimpleLottoNumbersGeneratorTest extends LottoNumbersGeneratorTest {

    @BeforeEach
    void setUp(){
        this.lottoNumberGenerator = LottoNumberGenerator.simple();
    }

}