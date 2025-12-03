package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoCountTest {

    @Test
    void create() {
        LottoCount lottoCount = new LottoCount(3);

        Assertions.assertThat(lottoCount.getManualCount()).isEqualTo(3);
    }

    @Test
    void 수동_자동_카운트해서_생성() {
        LottoCount lottoCount = new LottoCount(new Money(14000), 3);

        Assertions.assertThat(lottoCount.getAutoCount()).isEqualTo(11);
    }
}
