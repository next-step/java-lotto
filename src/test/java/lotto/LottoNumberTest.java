package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호 생성 테스트")
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,
                    34,35,36,37,38,39,40,41,42,43,44,45})
    public void test(int input){
        LottoNumber lottoNumber = new LottoNumber(input);

        assertThat(lottoNumber.getNumber()).isEqualTo(input);
        assertThat(lottoNumber.getNumberString()).isEqualTo(Integer.toString(input));
    }

    @ParameterizedTest
    @DisplayName("로또 번호 생성 에러 테스트")
    @ValueSource(ints = {-1,-2,-100,46,1000})
    public void test2(int input){
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(input));
    }
}