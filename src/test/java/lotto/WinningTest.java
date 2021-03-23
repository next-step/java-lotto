package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.Winning.MAX_MATCH_NUM;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {

    private static final int WINNING_SIZE = 6;

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

}
