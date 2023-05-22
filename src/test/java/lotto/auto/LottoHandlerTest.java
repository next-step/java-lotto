package lotto.auto;

import lotto.auto.domain.Lotto;
import lotto.auto.domain.LottoHandler;
import lotto.auto.domain.Win;
import lotto.auto.vo.Money;
import lotto.auto.vo.WinNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoHandlerTest {

    LottoHandler lottoHandler = new LottoHandler();
    @Test
    @DisplayName("입력 금액에 맞춰 로또 갯수가 나오는지 테스트")
    public void 금액_테스트() {
        assertThat(lottoHandler.buyLotto(new Money(14000))).isEqualTo(14);
    }

    @Test
    @DisplayName("입력받은 수만큼 로또를 생성하는 테스트")
    public void 로또생성_테스트() {
        List<Lotto> lotto = lottoHandler.createLotto(5);
        assertThat(lotto.size()).isEqualTo(5);
        assertThat(lotto.get(0)).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("로또와 당첨번호를 입력받아 몇등을 했는지 확인하는 테스트")
    public void 당첨확인() {
        List<Lotto> lottos = Arrays.asList(new Lotto(), new Lotto());
        WinNumber winNumber = new WinNumber(lottos.get(0).getLottoNumbers());
        List<Win> wins = lottoHandler.confirmWinner(lottos, winNumber);
        assertThat(wins).contains(Win.FIRST_PLACE);
    }

    @Test
    @DisplayName("수익률 계산기")
    public void 수익률계산기() {
        Double returnValue = lottoHandler.getReturn(new Money(10000), List.of(Win.LAST_PLACE));
        assertThat(returnValue).isEqualTo(0.5);
    }


}
