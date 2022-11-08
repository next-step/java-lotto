package lotto.validator;

import lotto.models.request.IssueLottoRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IssueLottoRequestValidatorTest {

    private static final String WRONG_PAYMENT = "지불한 금액은 1원 이상 이어야 합니다.";
    private static final String INSUFFICIENT_AMOUNT = "수동 번호를 입력한 개수보다 지불한 금액으로 살 수 있는 로또 수가 적습니다.";
    private static final List<String> manualLottoNumbers = new ArrayList<>();

    @BeforeAll
    public static void setManualLottoNumbers() {
        manualLottoNumbers.add("1, 2, 3, 4, 5, 6");
        manualLottoNumbers.add("1, 2, 3, 4, 5, 7");
        manualLottoNumbers.add("1, 2, 3, 4, 5, 8");
    }

    @Test
    @DisplayName("0원 이하의 금액을 입력한 경우 에러가 발생한다.")
    void test1() {
        IssueLottoRequest issueLottoRequest = IssueLottoRequest.of(0, manualLottoNumbers);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> IssueLottoRequestValidator.validate(issueLottoRequest));
        assertThat(exception.getMessage()).isEqualTo(WRONG_PAYMENT);
    }

    @Test
    @DisplayName("지불한 금액으로 살 수 없을 정도의 수의 수동 번호를 입력한 경우 에러가 발생한다.")
    void test2() {
        IssueLottoRequest issueLottoRequest = IssueLottoRequest.of(1000, manualLottoNumbers);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> IssueLottoRequestValidator.validate(issueLottoRequest));
        assertThat(exception.getMessage()).isEqualTo(INSUFFICIENT_AMOUNT);
    }
}
