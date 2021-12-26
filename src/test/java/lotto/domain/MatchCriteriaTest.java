package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchCriteriaTest {
    @BeforeEach
    void beforeEach() {
        Mock.beforeEach();
    }

    @Test
    @DisplayName("calc 호출시 정상적으로 count값이 증가하는지 확인합니다")
    void match() {
        //given
        Count count = new Count(1);
        //when
        MatchCriteria.THREE.match();
        //then
        assertThat(MatchCriteria.THREE.equalsCount(count)).isTrue();
    }

    @Test
    @DisplayName("기준이 하나 일치할때 상금이 일치하는지 확인합니다.")
    void calc() {
        //given
        MatchCriteria three = MatchCriteria.THREE;
        three.match();
        //when
        Amount result = three.calc();
        //then
        assertThat(result.equals(new Amount(5_000))).isTrue();
    }

}