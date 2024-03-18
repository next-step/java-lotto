package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoStoreTest {

    @Test
    public void 돈은_null을_낼_수_없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore lottoStore = new LottoStore(null);
        });
    }

    @Test
    public void 돈은_숫자_형식이어야_한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore lottoStore = new LottoStore(" ");
        });
    }

    @Test
    public void 돈은_1000원_이상이어야_한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore lottoStore = new LottoStore("123");
        });
    }

    @Test
    public void 만원_어치를_구매하면_10개의_복권이_생긴다() {
        LottoStore lottoStore = new LottoStore("10000");
        List<Lotto> lottoList = lottoStore.getLottos();
        assertThat(lottoList.size()).isEqualTo(10);
    }
}
