package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMoneyTest {

    @Test
    @DisplayName("생성자가 1_000원을 전달 받는다.")
    void valueOf_1000_won() {
        LottoMoney lottoMoney = LottoMoney.valueOf(1_000);
        assertThat(lottoMoney).isEqualTo(LottoMoney.valueOf(1_000));
    }

    @Test
    @DisplayName("생성자가 14_000원을 전달 받는다.")
    void valueOf_14000_won() {
        LottoMoney lottoMoney = LottoMoney.valueOf(14_000);
        assertThat(lottoMoney).isEqualTo(LottoMoney.valueOf(14_000));
    }

    @Test
    @DisplayName("생성자가 400원을 전달 받으면 IllegalArgumentException 을 throw 한다.")
    void valueOf_400_won_invalid() {
        assertThatThrownBy(() -> LottoMoney.valueOf(400)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000으로 로또 1장을 구입한다.")
    void numberOfTickets_1000_won() {
        LottoMoney lottoMoney = LottoMoney.valueOf(1_000);
        assertThat(lottoMoney.numberOfTickets()).isEqualTo(1);
    }

    @Test
    @DisplayName("14_000으로 로또 14장을 구입한다.")
    void numberOfTickets_14000_won() {
        LottoMoney lottoMoney = LottoMoney.valueOf(14_000);
        assertThat(lottoMoney.numberOfTickets()).isEqualTo(14);
    }
}
