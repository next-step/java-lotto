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
    public void 구매_갯수_테스트(){
        Lottos lottos = LottoMarket.purchase(Money.of(14000), new LottoNumberGenerateStrategy() {
            @Override
            public LottoNumbers generateLottoNumbers() {
                return NUMBERS;
            }
        });
        assertThat(lottos.getCount()).isEqualTo(14);
    }

    @Test
    public void 구매_갯수_테스트2(){
        Lottos lottos = LottoMarket.purchase(Money.of(999), new LottoNumberGenerateStrategy() {
            @Override
            public LottoNumbers generateLottoNumbers() {
                return NUMBERS;
            }
        });
        assertThat(lottos.getCount()).isEqualTo(0);
    }

    @Test
    public void 구매_갯수_테스트3(){
        Lottos lottos = LottoMarket.purchase(Money.of(1000), new LottoNumberGenerateStrategy() {
            @Override
            public LottoNumbers generateLottoNumbers() {
                return NUMBERS;
            }
        });
        assertThat(lottos.getCount()).isEqualTo(1);
    }

}
