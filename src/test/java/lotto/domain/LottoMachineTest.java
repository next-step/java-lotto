package lotto.domain;

import lotto.util.NumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setup(){
        lottoMachine = new LottoMachine();
    }

    @Test
    void exchangeNumberOfLotto(){
        lottoMachine.inputMoney("14000");
        LottoBucket lottoBucket = lottoMachine.buyAutoLotto();
        assertThat(lottoBucket.getLottos()).hasSize(14);
    }

    @Test
    void createLottos(){
        LottoBucket lottos = lottoMachine.createLottos(14);
        assertThat(lottos.getLottos().size()).isEqualTo(14);
    }

    @Test
    void getLottoBucket(){
        LottoBucket lottos = lottoMachine.createLottos(4);
        LottoBucket lottoBuckets = lottoMachine.getLottoBuckets();
        List<Lotto> createdLottos = lottoBuckets.getLottos();
        assertThat(createdLottos.size()).isEqualTo(lottos.getLottos().size());
    }


    @ParameterizedTest
    @CsvSource(value={"10000,10000","4000,4000"})
    void inputMoney(String inputMoney, String result){
        long resultMoney = NumberUtil.stringToLong(result);
        BigDecimal money =  lottoMachine.inputMoney(inputMoney);

       assertThat(money).isEqualTo(BigDecimal.valueOf(resultMoney));
    }

    @Test
    void ManualLottoBucket(){
        lottoMachine.inputMoney("1000");
        String lottoNumbers = "1,2,3,4,5,6";
        Set<LottoNumber> lottoNumberSet = NumberUtil.convertStringLottoNumbers(lottoNumbers);

        Lotto lotto = lottoMachine.buyManualLotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumberSet));
    }

    @Test
    void ManualLottoBucket_InsufficientCash(){
//        lottoMachine.inputMoney("1000");
        String lottoNumbers = "1,2,3,4,5,6";
        assertThatThrownBy(()->{
            Lotto lotto = lottoMachine.buyManualLotto(lottoNumbers);
        }).isInstanceOf(ArithmeticException.class).hasMessageContaining("구매할 잔액이 부족합니다.");
    }

    @Test
    void AutoLottoBucket(){
//        lottoMachine.
    }

}