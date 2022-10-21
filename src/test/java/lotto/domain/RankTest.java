package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

    @ParameterizedTest
    @MethodSource("testNumbersWithBonus")
    void setting_rank_map_test(int matchingCount, boolean containBonusNumber, Prize prize) {
        Rank rank = new Rank();
        rank.settingRank(matchingCount, containBonusNumber);
        assertThat(rank.findRank(prize)).isOne();
    }

    static Stream<Arguments> testNumbersWithBonus() {
        return Stream.of(
                arguments(6, true, Prize.RANK_1TH),
                arguments(5, false, Prize.RANK_2TH),
                arguments(5, true, Prize.RANK_2TH_WITH_BONUS),
                arguments(4, false, Prize.RANK_3TH)
        );
    }
}
