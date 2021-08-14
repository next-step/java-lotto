package lotto.step2;


import lotto.step2.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoTest {

    @Test
    @DisplayName("로또 구입 금액에 맞는 로또 개수")
    void generateLotto() {
        Lotto lotto = new Lotto(5000);
        Assertions.assertThat(lotto.getLottoTickets().size()).isEqualTo(5);
    }

}

