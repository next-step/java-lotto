package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    public static final int WINNING_SIZE = 6;
    private static final int WINNING_LOWER_BOUND = 1;

    private WinningNumbers winning;
    private Set<LottoNumber> winningNumbers = new HashSet<>();
    private LottoNumbers numbers;

    @BeforeEach
    void setUp() {
        for (int i = WINNING_LOWER_BOUND; i <= WINNING_SIZE; i++) {
            winningNumbers.add(new LottoNumber(i));
        }
        numbers = new LottoNumbers(winningNumbers);
        winning = new WinningNumbers(numbers);
    }

    @Test
    void createTest() {
        //then
        assertThat(winning).isEqualTo(new WinningNumbers(numbers));
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
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int i = WINNING_LOWER_BOUND + matchNum; i <= WINNING_SIZE + matchNum; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        return new Lotto(new LottoNumbers(lottoNumbers));
    }
}
