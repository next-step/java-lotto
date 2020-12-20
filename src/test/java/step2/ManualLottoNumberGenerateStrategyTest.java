package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoNumberGenerateStrategyTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    public void setUp() {
        lottoNumbers = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
    }

    @Test
    public void 생성_테스트() {
        ManualLottoNumberGenerateStrategy strategy = new ManualLottoNumberGenerateStrategy(lottoNumbers);
        assertThat(strategy.generateLottoNumbers()).isEqualTo(lottoNumbers);
    }

}
