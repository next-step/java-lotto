package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoCountTest {

    @Test
    @DisplayName("lotto의 수가 금액보다 많으면 Exception을 throw한다.")
    void should_throw_exception() {

        //Given
        List<String> lottoNumbers = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7");

        //When & Then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoCount(4, new PurchaseAmount(1000)))
                .withMessage(ErrorMessage.CAN_NOT_BUY_LOTTO);

    }

}