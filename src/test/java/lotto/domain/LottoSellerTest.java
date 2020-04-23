package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoSellerTest {

    @DisplayName("입력한 돈만큼 로또 구매")
    @ParameterizedTest
    @CsvSource({"1000,1", "1500,1", "2000,2"})
    void buy(int money, int expected) {
        Lottos buy = LottoSeller.buy(money);
        assertThat(buy.size()).isEqualTo(expected);
    }

    @DisplayName("천원 미만으로 로또 구매시 에러")
    @Test
    void buyFail() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.buy(999));
    }

    @DisplayName("당첨 결과 확인")
    @Test
    void match() {
        Lottos buy = Lottos.of(Arrays.asList(
                Lotto.ofComma("1,2,3,4,5,6"),
                Lotto.ofComma("1,2,3,4,5,7"),
                Lotto.ofComma("1,2,3,4,7,8"),
                Lotto.ofComma("1,2,3,4,7,8"),
                Lotto.ofComma("1,2,3,7,8,9"),
                Lotto.ofComma("1,10,3,7,8,9")
        ));
        Lotto winningLotto = Lotto.ofComma("1,2,3,4,5,6");

        MatchResult match = LottoSeller.match(buy, winningLotto);
        assertAll("당첨 결과 테스트",
                () -> assertEquals(1, match.getMatchCount(Match.SIX)),
                () -> assertEquals(1, match.getMatchCount(Match.FIVE)),
                () -> assertEquals(2, match.getMatchCount(Match.FOUR)),
                () -> assertEquals(1, match.getMatchCount(Match.THREE)),
                () -> assertEquals(1, match.getMatchCount(Match.FAIL))
        );
    }

}
