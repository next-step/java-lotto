package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;
import static lotto.Price.*;
import static lotto.Winning.MAX_MATCH_NUM;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    public static final int WINNING_SIZE = 6;

    private Winning winning;
    private List<Integer> winningNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= WINNING_SIZE; i++) {
            winningNumbers.add(i);
        }
        winning = new Winning(winningNumbers);
    }

    @Test
    void createTest() throws NoSuchFieldException, IllegalAccessException {
        //then - 동일 생성으로 비교
        assertThat(winning).isEqualTo(new Winning(winningNumbers));

        //when, then - field 접근
        assertThat(winning).hasNoNullFieldsOrProperties()
                .hasFieldOrPropertyWithValue("winningNumbers", winningNumbers);
    }

    @Test
    void matchesTest() {
        //given
        int[] matchArr = new int[MAX_MATCH_NUM + 1];
        int matchNum = 3;
        matchArr[matchNum]++;
        Winning testWinning = new Winning(winningNumbers, matchArr);

        //when
        winning.matches(3);

        //then
        assertThat(winning).isEqualTo(testWinning);
    }

    @Test
    void yieldTest() {
        //given
        Long buyMoney = 14000L;
        int[] match = new int[]{0, 1, 2, 3, 4, 5, 6};
        Long expectMatch = 0 * 0 + 1 * 0 + 2 * 0 + 3 * THREE_MATCH_PRICE + 4 * FOUR_MATCH_PRICE + 5 * FIVE_MATCH_PRICE + 6 * SIX_MATCH_PRICE;
        double expect =  round(expectMatch / buyMoney * 100) / 100.0;
        Winning winning = new Winning(winningNumbers, match);

        //when
        double result = winning.yield(buyMoney);

        //then
        assertThat(result).isEqualTo(expect);
    }

}
