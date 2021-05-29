package lotto;

import lotto.domain.entity.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RankTest {

    @ParameterizedTest
    @DisplayName("Rank Enum 열거 목록 확인")
    @EnumSource(Rank.class)
    public void 랭크_열거_목록_확인(Rank rankEnum) {
        assertTrue(EnumSet.of(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH).contains(rankEnum));
    }
}
