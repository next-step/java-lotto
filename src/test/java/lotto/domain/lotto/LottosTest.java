package lotto.domain.lotto;

import lotto.domain.exception.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 일급컬렉션 테스트")
public class LottosTest {

    @DisplayName("로또 일급컬렉션 생성")
    @ParameterizedTest
    @CsvSource(value = {"10000:10", "14000:14", "100:0"}, delimiter = ':')
    public void makeLottosFromMoney(int money, int expectedLottoCount) {
        Lottos lottos = Lottos.withMoney(money);

        int lottoCount = lottos.getCount();

        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }

    @DisplayName("로또 구입시 0보다 작은 숫자 입력되면 에러")
    @Test
    public void invalidMoney() {
        assertThatThrownBy(() -> {
            Lottos.withMoney(-1);
        }).isInstanceOf(InvalidMoneyException.class)
                .hasMessageContaining("금액은 0보다 커야합니다.");
    }
}