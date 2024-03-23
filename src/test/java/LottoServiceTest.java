import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.LottoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @Test
    public void 구입금액에_따른_로또_발급() {
        assertThat(lottoService.purchaseLotto(14000).size()).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, -1})
    public void 구입금액이_1000원_미만일_시_로또_발급_불가능(int input) {
        assertThatThrownBy(() -> lottoService.purchaseLotto(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("로또를 구매할 수 없습니다.");
    }

}

