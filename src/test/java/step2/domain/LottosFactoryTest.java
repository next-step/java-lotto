package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.exception.LottoException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosFactoryTest {

    @DisplayName("LottoNumbers 한 개는 1000원이고, 구입 금액에 따라 로또 번호들을 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"140000:14", "14300:14", "990:0"}, delimiter = ':')
    void buyWithMoney() {
        Lottos lottos = LottosFactory.buyWithMoney(14000);
        assertThat(lottos.size()).isEqualTo(14);
    }

    @DisplayName("구입할 금액은 숫자를 입력해야한다. ")
    @Test
    void buyWithMoneyValidation() {
        assertThatThrownBy(() -> LottosFactory.buyWithMoney("string"))
                .isInstanceOf(LottoException.class);
    }

}