package lotto.domain;

import lotto.vo.LottoNumber;
import lotto.vo.Lottos;
import lotto.vo.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoSellerTest {

    private LottoSeller lottoSeller;
    private LottoGenerator lottoGenerator;
    private Money money;

    @BeforeEach
    void setUp() {
        money = Money.create(1000);
        lottoGenerator = () -> Lotto.create(Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6)
        ));
        lottoSeller = LottoSeller.create(money);
    }


    @DisplayName("Money / price 에 맞게 로또를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5000:5", "4500:4", "10000:10"}, delimiter = ':')
    void sellLottosTest(BigDecimal money, int expect) {
        Lottos lottos = lottoSeller.buyLottos(Money.create(money), lottoGenerator);

        assertThat(lottos.count()).isEqualTo(expect);
    }

    @DisplayName("Money 가 price 보다 작으면 illegal argument exception")
    @ParameterizedTest
    @CsvSource(value = {"999"}, delimiter = ':')
    void sellLottosLessMoneyTest(BigDecimal money) {

        assertThatIllegalArgumentException().isThrownBy(() -> lottoSeller.buyLottos(Money.create(money), lottoGenerator));
        assertThatIllegalArgumentException().isThrownBy(() -> lottoSeller.buyLotto(Money.create(money), lottoGenerator));

    }

    @DisplayName("1장의 로또를 반환한다.")
    @Test
    void sellLottoTest() {
        Lotto lotto = lottoSeller.buyLotto(money, lottoGenerator);
        assertThat(lotto).isEqualTo(Lotto.create(Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6)
        )));
    }
}
