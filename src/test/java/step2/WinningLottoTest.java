package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("지난 주 당첨번호 생성 테스트")
    void create_last_winning_lotto(){
        String input = "1,2,3,4,5,6";
        WinningLotto winningLotto = new WinningLotto(input);
        assertThat(winningLotto.getLottoNumberList().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("지난주 당첨번호와 로또 리스트와 비교하여 맞는 개수 리턴 테스트")
    void lotto_compare(){
        String winningNumbers = "1,2,3,4,5,6";
        String purchasedNumbers = "1,3,5,7,9,11";
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        Lotto purchasedLotto = new Lotto(purchasedNumbers);
        assertThat(winningLotto.getLottoNumberList().stream()
                .filter(winningNumber->purchasedLotto.getLottoNumberList().contains(winningNumber))
                .count()).isGreaterThan(2);
    }

    @Test
    @DisplayName("지난주 당첨 번호와 몇 개 일치하는지 테스트")
    void statistic_test_number(){
        String winningNumbers = "1,2,3,4,5,6";
        String purchasedNumbers = "1,2,3,4,9,11";
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        Lotto purchasedLotto = new Lotto(purchasedNumbers);
        assertThat(LottoPrize.getPrizeInfoByHitCount(purchasedLotto.isWinningLottoList(winningLotto))).
                isEqualTo(LottoPrize.FOURTH);
    }

    @Test
    @DisplayName("지난주 당첨 번호와 몇 개 일치했는지 통계 생성 테스트")
    void statistic_test(){
        String winningNumbers = "1,2,3,4,5,6";

        String purchasedNumbers = "1,2,3,43,44,45";
        String purchasedNumbers2 = "1,2,42,43,44,45";

        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        Lotto purchasedLotto = new Lotto(purchasedNumbers);
        Lotto purchasedLotto2 = new Lotto(purchasedNumbers2);
        LottoStatistic lottoStatistic = new LottoStatistic(purchasedLotto.isWinningLottoList(winningLotto));
        LottoStatistic lottoStatistic2 = new LottoStatistic(purchasedLotto2.isWinningLottoList(winningLotto));

        Rank rank = new Rank();
        Map<LottoPrize,Integer> result = rank.rank(Arrays.asList(lottoStatistic,lottoStatistic2));

        assertThat(result.get(lottoStatistic.lottoPrize())).isEqualTo(1);
    }
}
