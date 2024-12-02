import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberCacheTest {
    @Test
    void get_cache_instance() {
        assertThat(LottoNumberCache.get(1)).isEqualTo(LottoNumberCache.get(1));
        assertThat(LottoNumberCache.get(1)).isSameAs(LottoNumberCache.get(1));
    }
}
