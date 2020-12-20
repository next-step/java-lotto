package step2;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMarketTest {

    private static final LottoNumbers NUMBERS = new LottoNumbers(
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6),
            LottoNumber.of(7)
    );

    @Test
    public void 구매테스트(){
        Lotto lotto = LottoMarket.purchase(new LottoNumberGenerateStrategy() {
            @Override
            public LottoNumbers generateLottoNumbers() {
                return NUMBERS;
            }
        });
        assertThat(lotto).isEqualTo(new Lotto(NUMBERS));
    }

}
