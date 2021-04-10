package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ClerkTest {

    @Test
    @DisplayName("점원이 돈을 받고서 몇개의 로또 게임을 반환하는가를 테스")
    void returnedLottoCount() {
        Money money = new Money(14000);
        Clerk clerk = new Clerk(money);
        assertThat(clerk.returnedLottoCount()).isEqualTo(14);
    }

}
