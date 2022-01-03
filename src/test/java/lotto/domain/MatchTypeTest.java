package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchTypeTest {

    private static final int COUNT = 5;
    private static final MatchType matchType = MatchType.FIVE;

    @Test
    @DisplayName("매치 카운트에 알맞은 금액을 리턴한다.")
    void find_money_with_count() {
        //given

        //when
        int money = MatchType.getMoneyByCount(COUNT);

        //then
        assertEquals(money, matchType.getMoney());
    }

    @Test
    @DisplayName("매치 카운트에 매치타입을 리턴한다.")
    void find_match_type_with_count() {
        //given

        //when
        MatchType type = MatchType.of(COUNT);

        //then
        assertEquals(type, matchType);
    }

}