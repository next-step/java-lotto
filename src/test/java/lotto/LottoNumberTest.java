package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("범위를 벗어나는 값을 입력하면 Exception을 던진다")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @ValueSource(ints = {-1, 0, 46})
    void throw_exception_when_out_of_range(int input) {
        //Given+When+Then
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }    
}
