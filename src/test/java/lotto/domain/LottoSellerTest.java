package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoSellerTest {

    @DisplayName("입력한 돈만큼 로또 구매")
    @ParameterizedTest
    @CsvSource({"1000,1", "1500,1", "2000,2"})
    void buy(int money, int expected) {
        Lottos buy = LottoSeller.buy(new Money(money));
        assertThat(buy.size()).isEqualTo(expected);
    }

    @DisplayName("천원 미만으로 로또 구매시 에러")
    @Test
    void buyFail() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.buy(new Money(999)));
    }

    @DisplayName("당첨 결과 확인")
    @Test
    void match() {
        Lottos buy = Lottos.of(Arrays.asList(
                Lotto.ofComma("1,2,3,4,5,6"),
                Lotto.ofComma("1,2,3,4,5,10"),
                Lotto.ofComma("1,2,3,4,5,8"),
                Lotto.ofComma("1,2,3,4,7,8"),
                Lotto.ofComma("1,2,3,7,8,9"),
                Lotto.ofComma("1,2,10,7,8,9")
        ));

        MatchResult result = LottoSeller.match(buy, WinningLotto.of(Lotto.ofComma("1,2,3,4,5,6"), 10));
        assertAll("당첨 결과 테스트",
                () -> assertEquals(1, result.getRankCount(Rank.FIRST)),
                () -> assertEquals(1, result.getRankCount(Rank.SECOND)),
                () -> assertEquals(1, result.getRankCount(Rank.THIRD)),
                () -> assertEquals(1, result.getRankCount(Rank.FOURTH)),
                () -> assertEquals(1, result.getRankCount(Rank.FIFTH)),
                () -> assertEquals(1, result.getRankCount(Rank.FAIL))
        );
    }

}
