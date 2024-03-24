package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class LottoStoreTest {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    public void 돈은_null을_낼_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore lottoStore = new LottoStore(null, randomNumberGenerator);
        });
    }

    @Test
    public void 돈은_숫자_형식이어야_한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore lottoStore = new LottoStore(" ", randomNumberGenerator);
        });
    }

    @Test
    public void 돈은_1000원_이상이어야_한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore lottoStore = new LottoStore("123", randomNumberGenerator);
        });
    }

    @Test
    public void 만원_어치를_구매하면_10개의_복권이_생긴다() {
        LottoStore lottoStore = new LottoStore("10000", randomNumberGenerator);
        Lottos lottoList = lottoStore.getLottos();
        assertThat(lottoList.getLottos().size()).isEqualTo(10);
    }

    @Test
    public void 전달받은_돈을_int_형식으로_반환한다() {
        LottoStore lottoStore = new LottoStore("10000", randomNumberGenerator);
        assertThat(lottoStore.getBuyMoney()).isEqualTo(10000);
    }

    @Test
    void 수동으로_로또를_구매하고_나머지는_자동으로_구매한다() {
        String money = "5000";
        List<String> manualLottoNumbers = Arrays.asList(
                "1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12"
        );

        LottoStore lottoStore = new LottoStore(money, randomNumberGenerator, manualLottoNumbers);
        Lottos lottos = lottoStore.getLottos();

        assertNotNull(lottos);
        assertEquals(5, lottos.getLottos().size());

        List<Lotto> lottoList = lottos.getLottos();
        assertEquals("1, 2, 3, 4, 5, 6", lottoList.get(0).getLottoNumberString());
        assertEquals("7, 8, 9, 10, 11, 12", lottoList.get(1).getLottoNumberString());
    }

    @Test
    void 수동으로_구매할_돈이_부족하면_Exception을_일으킨다() {
        String money = "2000";
        List<String> manualLottoNumbers = Arrays.asList(
                "1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12",
                "13, 14, 15, 16, 17, 18"
        );

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore lottoStore = new LottoStore(money, randomNumberGenerator, manualLottoNumbers);
        });
    }
}
