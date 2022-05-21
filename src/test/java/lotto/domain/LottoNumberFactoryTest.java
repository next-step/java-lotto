package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class LottoNumberFactoryTest {
    @Test
    void 생성_테스트() {
        LottoNumber lottoNumber = LottoNumberFactory.valueOf(1);

        assertThat(lottoNumber).isEqualTo(LottoNumberFactory.valueOf(1));
    }
}
