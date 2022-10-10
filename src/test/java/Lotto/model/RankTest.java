package Lotto.model;

import calculator.model.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RankTest {

    private static final int LOTTO_NUMBER_ONE = 1;
    private static final int LOTTO_NUMBER_TWO = 2;
    private static final int LOTTO_NUMBER_THREE = 3;
    private static final int LOTTO_NUMBER_FOUR = 4;
    private static final int LOTTO_NUMBER_FIVE = 5;
    private static final int LOTTO_NUMBER_SIX = 6;
    private static final int LOTTO_NUMBER_SEVEN = 7;
    private static final int FIRST_MATCH_COUNT = 6;
    private static final int SECOND_MATCH_COUNT = 5;
    private static final int THIRD_MATCH_COUNT = 5;
    private static final int FOURTH_MATCH_COUNT = 4;
    private static final int FIFTH_MATCH_COUNT = 3;
    private static final int NOT_RANK_MATCH_COUNT = 7;
    private static final boolean SECOND_ABLE_TRUE = true;
    private static final boolean SECOND_ABLE_FALSE = false;


    @Test
    @DisplayName("랭킹 대한 정상적인 값 처리")
    public void constructorSuccessTest() {
        assertThat(Rank.getRank(FIRST_MATCH_COUNT, SECOND_ABLE_FALSE)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(SECOND_MATCH_COUNT, SECOND_ABLE_TRUE)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(THIRD_MATCH_COUNT, SECOND_ABLE_FALSE)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(FOURTH_MATCH_COUNT, SECOND_ABLE_FALSE)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(FIFTH_MATCH_COUNT, SECOND_ABLE_FALSE)).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @EnumSource(value = Rank.class, names = {"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH"})
    @DisplayName("정상적으로 이름들이 있는지 확인")
    void constructorEnumTest(Rank rank) {
        assertThat(EnumSet.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH)).contains(rank);
    }

    @Test
    @DisplayName("랭킹이 아닌 값에 대한 에러처리")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> Rank.getRank(NOT_RANK_MATCH_COUNT, SECOND_ABLE_FALSE)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2등 처리에 대하여 정상적으로 작동되는지에 대한 테스트")
    public void RankSecondTest() {
        final Lotto lotto = new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO),
                        new LottoNumber(LOTTO_NUMBER_THREE),
                        new LottoNumber(LOTTO_NUMBER_FOUR),
                        new LottoNumber(LOTTO_NUMBER_FIVE),
                        new LottoNumber(LOTTO_NUMBER_SIX)
                )
        );
        final Lotto luckyNumberSixCount = new Lotto(
                List.of(
                        new LottoNumber(LOTTO_NUMBER_ONE),
                        new LottoNumber(LOTTO_NUMBER_TWO),
                        new LottoNumber(LOTTO_NUMBER_THREE),
                        new LottoNumber(LOTTO_NUMBER_FOUR),
                        new LottoNumber(LOTTO_NUMBER_FIVE),
                        new LottoNumber(LOTTO_NUMBER_SEVEN)
                )
        );
        final LottoNumber bonusNumber = new LottoNumber(LOTTO_NUMBER_SIX);
        final LuckyNumber luckyNumber = new LuckyNumber(luckyNumberSixCount, bonusNumber);
        final int matchCount = luckyNumber.countMatchNumbers(lotto);
        boolean secondAble = luckyNumber.isSecondAble(lotto, matchCount);
        assertThat(Rank.getRank(matchCount, secondAble)).isEqualTo(Rank.SECOND);
    }

}