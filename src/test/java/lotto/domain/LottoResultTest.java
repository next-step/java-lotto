package lotto.domain;

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
                        new Lotto(1, 2, 3, 10, 12, 13),
                        new Lotto(1, 2, 3, 4, 12, 13),
                        new Lotto(1, 2, 3, 4, 5, 45)
                )
        );
        winningNumbers = new WinningNumbers(45,1, 2, 3, 4, 5, 6);
    }

    @DisplayName("내가 구매한 로또가 당첨번호의 숫자와 몇 개 일지하는지 확인 가능하다")
    @Test
    void calculateLottoRank(){
        LottoResult calculator = new LottoResult(lottos, winningNumbers);

        assertThat(calculator.findMatchCount(3, false)).isEqualTo(1);
        assertThat(calculator.findMatchCount(5, true)).isEqualTo(1);
    }

    @DisplayName("로또 수익률을 소수부로 계산 가능하다")
    @Test
    void calculateProfitRate(){
        double purchaseAmount = 20000;

        LottoResult calculator = new LottoResult(lottos, winningNumbers);
        double profitRate = calculator.calculateProfitRate(purchaseAmount);

        double winningAmount = 0;
        winningAmount += calculator.findMatchCount(3, false) * LottoRank.FIFTH.getPrize();
        winningAmount += calculator.findMatchCount(4, false) * LottoRank.FOURTH.getPrize();
        winningAmount += calculator.findMatchCount(5, false) * LottoRank.THIRD.getPrize();
        winningAmount += calculator.findMatchCount(5, true) * LottoRank.SECOND.getPrize();
        winningAmount += calculator.findMatchCount(6, false) * LottoRank.FIRST.getPrize();
        assertThat(profitRate).isEqualTo(winningAmount / purchaseAmount);
    }


}
