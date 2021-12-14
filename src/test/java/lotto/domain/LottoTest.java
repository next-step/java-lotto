package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("Lotto 객체가 보유한 NumberGroup와 당첨 번호의 일치 개수에 따라 MatchCriteria의 값이 정상적으로 증가하였는지 확인합니다.")
    void match() {
        //given
        NumberGroup winningNumbers = Mock.numberGroups(3, 5, 11, 16, 32, 38);
        Lotto lotto = Mock.mockLotto();
        //when
        lotto.match(winningNumbers);
        //then
        assertThat(MatchCriteria.THREE.equalsCount(1)).isTrue();
        assertThat(MatchCriteria.FOUR.equalsCount(1)).isTrue();
        assertThat(MatchCriteria.FIVE.equalsCount(2)).isTrue();
        assertThat(MatchCriteria.SIX.equalsCount(1)).isTrue();
    }

}