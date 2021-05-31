package step2.model;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1005:1", "4800:4", "7900:7", "50400:50"}, delimiter = ':')
    @DisplayName("입력한 금액 대비 구입할수 있는 개수")
    void getLottoCount(int money, int result) {
        LottoGame lottoGame = new LottoGame(new LottoMoney(money), Lottos.of(Collections.emptyList()));
        assertThat(lottoGame.getLottoRandomCount()).isEqualTo(result);
    }
}