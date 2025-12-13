package lotto.util;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberCacheTest {
    @Test
    public void 캐싱() {
        assertThat(LottoNumberCache.get(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    public void 유효하지_않은_숫자() {
        assertThatThrownBy(() -> LottoNumberCache.get(46)).isInstanceOf(IllegalArgumentException.class);
    }

}
