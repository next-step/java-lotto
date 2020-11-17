package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

abstract class LottoNumberGeneratorTest {

    LottoNumberGenerator lottoNumberGenerator;

//    @DisplayName("로또번호를 발급하면 6개의 숫자를 발급합니다")
//    @Test
//    void generateNumber(){
//        assertThat(lottoNumberGenerator.generate()).hasSize(6);
//    }

    @DisplayName("발급할때 마다 다른 로또번호를 발급해야 한다")
    @Test
    void generateNumber2(){
        LottoNumber num1 = lottoNumberGenerator.generate();
        LottoNumber num2 = lottoNumberGenerator.generate();
        LottoNumber num3 = lottoNumberGenerator.generate();
        LottoNumber num4 = lottoNumberGenerator.generate();
        LottoNumber num5 = lottoNumberGenerator.generate();

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

class SimpleLottoNumberGeneratorTest extends LottoNumberGeneratorTest {

    @BeforeEach
    void setUp(){
        this.lottoNumberGenerator = LottoNumberGenerator.simple();
    }

}