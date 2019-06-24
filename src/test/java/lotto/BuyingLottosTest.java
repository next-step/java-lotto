package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.BuyingLottos;
import lotto.domain.CashPayments;
import lotto.domain.EarningsRate;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.OwnPrize;
import lotto.domain.WinLottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class BuyingLottosTest {
    private BuyingLottos buyingLottos;
    
    @BeforeEach
    void setUp() {
        buyingLottos = new BuyingLottos();
    }
    
    @Test
    @DisplayName("금액이 1,000원 미만이면 구매할 수 없다.")
    void buyUnderMinimumPriceTest() {
        //Given
        int cashPayment = 999;
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> buyingLottos.buyLottos(cashPayment))
            .withMessage(ErrorMessage.NOT_ENOUGH_CASH_PAYMENT.message());
    }
    
    @Test
    @DisplayName("입력한 금액과 맞는 매수의 로또를 구매한다.")
    void boughtLottosCountTest() {
        //Given
        int cashPayment = 5000;
        //When
        Lottos lottos = buyingLottos.buyLottos(cashPayment);
        //Then
        Assertions.assertThat(lottos.getLottoSize()).isEqualTo(5);
    }
    
    @Test
    @DisplayName("당첨 정보를 구한다.")
    void getWinPrizeTest() {
        //Given
        WinLottoNumbers winLottoNumbers = new WinLottoNumbers("1,2,3,4,5,6");
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(new LottoNumbers(getNewLottoNumbers(1, 2, 3, 7, 8, 9)));
        lottoNumbersList.add(new LottoNumbers(getNewLottoNumbers(1, 2, 3, 4, 8, 9)));
        BuyingLottos buyingLottos = new BuyingLottos(new Lottos(lottoNumbersList), new CashPayments(5000));
        //When
        OwnPrize ownPrize = buyingLottos.getOwnPrize(winLottoNumbers);
        //Then
        Assertions.assertThat(ownPrize.isEqualsEarningRate(new EarningsRate(11.0))).isTrue();
    }
    
    private static List<LottoNumber> getNewLottoNumbers(int... lottoNumbers) {
        return IntStream.of(lottoNumbers)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
