package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankCalculatorTest {
    
    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    
    @BeforeEach
    void setUp() {
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 10, 12, 13))
                , new Lotto(List.of(1, 2, 3, 4, 12, 13))
                , new Lotto(List.of(1, 2, 3, 4, 13, 14))
                , new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        winningNumbers = List.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("내가 구매한 로또들이 몇 등의 몇 번 당첨됐는지 확인이 가능하다")
    @Test
    void calculateLottoRank(){
        LottoRankCalculator calculator = new LottoRankCalculator(lottos, winningNumbers);

        assertThat(calculator.findMatchCount(3)).isEqualTo(1);
        assertThat(calculator.findMatchCount(4)).isEqualTo(2);
        assertThat(calculator.findMatchCount(6)).isEqualTo(1);
    }

}
