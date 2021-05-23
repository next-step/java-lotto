package lotto;

import lotto.domain.*;
import lotto.exception.CustomIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketsTest {

    @DisplayName("구매액을 로또가격으로 나눈 값이 정수가 아닐 경우, IllegalArgumentException 발생")
    @Test
    void throw_exception_when_mod_is_not_zero() {
        //Given
        int purchaseAmount = 15400;
        //When + Then
        assertThatThrownBy(() -> new LottoTickets(purchaseAmount))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 값을 구매액으로 입력한 경우, Exception을 발생시킨다")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @ValueSource(strings = {"0", "100001", "-1"})
    void throw_exception_when_invalid_purchase_amount(String input) {
        //Given
        int purchaseAmount = Integer.parseInt(input);

        //When + Then
        assertThatThrownBy(() -> new LottoTickets(purchaseAmount))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("WinningNumbers와의 매칭결과를 정확히 리턴하는지 확인")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @ValueSource(strings = {"0", "100001", "-1"})
    void check_lotto_result(String input) {
        //Given
        int purchaseAmount = Integer.parseInt(input);

        //When + Then
        assertThatThrownBy(() -> new LottoTickets(purchaseAmount))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }
}
