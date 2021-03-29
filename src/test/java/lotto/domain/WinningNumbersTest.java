package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    public static final int WINNING_SIZE = 6;
    private static final int WINNING_LOWER_BOUND = 1;

    private WinningNumbers winning;
    private List<LottoNumber> winningNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = WINNING_LOWER_BOUND; i <= WINNING_SIZE; i++) {
            winningNumbers.add(new LottoNumber(i));
        }
        winning = new WinningNumbers(winningNumbers);
    }

    @Test
    void createTest() {
        //then - 동일 생성으로 비교
        assertThat(winning).isEqualTo(new WinningNumbers(winningNumbers));

        //when, then - field 접근
        assertThat(winning).hasNoNullFieldsOrProperties()
                .hasFieldOrPropertyWithValue("winningNumbers", winningNumbers);
    }

    @Test
    void matchesTest() {
        //given
        int matchNum = 3;
        Lotto lotto = createLotto(matchNum);

        //when
        Rank rank = winning.matches(lotto);

        //then
        assertThat(rank).isEqualTo(Rank.matchRank(matchNum));
    }

    Lotto createLotto(int matchNum) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = WINNING_LOWER_BOUND + matchNum; i <= WINNING_SIZE + matchNum; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return new Lotto(lottoNumbers);
    }
}
