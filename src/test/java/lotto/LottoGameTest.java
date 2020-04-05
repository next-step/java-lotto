package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14"}, delimiter = ':')
    @DisplayName("주어진 금액 만큼의 로또를 발행 여부 테스트")
    public void issueLottoTest(int input, int expect) {
        Lottos lottos = LottoGame.issueLotto(input);

        assertThat(lottos.size()).isEqualTo(expect);
    }

}
