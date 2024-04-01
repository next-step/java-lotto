package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class RankTest {
    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonus = {2}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,6 : false"}, delimiter = ':')
    @DisplayName("1등 확인(6개 일치) 테스트")
    void first_rank_test(String winningNumbers, String userNumbers, boolean isBonus) {
        Lotto winningLotto = Lotto.createFromString(winningNumbers);
        Lotto userLotto = Lotto.createFromString(userNumbers);
        Rank rank = Rank.of(userLotto.matchCount(winningLotto), isBonus);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonus = {2}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,7 : true"}, delimiter = ':')
    @DisplayName("2등 확인(5개 일치) 테스트")
    void second_rank_test(String winningNumbers, String userNumbers, boolean isBonus) {
        Lotto winningLotto = Lotto.createFromString(winningNumbers);
        Lotto userLotto = Lotto.createFromString(userNumbers);
        Rank rank = Rank.of(userLotto.matchCount(winningLotto), isBonus);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonus = {2}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,7 : false"}, delimiter = ':')
    @DisplayName("3등 확인(5개 일치) 테스트")
    void third_rank_test(String winningNumbers, String userNumbers, boolean isBonus) {
        Lotto winningLotto = Lotto.createFromString(winningNumbers);
        Lotto userLotto = Lotto.createFromString(userNumbers);
        Rank rank = Rank.of(userLotto.matchCount(winningLotto), false);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonus = {2}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,8,9 : false"}, delimiter = ':')
    @DisplayName("4등 확인(4개 일치) 테스트")
    void fouth_rank_test(String winningNumbers, String userNumbers, boolean isBonus) {
        Lotto winningLotto = Lotto.createFromString(winningNumbers);
        Lotto userLotto = Lotto.createFromString(userNumbers);
        Rank rank = Rank.of(userLotto.matchCount(winningLotto), isBonus);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonus = {2}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,7,8,9 : false"}, delimiter = ':')
    @DisplayName("5등 확인(3개 일치) 테스트")
    void fifth_rank_test(String winningNumbers, String userNumbers, boolean isBonus) {
        Lotto winningLotto = Lotto.createFromString(winningNumbers);
        Lotto userLotto = Lotto.createFromString(userNumbers);
        Rank rank = Rank.of(userLotto.matchCount(winningLotto), isBonus);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}, bonus = {2}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,7,8,9,10 : false"}, delimiter = ':')
    @DisplayName("3개 미만 확인 테스트")
    void null_rank_test(String winningNumbers, String userNumbers, boolean isBonus) {
        Lotto winningLotto = Lotto.createFromString(winningNumbers);
        Lotto userLotto = Lotto.createFromString(userNumbers);
        Rank rank = Rank.of(userLotto.matchCount(winningLotto), isBonus);

        assertThat(rank).isEqualTo(Rank.MISS);
    }
}
