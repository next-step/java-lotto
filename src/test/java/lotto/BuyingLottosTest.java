package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.BuyingLottos;
import lotto.domain.CashPayments;
import lotto.domain.EarningsRate;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.OwnPrize;
import lotto.domain.WanLottoNumbers;
import lotto.view.data.LottoBuyingInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BuyingLottosTest {
    @Test
    @DisplayName("금액이 1,000원 미만이면 구매할 수 없다.")
    void buyUnderMinimumPriceTest() {
        //Given
        int cashPayment = 999;
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> new BuyingLottos(cashPayment))
            .withMessage(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
    }
    
    @Test
    @DisplayName("당첨 정보를 구한다.")
    void getWinPrizeTest() {
        //Given
        WanLottoNumbers wanLottoNumbers = new WanLottoNumbers("1,2,3,4,5,6");
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(new LottoNumbers(getNewLottoNumbers(1, 2, 3, 7, 8, 9)));
        lottoNumbersList.add(new LottoNumbers(getNewLottoNumbers(1, 2, 3, 4, 8, 9)));
        BuyingLottos buyingLottos = new BuyingLottos(new Lottos(lottoNumbersList), new CashPayments(5000));
        //When
        OwnPrize ownPrize = buyingLottos.getOwnPrize(wanLottoNumbers);
        //Then
        Assertions.assertThat(ownPrize.isEqualsEarningRate(new EarningsRate(11.0))).isTrue();
    }
    
    private static List<LottoNumber> getNewLottoNumbers(int... lottoNumbers) {
        return IntStream.of(lottoNumbers)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    }
    
    @Test
    @DisplayName("입력한 금액만큼 수동구매가 가능하다.")
    void canBuyingSelfLottoSuccessTest() {
        //Given
        LottoBuyingInfo lottoBuyingInfo = new LottoBuyingInfo(5000, 5);
        //When
        boolean canBuyingSelfLotto = BuyingLottos.canBuyingSelfLotto(lottoBuyingInfo.getCashPayment(), lottoBuyingInfo.getSelfCount());
        //Then
        Assertions.assertThat(canBuyingSelfLotto).isTrue();
    }
}
