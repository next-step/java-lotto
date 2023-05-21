package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoNumGeneratorTest {
    @Test
    public void 로또_숫자_범위는_1부터_45까지다() {
        //when
        LottoNumber[] lottoNumbers = LottoNumGenerator.generateResult();
        //then
        System.out.println(Arrays.stream(lottoNumbers).peek(num -> System.out.println(num)));
        for (LottoNumber lottoNumber : lottoNumbers) {
            int number = lottoNumber.getLottoNumber();
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(45);
        }
    }

    @Test
    public void 생성된_로또_숫자_갯수는_6개다() {
        //when
        LottoNumber[] numbers = LottoNumGenerator.generateResult();
        //then
        assertThat(numbers).hasSize(6);
    }
}
