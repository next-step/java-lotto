package step3.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.rank.Rank;
import step3.exception.MapNullPointerException;

import java.util.EnumMap;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {

    @DisplayName("WinningResult 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Map<Rank, Integer> rankIntegerMap = new EnumMap<>(Rank.class);

        // when
        WinningResult winningResult = WinningResult.of(rankIntegerMap);

        // then
        assertThat(winningResult).isNotNull();
    }

    @DisplayName("WinningResult 인스턴스 Null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_Null() {
        // given
        Map<Rank, Integer> rankIntegerMap = null;

        // when
        assertThatThrownBy(()->WinningResult.of(rankIntegerMap))
                .isInstanceOf(MapNullPointerException.class)
                .hasMessageContaining("Map 인스턴스가 Null 입니다.");
    }

    @DisplayName("WinningResult 인스턴스가 초기 셋팅값 반환 여부 테스트")
    @Test
    void 반환_초기값() {

        // when
        Map<Rank, Integer> actual = WinningResult.values();

        // then
        assertAll(
                ()-> assertThat(actual.get(Rank.MISS)).isEqualTo(0),
                ()-> assertThat(actual.get(Rank.FIFTH)).isEqualTo(0),
                ()-> assertThat(actual.get(Rank.FOURTH)).isEqualTo(0),
                ()-> assertThat(actual.get(Rank.THIRD)).isEqualTo(0),
                ()-> assertThat(actual.get(Rank.SECOND)).isEqualTo(0),
                ()-> assertThat(actual.get(Rank.FIRST)).isEqualTo(0)

        );

    }
}