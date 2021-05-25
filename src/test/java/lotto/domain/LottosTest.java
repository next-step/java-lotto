package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @ParameterizedTest
    @CsvSource(value={"14000:14", "0:0", "31500:31"}, delimiterString = ":")
    public void 금액만큼_게임발행(int money, int cnt) {
        Lottos games = new Lottos(new LottoNumberFactoryImpl(),money);
        assertThat(games.size()).isEqualTo(cnt);
    }
}
