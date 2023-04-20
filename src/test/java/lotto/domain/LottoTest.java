package lotto.domain;


import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    final LottoStrategy lottoStrategy = new TestStrategy();

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertThat(new Lotto(lottoStrategy))
                .extracting("lottoNumbers")
                .isNotNull();
    }

    @Test
    @DisplayName("우승 번호 로또 생성")
    void winningLotto() {
        final Lotto winningLotto = Lotto.winningLotto("1,2,3,4,5,6");

        assertThat(winningLotto)
                .isEqualTo(Lotto.winningLotto("1,2,3,4,5,6"));
    }

}
