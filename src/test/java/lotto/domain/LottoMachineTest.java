package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {


    @DisplayName("로또는 구매 금액/로또 금액의 몫만큼 자동 번호 생성 구매 가능하다")
    @Test
    void buyLottos(){
        int purchaseAmount = 12500;
        LottoMachine machine = new LottoMachine(purchaseAmount);

        LottoNumbersGenerater generater = () -> List.of(
                LottoNumber.valueOf(1), LottoNumber.valueOf(2),
                LottoNumber.valueOf(3), LottoNumber.valueOf(4),
                LottoNumber.valueOf(5), LottoNumber.valueOf(6)
        );
        Lottos lottos = machine.buyAutoLottos(generater);

        assertThat(lottos.count()).isEqualTo(12);
    }

    @DisplayName("로또 구매를 위해서 최소 1000원 이상의 금액이 필요하다")
    @Test
    void limitLottoPrice(){
        int purchaseAmount = 999;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMachine(purchaseAmount))
                .withMessage("로또 구매를 위해서 최소 1000원 이상의 금액이 필요합니다");
    }

    @DisplayName("구입금액이 수동 로또 가격보다 커야 한다")
    @Test
    void limitPriceByManualLottos(){
        int purchaseAmount = 1500;
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        String[] manualNumbers = new String[]{
                "1, 2, 3, 4, 5, 6",
                "7, 8, 9, 10, 11, 12"
        };
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoMachine.buyManualLottos(manualNumbers))
                .withMessage("로또를 구매할 돈이 부족합니다");
    }
}
