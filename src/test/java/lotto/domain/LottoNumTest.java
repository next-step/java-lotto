package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumTest {

    @DisplayName("로또 번호는 1부터 45까지의 수가 아니면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0,-1,46})
    void given_not_1_to_45_num_when_lotto_num_create_then_throw_exception(int lottoNum){
        assertThatIllegalArgumentException()
            .isThrownBy(()->new LottoNum(lottoNum));
    }

    @DisplayName("로또 번호는 1부터 45까지의 수를 가지고 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1,3,45})
    void given_1_to_45_num_when_lotto_num_create_then_success(int lottoNum){
        new LottoNum(lottoNum);
    }
}
