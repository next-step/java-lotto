package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingMachineTest {

    @Test
    @DisplayName("일치 기준에 따른 상금의 합계를 구합니다")
    void matchCriteriasAmount() {
        //given
        MatchCriteria.THREE.match();
        MatchCriteria.FOUR.match();
        MatchCriteria.FIVE.match();
        MatchCriteria.SIX.match();

        //when
        MatchingMachine matchingMachine = new MatchingMachine(Mock.mockLotto(), Mock.winningNumbers());

        //then
        assertThat(matchingMachine.matchCriteriasAmount()).isEqualTo(new Amount(2_001_555_000));
    }

    @Test
    @DisplayName("Nothing을 제외한 MatchCriteria 전체를 반환한다.")
    void excludeNothingMatchCriterias() {
        //given
        List<MatchCriteria> givenMatchCriterias = Arrays.asList(MatchCriteria.THREE, MatchCriteria.FOUR, MatchCriteria.FIVE, MatchCriteria.SIX);
        //when
        List<MatchCriteria> expectMatchCriterias = new MatchingMachine(Mock.mockLotto(), Mock.winningNumbers()).matchCriterias();
        //then
        assertThat(expectMatchCriterias).isEqualTo(givenMatchCriterias);
    }
}