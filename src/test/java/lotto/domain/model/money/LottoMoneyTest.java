package lotto.domain.model.money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.model.money.LottoMoney;
import lotto.exception.InvalidLottoMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMoneyTest {

    @Test
    @DisplayName("생성자가 400원을 전달 받으면 InvalidLottoMoneyException 을 throw 한다.")
    void valueOf_400_won_invalid() {
        assertThatThrownBy(() -> LottoMoney.of(400)).isInstanceOf(
                InvalidLottoMoneyException.class);
    }

    @Test
    @DisplayName("1000으로 로또 1장을 구입한다.")
    void numberOfTickets_1000_won() {
        LottoMoney lottoMoney = LottoMoney.of(1_000);
        assertThat(lottoMoney.numberOfTickets()).isEqualTo(1);
    }

    @Test
    @DisplayName("14_000으로 로또 14장을 구입한다.")
    void numberOfTickets_14000_won() {
        LottoMoney lottoMoney = LottoMoney.of(14_000);
        assertThat(lottoMoney.numberOfTickets()).isEqualTo(14);
    }
}
