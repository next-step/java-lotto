package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.MatchTestUtil;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    @Test
    @DisplayName("5등(3개 일치), 1개 구매에 대한 통계 테스트")
    void addTest() {
        final Match match = new Match();
        match.add(3);

        final Match expected = MatchTestUtil.createTestMatch(3, 1);
        assertThat(match).isEqualTo(expected);
    }

    @Test
    @DisplayName("4등(4개 일치), 2개 구매에 대한 통계 테스트")
    void addTest2() {
        final Match match = new Match();
        match.add(4);
        match.add(4);

        final Match expected = MatchTestUtil.createTestMatch(4, 2);
        System.out.println(expected);
        assertThat(match).isEqualTo(expected);
    }
}