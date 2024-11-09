import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBoardTest {

    private final LottoBoard lottoBoard = new LottoBoard();

    @Test
    void calculate_benefit_when_buy_three_lottos(){
        Lotto lotto_1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 13, 14))); // match count : 4
        Lotto lotto_2 = new Lotto(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 20, 30))); // match count : 0
        Lotto lotto_3 = new Lotto(new ArrayList<>(Arrays.asList(20, 35, 40, 41, 42, 43))); // match count : 1
        Lotto winning = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 13, 14, 35, 36)));

        lottoBoard.registerWinning(winning);
        lottoBoard.addCandidates(lotto_1);
        lottoBoard.addCandidates(lotto_2);
        lottoBoard.addCandidates(lotto_3);

        double benefit = (double) 50000 / 3000;
        benefit = Math.round(benefit * 100) / 100.0;

        assertThat(lottoBoard.calculateBenefit()).isEqualTo(benefit);
    }
}
