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
            .isThrownBy(() -> new BuyingLottos(cashPayment))
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
    @DisplayName("구매금액을 초과하는 수동입력 갯수를 입력할 수 없다.")
    void canBuyingSelfLottoSuccessTest() {
        //Given
        BuyingLottos buyingLottos = new BuyingLottos(1000);
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> buyingLottos.setSelfInputCount(2))
          .withMessage(ErrorMessage.OVER_INPUT_SELF_BUYING_COUNT.message());
    }
    
    @Test
    @DisplayName("사전에 입력했던 수동 로또 갯수와 실제 입력된 로또의 갯수가 다르면 익셉션이 발생한다.")
    void setSelfLottoNumbersTest() {
        //Given
        BuyingLottos buyingLottos = new BuyingLottos(5000);
        buyingLottos.setSelfInputCount(3);
        List<String> selfInputNumbers = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        //Then
        Assertions.assertThatIllegalArgumentException()
          .isThrownBy(() -> buyingLottos.buyLottos(selfInputNumbers))
          .withMessage(ErrorMessage.INCORRECT_SELF_LOTTO_NUMBERS.message());
    }
    
    @Test
    @DisplayName("로또가 정상적으로 구매된다.")
    void test() {
        //Given
        BuyingLottos buyingLottos = new BuyingLottos(5000);
        buyingLottos.setSelfInputCount(1);
        String lottoNumbers = "1,2,3,4,5,6";
        //When
        Lottos lottos = buyingLottos.buyLottos(Collections.singletonList(lottoNumbers));
        //Then
        Assertions.assertThat(lottos.getLottoSize()).isEqualTo(5);
        lottos.hasLottoNumbers(new LottoNumbers(lottoNumbers));
    }
}
