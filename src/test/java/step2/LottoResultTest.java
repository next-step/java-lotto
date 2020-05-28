package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 당첨 결과 클래스 테스트")
class LottoResultTest {

    @Test
    @DisplayName("로또 당첨 번호가 몇개인지 테스트")
    void countLottoNumberWinning() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        int sameNumberCount = 3;
        LotteryNumbers lotteryNumbers = new LotteryNumbers();
        lotteryNumbers.addLottoNumber(1);
        lotteryNumbers.addLottoNumber(2);
        lotteryNumbers.addLottoNumber(3);
        lotteryNumbers.addLottoNumber(9);
        lotteryNumbers.addLottoNumber(30);
        lotteryNumbers.addLottoNumber(33);

        LottoResult result = new LottoResult(winningNumbers);
        int winningCount = result.getCountLottoNumberWinning(lotteryNumbers.getLottoNumberList());

        assertThat(sameNumberCount).isEqualTo(winningCount);
    }
}