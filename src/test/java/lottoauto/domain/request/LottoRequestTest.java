package lottoauto.domain.request;

import java.util.stream.Stream;
import lottoauto.model.request.LottoRequest;
import org.assertj.core.api.Assertions;
import org.assertj.core.internal.bytebuddy.implementation.MethodCall.ArgumentLoader.ArgumentProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class LottoRequestTest {

    @ParameterizedTest
    @DisplayName("로또 구매금액 실패 테스트")
    @CsvSource(value = {"-1, 0보다 큰 금액을 입력하셔야 합니다.", "900, 로또 한개의 금액은 1000원 입니다."})
    void buyLottoPriceFailTest(int price, String errorString) {

        Assertions.assertThatThrownBy(() -> new LottoRequest(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorString);
    }

    @Test
    @DisplayName("로또 구매금액 성공 테스트")
    void buyLottoPriceSuccessTest() {
        int buyPrice = 10000;
        int quantity = 10;

        LottoRequest lottoRequest = new LottoRequest(buyPrice);

        Assertions.assertThat(lottoRequest.getLottoQuantity()).isEqualTo(quantity);
    }


}
