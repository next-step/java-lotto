package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinLottoTest {

    @DisplayName("당첨 로또번호 생성 테스트")
    @Test
    void createWinLotto() {
        Lotto winLotto = Lotto.from("2, 9, 13, 33 ,39, 44");
        LottoNumber bonusNumber = new LottoNumber("45");
        WinLotto actual = new WinLotto(winLotto, bonusNumber);

        assertThat(actual).isNotNull();
    }

    @DisplayName("보너스 번호는 당첨번호와 중복될 수 없다.")
    @Test
    void bonusLottoNumberContainNotWinLotto() {
        Lotto winLotto = Lotto.from("2, 9, 13, 33 ,39, 44");
        LottoNumber bonusNumber = new LottoNumber("2");

        assertThatThrownBy(() -> new WinLotto(winLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 종복될 수 없습니다.");
    }


    @DisplayName("로또의 당첨 등수 체크 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2, 9, 13, 33 ,39, 45:34, 40, 13, 2 ,9, 44:1"}, delimiter = ':')
    void lottoRankCheck(String buyLottoString, String winLottoString, String bonusString) {
        Lotto buyLotto = Lotto.from(buyLottoString);
        Lotto winLotto = Lotto.from(winLottoString);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusString);
        WinLotto lastWeekWinLotto = new WinLotto(winLotto, bonusLottoNumber);

        Rank rank = lastWeekWinLotto.getRank(buyLotto);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2등 당첨 테스트")
    @Test
    void secondRankLotto() {
        Lotto buyLotto = Lotto.from("2, 9, 13, 33 ,39, 45");
        Lotto winLotto = Lotto.from("2, 9, 13, 33 ,39, 44");
        LottoNumber bonusLottoNumber = new LottoNumber("45");
        WinLotto lastWeekWinLotto = new WinLotto(winLotto, bonusLottoNumber);

        Rank rank = lastWeekWinLotto.getRank(buyLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
