package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGamesTest {

    static final int DEFAULT_LOTTO_PRICE =1000;

    LottoGames lottoGames = new LottoGames();

    @DisplayName("전달받은 금액으로 구매가능한 게임 개수를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {3000, 4000, 15000, 34000})
    public void 구매가능_게임_개수(int money) throws Exception {
        assertThat(lottoGames.howManyBuyGames(money)).isEqualTo(money/DEFAULT_LOTTO_PRICE);
    }

    @DisplayName("개수만큼 로또 게임을 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {12, 100, 30, 17})
    public void n개의_게임_생성(int gameCount) throws Exception {
        assertThat(lottoGames.buyLottoGame(gameCount)).size()
                                .isEqualTo(gameCount);
    }

}
