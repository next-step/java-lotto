package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {
    @Test
    @DisplayName("로또 생성 테스트")
    public void create(){
        Lotto lotto = LottoFactory.create();

        assertThat(lotto).isNotNull();
        assertThat(lotto.toString()).isNotNull();
        assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
