package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 추첨기 클래스 테스트")
class LottoNumberLotteryTest {

    @Test
    @DisplayName("갯수를 입력하면 로또리스트가 나오는 테스트")
    void getLottoNumbersListTest() {
        int wannaBuyLottoCount = 3;
        LottoNumberLottery lottery = new LottoNumberLottery();
        List<LotteryNumbers> lotteryNumbersList = lottery.getLottoNumbersList(3);

        assertThat(lotteryNumbersList).hasSize(wannaBuyLottoCount);
    }

    @Test
    @DisplayName("로또 숫자의 정렬되었는지 테스트")
    void checkSortedlottoNumbersTest() {

        LottoNumberLottery lottery = new LottoNumberLottery();
        List<LotteryNumbers> lotteryNumbersList = lottery.getLottoNumbersList(1);

        List<Integer> lotteryNumberList = lotteryNumbersList.get(0).getLottoNumberList();
        int comparedNumber = 0;
        for (Integer lottoNumber : lotteryNumberList) {
            assertThat(comparedNumber).isLessThan(lottoNumber);
            comparedNumber = lottoNumber;
        }
    }
}