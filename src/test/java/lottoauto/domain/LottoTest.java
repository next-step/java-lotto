package lottoauto.domain;

import lottoauto.model.Lottos;
import lottoauto.model.request.LottoRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {
    public static final int ONE_LOTTO_PRICE = 1000;

    @ParameterizedTest
    @DisplayName(value = "입력한 금액에 따른 자동 로또 개수 구매")
    @ValueSource(ints = {4000, 5000, 13000})
    void generateLottoAutoNumberTest(int price) {
        int quantity = price / ONE_LOTTO_PRICE;
        LottoRequest request = new LottoRequest(price);

        Lottos lottos = Lottos.from(request);
        Assertions.assertThat(quantity).isEqualTo(lottos.getSize());
    }

    @Test
    @DisplayName(value = "입력 금액이 1000원 미만일 때 예외처리")
    void inputUnderOneThousand() {
        int price = 900;

        Assertions.assertThatThrownBy(() -> new LottoRequest(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 한개의 금액은 1000원 입니다.");
    }
}
