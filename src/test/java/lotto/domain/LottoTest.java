package lotto.domain;


import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    final LottoStrategy testStrategy = new TestStrategy();

    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        assertThat(new Lotto(testStrategy))
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

    @Test
    @DisplayName("몇 개 맞은 로또인지 확인")
    void statCount() {
        final Lotto target = new Lotto(testStrategy);
        final Lotto winning = Lotto.winningLotto("1,2,3,4,5,6");

        assertThat(target.statCount(winning))
                .isEqualTo(6);
    }
}
