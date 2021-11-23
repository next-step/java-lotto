package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class RankTest {

    @Test
    @DisplayName("일치하는 갯수의 랭크를 반환")
    void create() {
        Rank forth = Rank.of(3);
        assertThat(forth).isEqualTo(Rank.FORTH);
    }
}