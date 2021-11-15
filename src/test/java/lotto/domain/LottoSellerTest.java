package lotto.domain;

import lotto.service.RandomLottoNumberGenerateStrategy;
import lotto.vo.Lottos;
import lotto.vo.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoSellerTest {

    private LottoSeller lottoSeller;
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = LottoGenerator.create(new RandomLottoNumberGenerateStrategy());
    }


    @DisplayName("Money / price 에 맞게 로또를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5000:1000:5", "4500:500:9", "10000:900:11"}, delimiter = ':')
    void buyLottoTest(BigDecimal money, BigDecimal price, int expect) {
        lottoSeller = LottoSeller.create(Money.create(price), lottoGenerator);

        Lottos lottos = lottoSeller.buyLotto(Money.create(money));

        assertThat(lottos.count()).isEqualTo(expect);
    }

    @DisplayName("Money 가 price 보다 작으면 illegal argument exception")
    @ParameterizedTest
    @CsvSource(value = {"900:1000", "499:500", "899:900"}, delimiter = ':')
    void buyLottoLessMoneyTest(BigDecimal money, BigDecimal price) {
        lottoSeller = LottoSeller.create(Money.create(price), lottoGenerator);

        assertThatIllegalArgumentException().isThrownBy(() -> lottoSeller.buyLotto(Money.create(money)));

    }

}
