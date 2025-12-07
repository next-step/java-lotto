package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoCountTest {

    @Test
    void 수동_자동_카운트해서_생성() {
        LottoCount lottoCount = new LottoCount(11, 3);

        Assertions.assertThat(lottoCount.getAutoCount()).isEqualTo(11);
    }
}
