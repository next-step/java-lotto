package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
    @BeforeEach
    void beforeEach() {
        Mock.beforeEach();
    }

    @Test
    @DisplayName("Lotto 객체가 보유한 NumberGroup와 당첨 번호의 일치 개수에 따라 MatchCriteria의 값이 정상적으로 증가하였는지 확인합니다.")
    void match() {
        //given
        NumberGroup winningNumbers = Mock.numberGroups(3, 5, 11, 16, 32, 38);
        Lotto lotto = Mock.mockLotto();
        //when
        lotto.match(winningNumbers);
        //then
        assertAll(
                () -> assertTrue(MatchCriteria.THREE.equalsCount(new Count(1))),
                () -> assertTrue(MatchCriteria.FOUR.equalsCount(new Count(1))),
                () -> assertTrue(MatchCriteria.FIVE.equalsCount(new Count(2))),
                () -> assertTrue(MatchCriteria.SIX.equalsCount(new Count(1)))
        );
    }

}