package lotto.services;

import lotto.models.request.PaymentRequest;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.strategy.PickNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private static final LottoService lottoService = new LottoService();

    private static final PickNumberStrategy strategy = new NormalPickNumberStrategy();

    @ParameterizedTest
    @DisplayName("입력한 금액만큼 로또를 발급한다.")
    @CsvSource({"1000,1", "2000,2", "3300,3", "4900,4"})
    void issueLotto1(int payment, int issueLottoCount) {
        assertThat(lottoService.issueLotto(PaymentRequest.of(payment), new ArrayList<>(), strategy).size()).isEqualTo(issueLottoCount);
    }

}
