package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    
    @BeforeEach
    void setUp() {
        lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 10, 12, 13)),
                        new Lotto(List.of(1, 2, 3, 4, 12, 13)),
                        new Lotto(List.of(1, 2, 3, 4, 13, 14))
                )
        );
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("내가 구매한 로또들이 몇 등의 몇 번 당첨됐는지 확인이 가능하다")
    @Test
    void calculateLottoRank(){
        LottoResult calculator = new LottoResult(lottos, winningNumbers);

        assertThat(calculator.findMatchCount(3)).isEqualTo(1);
        assertThat(calculator.findMatchCount(4)).isEqualTo(2);
    }

    @DisplayName("로또 수익률을 소수부로 계산 가능하다")
    @Test
    void calculateProfitRate(){
        double purchaseAmount = 20000;

        LottoResult calculator = new LottoResult(lottos, winningNumbers);
        double profitRate = calculator.calculateProfitRate(purchaseAmount);

        double winningAmount = 0;
        winningAmount += calculator.findMatchCount(3) * LottoRank.FOURTH.getPrize();
        winningAmount += calculator.findMatchCount(4) * LottoRank.THIRD.getPrize();
        winningAmount += calculator.findMatchCount(5) * LottoRank.SECOND.getPrize();
        winningAmount += calculator.findMatchCount(6) * LottoRank.FIRST.getPrize();
        assertThat(profitRate).isEqualTo(winningAmount / purchaseAmount);
    }
}
