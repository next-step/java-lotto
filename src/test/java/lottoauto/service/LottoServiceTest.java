package lottoauto.service;

import lottoauto.LottoFixture;
import lottoauto.domain.LottoService;
import lottoauto.model.Lottos;
import lottoauto.model.request.LottoRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    public static final int ONE_LOTTO_PRICE = 1000;
    @ParameterizedTest
    @DisplayName(value = "입력한 금액에 따른 로또 개수 구매")
    @ValueSource(ints = {4000, 5000, 13000})
    void generateLottoNumberTest(int price) {
        int quantity = price / ONE_LOTTO_PRICE;
        LottoService lottoService = new LottoService();
        LottoRequest request = new LottoRequest(price);

        Lottos lottos = lottoService.generateLottoNumber(request);
        Assertions.assertThat(quantity).isEqualTo(lottos.getSize());
    }

    @Test
    @DisplayName(value = "입력 금액이 1000원 미만일 때 예외처리")
    void inputUnderOneThousand() {
        int price = 900;
        LottoService lottoService = new LottoService();
        LottoRequest request = new LottoRequest(price);
        Assertions.assertThatThrownBy(() -> lottoService.generateLottoNumber(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 한개의 금액은 1000원 입니다.");
    }

}