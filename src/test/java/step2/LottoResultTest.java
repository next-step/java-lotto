package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 당첨 결과 클래스 테스트")
class LottoResultTest {

    @Test
    @DisplayName("맞춘 번호가 3개인 로또결과가 1개인지 확인하는 테스트")
    void countLottoNumberWinning() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        int sameNumberCount = 3;

        List<LotteryNumbers> lotteryNumbersList = new ArrayList<>();
        LotteryNumbers lotteryNumbers = new LotteryNumbers();
        lotteryNumbers.addLottoNumber(1);
        lotteryNumbers.addLottoNumber(2);
        lotteryNumbers.addLottoNumber(3);
        lotteryNumbers.addLottoNumber(9);
        lotteryNumbers.addLottoNumber(30);
        lotteryNumbers.addLottoNumber(33);
        LotteryNumbers lotteryNumbers2 = new LotteryNumbers();
        lotteryNumbers.addLottoNumber(10);
        lotteryNumbers.addLottoNumber(12);
        lotteryNumbers.addLottoNumber(13);
        lotteryNumbers.addLottoNumber(19);
        lotteryNumbers.addLottoNumber(30);
        lotteryNumbers.addLottoNumber(33);

        lotteryNumbersList.add(lotteryNumbers);
        lotteryNumbersList.add(lotteryNumbers2);

        LottoResult result = new LottoResult(lotteryNumbersList, winningNumbers);
        Map<Integer, Integer> statistics = result.getStatistics().getStatisticsMap();

        assertThat(statistics.get(sameNumberCount)).isEqualTo(1);
    }
}