package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class RankTest {
    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,6"}, delimiter = ':')
    @DisplayName("1등 확인(6개 일치) 테스트")
    void first_rank_test(String winningNumbers, String userNumbers) {
        Lotto winningLotto = Lotto.of(winningNumbers);
        Lotto userLotto = Lotto.of(userNumbers);
        Rank rank = Rank.from(userLotto.matchCount(winningLotto));

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,5,7"}, delimiter = ':')
    @DisplayName("2등 확인(5개 일치) 테스트")
    void second_rank_test(String winningNumbers, String userNumbers) {
        Lotto winningLotto = Lotto.of(winningNumbers);
        Lotto userLotto = Lotto.of(userNumbers);
        Rank rank = Rank.from(userLotto.matchCount(winningLotto));

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,4,7,8"}, delimiter = ':')
    @DisplayName("3등 확인(4개 일치) 테스트")
    void third_rank_test(String winningNumbers, String userNumbers) {
        Lotto winningLotto = Lotto.of(winningNumbers);
        Lotto userLotto = Lotto.of(userNumbers);
        Rank rank = Rank.from(userLotto.matchCount(winningLotto));

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,3,7,8,9"}, delimiter = ':')
    @DisplayName("4등 확인(3개 일치) 테스트")
    void fouth_rank_test(String winningNumbers, String userNumbers) {
        Lotto winningLotto = Lotto.of(winningNumbers);
        Lotto userLotto = Lotto.of(userNumbers);
        Rank rank = Rank.from(userLotto.matchCount(winningLotto));

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @ParameterizedTest(name = "winningNumber = {0}, userNumber = {1}")
    @CsvSource(value = {"1,2,3,4,5,6 : 1,2,7,8,9,10"}, delimiter = ':')
    @DisplayName("3개 미만 확인 테스트")
    void null_rank_test(String winningNumbers, String userNumbers) {
        Lotto winningLotto = Lotto.of(winningNumbers);
        Lotto userLotto = Lotto.of(userNumbers);
        Rank rank = Rank.from(userLotto.matchCount(winningLotto));

        assertThat(rank).isEqualTo(null);
    }
}