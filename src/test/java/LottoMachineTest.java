import Lotto.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {


    @Test
    @DisplayName("입력된 금액만큼 로또번호 반환")
    void insertMoneyCreateLotto() {

        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

        List<Lotto> lottos = lottoMachine.createLotto(new Money(50000));

        assertThat(lottos.size()).isEqualTo(50);
    }

    @Test
    @DisplayName("로또최종 테스트 ")
    void lottoTest() {

        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

        List<Lotto> lottos = lottoMachine.createLotto(new Money(5000));

        lottos.forEach(s -> System.out.println(s.getLottoNumbers()));


        String[] userNumbers = {"1", "2", "8", "4", "9", "6"};

        WinningNumber winningNumber = WinningNumber.of(userNumbers);

        List<WinningPrice> winningPrice = new ArrayList<>();

        for (int i = 0; i < lottos.size(); i++) {
            winningPrice.add(WinningPrice.getWinnings(lottos.get(i).compareNumbers(List.of(winningNumber.convertInteger()))));
        }


        WinningResult winningResult = new WinningResult(winningPrice);
        System.out.println(winningResult.getWinningResult().toString());
        System.out.println("총 수익률은 " + winningResult.yieldAccount(5000) + "입니다.");

    }

}
