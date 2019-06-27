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
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
            .isThrownBy(() -> new BuyingLottos.Builder().setCashPayments(cashPayment))
            .withMessage(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
    }
    
    @Test
    @DisplayName("당첨 정보를 구한다.")
    void getWinPrizeTest() {
        //Given
        WanLottoNumbers wanLottoNumbers = new WanLottoNumbers("1,2,3,4,5,6", 10);
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(new LottoNumbers(getNewLottoNumbers(1, 2, 3, 7, 8, 9)));
        lottoNumbersList.add(new LottoNumbers(getNewLottoNumbers(1, 2, 3, 4, 8, 9)));
        BuyingLottos buyingLottos = new BuyingLottos.Builder()
          .setCashPayments(5000)
          .setSelfInputCount(2)
          .buyLottos(Arrays.asList("1,2,3,7,8,9", "1,2,3,4,8,9"))
          .build();
        
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
    @DisplayName("구매금액을 초과하는 수동입력 갯수를 입력할 수 없다.")
    void canBuyingSelfLottoSuccessTest() {
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new BuyingLottos.Builder()
            .setCashPayments(1000)
            .setSelfInputCount(2)
            .build())
          .withMessage(ErrorMessage.OVER_INPUT_SELF_BUYING_COUNT.message());
    }
    
    @Test
    @DisplayName("사전에 입력했던 수동 로또 갯수와 실제 입력된 로또의 갯수가 다르면 익셉션이 발생한다.")
    void setSelfLottoNumbersTest() {
        //Given
        List<String> selfInputNumbers = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> new BuyingLottos.Builder()
            .setCashPayments(5000)
            .setSelfInputCount(3)
            .buyLottos(selfInputNumbers)
            .build())
          .withMessage(ErrorMessage.INCORRECT_SELF_LOTTO_NUMBERS.message());
    }
    
    @Test
    @DisplayName("로또가 정상적으로 구매된다.")
    void test() {
        //Given
        String lottoNumbers = "1,2,3,4,5,6";
        BuyingLottos buyingLottos = new BuyingLottos.Builder()
          .setCashPayments(5000)
          .setSelfInputCount(1)
          .buyLottos(Collections.singletonList(lottoNumbers))
          .build();
        
        //Then
        Assertions.assertThat(buyingLottos.hasLottoNumbers(lottoNumbers)).isTrue();
        Assertions.assertThat(buyingLottos.isEqualsLottoSize(5)).isTrue();
    }
}
