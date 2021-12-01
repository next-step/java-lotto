package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("로또 생성 테스트")
    @Test
    void createLotto() {
        Lotto actual = Lotto.from("2, 9, 13, 33 ,39, 45");

        assertThat(actual).isNotNull();
    }

    @DisplayName("로또 생성 테스트 - 로또는 6자리의 숫자만 가능하다")
    @Test
    void createLottoDuplicate() {
        assertThatThrownBy(() -> Lotto.from("2, 2, 13, 33 ,39, 45"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 동등성 테스트")
    @Test
    void equalLotto() {
        String lottoText = "2, 9, 13, 33 ,39, 45";
        Lotto buyLotto = Lotto.from(lottoText);
        Lotto winLotto = Lotto.from(lottoText);

        assertThat(buyLotto).isEqualTo(winLotto);
    }

    @DisplayName("로또의 당첨 등수 체크 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2, 9, 13, 33 ,39, 45:34, 40, 13, 2 ,9, 44"}, delimiter = ':')
    void lottoRankCheck(String buyLottoString, String winLottoString) {
        Lotto buyLotto = Lotto.from(buyLottoString);
        Lotto winLotto = Lotto.from(winLottoString);

        Rank rank = buyLotto.getRank(winLotto);

        assertThat(rank.getMatchCount()).isEqualTo(Rank.FIFTH.getMatchCount());
        assertThat(rank.getPrizeMoney()).isEqualTo(Rank.FIFTH.getPrizeMoney());
    }
}
