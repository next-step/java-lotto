package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    @DisplayName("로또의 숫자는 1 ~ 45가 아니면 예외를 발생시킨다")
    void exceptionTest(final int nums){
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.of(nums));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,44,45})
    @DisplayName("로또의 숫자는 1 ~ 45로 구성되어 있다")
    void ofTest(final int nums){
        LottoNumber lottoNumber = LottoNumber.of(nums);
        assertThat(lottoNumber.getNum()).isEqualTo(nums);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,44,45})
    @DisplayName("로또의 숫자는 1 ~ 45로 구성되어 있다")
    void ofEqualsTest(final int nums){
        LottoNumber lottoNumber1 = LottoNumber.of(nums);
        LottoNumber lottoNumber2 = LottoNumber.of(nums);
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
        assertThat(lottoNumber1).isSameAs(lottoNumber2);
    }

}