package lotto.domain;

import lotto.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @DisplayName("로또 구매 금액과 결제 된 로또 수량이 알맞는지")
    @ParameterizedTest
    @CsvSource({
            "14000, 14",
            "5500, 5",
            "300, 0",
    })
    void matchPriceAndPayment(int _input, int output) {
        Buyer number = new Buyer();
        Money input = new Money(_input);
        assertThat(number.matchPriceAndPayment(input)).isEqualToComparingFieldByField(output);
    }

    @DisplayName("실제 로또 당첨 번호와 일치하는 번호를 넣었을 때 일치하는지")
    @Test
    void getLotto() {
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))
        );
        LottoTicket ticket = new LottoTicket(lottoNumbers);
        LottoTicket input = new LottoTicket(lottoNumbers);
        Lotto lotto = new Lotto(ticket);

        assertThat(lotto.getLottoTicket()).isEqualToComparingFieldByField(input);
    }

    @DisplayName("실제 로또 보너스 번호와 일치하는 번호를 넣었을 떄 일치하는지")
    @Test
    void getBonusNumber() {
        LottoNumber bonus = new LottoNumber(3);
        LottoNumber input = new LottoNumber(3);
        Lotto lotto = new Lotto(bonus);
        assertThat(lotto.getBonusNumber()).isEqualTo(input);
    }

    @DisplayName("당첨 번호 맞는 갯수")
    @Test
    void matchLotto() {
        ArrayList<LottoNumber> lottoNumbers = new ArrayList<>(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))
        );
        ArrayList<LottoNumber> inputNumbers = new ArrayList<>(
                Arrays.asList(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(34),
                        new LottoNumber(35),
                        new LottoNumber(36))
        );

        LottoTicket ticket = new LottoTicket(lottoNumbers);
        LottoTicket input = new LottoTicket(inputNumbers);
        Lotto lotto = new Lotto(ticket);
        Integer result = 3;

        assertThat(lotto.matchLotto(input)).isEqualTo(result); // TODO: Count형으로 바꿔주기
    }
}
