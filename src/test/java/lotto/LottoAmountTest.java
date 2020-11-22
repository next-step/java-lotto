package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoAmountTest {

    public static final int LOTTO_PRICE = 1000;

    @Test
    @DisplayName("로또 금액에 따른 로또 구입 갯수를 반환한다.")
    void should_return_lotto_amount(){
        //Given
        int amount = 14000;

        //When
        LottoAmount lottoAmount = new LottoAmount(amount);

        //Then
        assertThat(lottoAmount.getLottoCount()).isEqualTo(14);
    }


    @ParameterizedTest
    @DisplayName("입력한 금액이 1000원이하의 금액이면 따른 IllegalArgumentException을 throw 한다.")
    @ValueSource(ints = {-14000, 500,})
    void should_throw_illegal_argument_exception(int amount){

        assertThatIllegalArgumentException()
                .isThrownBy(()-> new LottoAmount(amount))
                .withMessage("lotto amount is wrong.");
    }

}
