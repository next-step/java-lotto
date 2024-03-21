package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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
}
