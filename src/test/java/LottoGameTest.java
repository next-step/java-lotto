import lottogame.domain.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    private final static int WINNER_COUNT = 1;

    private int lottoPrice = 3000;

//    @Test
//    void 로또가격입력_자동로또갯수확인() {
//        LottoGame lottoGame = new LottoGame(lottoPrice, 2);
//        List<LottoNumber> lottoAuto = lottoGame.getAutoLottoNumber();
//        assertThat(lottoAuto.size()).isEqualTo(1);
//    }
//
//    @Test
//    void 로또당첨_보너스볼_당첨자_결과() {
//        List<LottoNumber> lotto = new ArrayList<>();
//        LottoNumber element = new LottoNumber(new int[]{1, 2, 3, 4, 5, 6});
//        lotto.add(element);
//
//        element = new LottoNumber(new int[]{7, 8, 9, 10, 11, 12});
//        lotto.add(element);
//
//        element = new LottoNumber(new int[]{33, 40, 23, 6, 17, 20});
//        lotto.add(element);
//
//        LottoResult lottoResult = new LottoResult();
//        String winningNumber = "1,2,3,4,7,8";
//        int bonus = 5;
//        int lottoPrize = 30000000;
//
//        int lottoRevenue = lottoPrize / lottoPrice;
//
//        lottoResult.getWinningResult(lotto, winningNumber, bonus, lottoPrice);
//
//        assertThat(LottoRankData.BONUS_SECOND_WINNER.getCountWinner()).isEqualTo(WINNER_COUNT);
//        assertThat(lottoResult.getWinningRevenue().judgeResult()).isEqualTo("이익");
//        assertThat(lottoResult.getWinningRevenue().getPercentOfRevenue()).isEqualTo(lottoRevenue);
//    }
//
//    @Test
//    void 로또_구매가격체크() {
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            new LottoGame(0,2);
//        });
//    }
//
//    @Test
//    void 로또_입력번호체크() {
//        String lottonInput = "1, 2, 3";
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            new LottoNumber(LottoUtil.coverStrToArr(lottonInput));
//        });
//    }
}
