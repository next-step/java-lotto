package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoResultTest {

    @Test
    @DisplayName("수익률 테스트")
    public void winningMatch(){
        Lottos lottos = new Lottos(
                List.of(
                        new LottoTicket(List.of(1, 11, 5, 7, 12, 10))
                        , new LottoTicket(List.of(1, 15, 16, 17, 19, 20))
                        , new LottoTicket(List.of(1, 3, 5, 7, 9, 10))
                ));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,3,5,7,9,10));
        LottoResult lottoResult = new LottoResult(lottos,winningNumbers);
        lottoResult.matchResult();
        Assertions.assertThat(lottoResult.lottoYieldCalculate(new Money(5000))).isEqualTo(400010);
    }


}
