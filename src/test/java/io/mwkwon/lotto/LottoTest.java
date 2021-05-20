package io.mwkwon.lotto;

import io.mwkwon.lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 자동으로_로또_번호_생성_기능_테스트() {
        Lotto lotto = Lotto.createAutoLotto();
        assertThat(lotto.getLottoNumbers()).isNotNull();
        assertThat(lotto.getLottoNumbers()).isNotEmpty();
    }

    @Test
    void 자동으로_생성된_로또_번호들의_사이즈가_6인지_여부_테스트() {
        Lotto lotto = Lotto.createAutoLotto();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }
}
