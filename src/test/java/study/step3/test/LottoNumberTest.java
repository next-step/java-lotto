package study.step3.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("로또 번호는 1부터 45 사이의 숫자인지 테스트")
    @ValueSource(ints = {-1, 46, 0, 100})
    public void lottoNumberInvalid(int inputNumber){
        assertThatThrownBy(()-> new LottoNumber(inputNumber)
                ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 번호 빈 값 입력시 예외처리 테스트")
    @NullAndEmptySource
    public void lottoNumberNullTest(String inputNull){
        assertThatThrownBy(()-> new LottoNumber(inputNull)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
