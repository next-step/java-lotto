package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    private static WinningLotto winningLotto;
    private static Lotto userLottoRankFirstPlace, userLottoRankSecondPlace, userLottoRankThirdPlace, userLottoFailurePlace;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6));
        userLottoRankFirstPlace = Lotto.of(1, 2, 3, 4, 5, 6);
        userLottoRankSecondPlace = Lotto.of(1, 2, 3, 4, 25, 6);
        userLottoRankThirdPlace = Lotto.of(1, 2, 3, 4, 25, 36);
        userLottoFailurePlace = Lotto.of(1, 2, 8, 9, 10, 11);
    }

    @ParameterizedTest(name = "당첨결과 : {0}")
    @EnumSource(value = Rank.class, names = {"FIRST_PLACE"})
    @DisplayName("랭킹구하기_1등")
    void match_1등(Rank expectedRank) {
        assertThat(winningLotto.match(userLottoRankFirstPlace)).isEqualTo(expectedRank);
    }

    @ParameterizedTest(name = "당첨결과 : {0}")
    @EnumSource(value = Rank.class, names = {"SECOND_PLACE"})
    @DisplayName("랭킹구하기_2등")
    void match_2등(Rank expectedRank) {
        assertThat(winningLotto.match(userLottoRankSecondPlace)).isEqualTo(expectedRank);
    }

    @ParameterizedTest(name = "당첨결과 : {0}")
    @EnumSource(value = Rank.class, names = {"THIRD_PLACE"})
    @DisplayName("랭킹구하기_3등")
    void match_3등(Rank expectedRank) {
        assertThat(winningLotto.match(userLottoRankThirdPlace)).isEqualTo(expectedRank);
    }

    @ParameterizedTest(name = "당첨결과 : {0}")
    @EnumSource(value = Rank.class, names = {"FAILURE"})
    @DisplayName("랭킹구하기_꽝")
    void match_꽝(Rank expectedRank) {
        assertThat(winningLotto.match(userLottoFailurePlace)).isEqualTo(expectedRank);
    }
}