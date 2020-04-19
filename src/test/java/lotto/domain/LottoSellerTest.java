package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LottoSellerTest {

    @DisplayName("입력한 돈만큼 로또 구매")
    @ParameterizedTest
    @CsvSource({"1500,1", "2000,2"})
    void buy(int money, int expected) {
        List<Lotto> buy = LottoSeller.buy(money);
        assertThat(buy.size()).isEqualTo(expected);
    }

    @DisplayName("천원 미만으로 로또 구매시 에러")
    @Test
    void buyFail() {
        assertThatCode(() -> LottoSeller.buy(1000)).doesNotThrowAnyException();
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.buy(900));
    }

    @DisplayName("당첨 결과 확인")
    @Test
    void match() {
        List<Lotto> buy = Arrays.asList(
                Lotto.ofComma("1,2,3,4,5,6"),
                Lotto.ofComma("1,2,3,4,5,7"),
                Lotto.ofComma("1,2,3,4,7,8"),
                Lotto.ofComma("1,2,3,4,7,8"),
                Lotto.ofComma("1,2,3,7,8,9"),
                Lotto.ofComma("1,10,3,7,8,9")
        );
        Lotto winningLotto = Lotto.ofComma("1,2,3,4,5,6");

        Map<Match, Integer> match = LottoSeller.match(buy, winningLotto);
        assertThat(match.get(Match.SIX)).isEqualTo(1);
        assertThat(match.get(Match.FIVE)).isEqualTo(1);
        assertThat(match.get(Match.FOUR)).isEqualTo(2);
        assertThat(match.get(Match.THREE)).isEqualTo(1);
        assertThat(match.get(Match.FAIL)).isEqualTo(1);
    }

}