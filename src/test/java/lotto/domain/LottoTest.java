package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void createLotto() {
        Lotto actual = Lotto.from("2, 9, 13, 33 ,39, 45");

        assertThat(actual).isNotNull();
    }

    @DisplayName("로또번호 출력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2, 9, 13, 33 ,39, 45:2, 9, 13, 33 ,39, 45"}, delimiter = ':')
    void lottoNumberShow(String buyLottoString, String winLottoString) {
        Lotto buyLotto = Lotto.from(buyLottoString);
        Lotto winLotto = Lotto.from(winLottoString);

        assertThat(buyLotto.showLottoNumber()).isEqualTo(winLotto.showLottoNumber());
    }

    @DisplayName("로또번호 번호 체크 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2, 9, 13, 33 ,39, 45:34, 40, 13, 2 ,9, 44:3"}, delimiter = ':')
    void lottoNumberCheck(String buyLottoString, String winLottoString, int matchCount) {
        Lotto buyLotto = Lotto.from(buyLottoString);
        Lotto winLotto = Lotto.from(winLottoString);

        assertThat(buyLotto.sameLottoNumberCount(winLotto)).isEqualTo(matchCount);
    }

    @DisplayName("로또의 당첨 등수 체크 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2, 9, 13, 33 ,39, 45:34, 40, 13, 2 ,9, 44:3"}, delimiter = ':')
    void lottoRankCheck(String buyLottoString, String winLottoString, int matchCount) {
        Lotto buyLotto = Lotto.from(buyLottoString);
        Lotto winLotto = Lotto.from(winLottoString);

        Rank rank = buyLotto.getRank(winLotto);

        assertThat(rank.getMatchCount()).isEqualTo(3);
        assertThat(rank.getPrizeMoney()).isEqualTo(5000);
    }
}
