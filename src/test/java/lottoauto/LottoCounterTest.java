package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoCounterTest {
    @DisplayName("로또 카운터에 돈을 지불하면 로또를 몇장씩 줄 수 있는지 체크")
    @Test
    void calc_수동_자동_로또_갯수() {
        Money money = new Money(14_000);
        LottoCounter lottoCounter = new LottoCounter(money, 3);

        assertThat(lottoCounter.manualCount()).isEqualTo(3);
        assertThat(lottoCounter.autoCount()).isEqualTo(11);
    }

    @DisplayName("돈보다 티켓을 더 요구하는 경우 예외")
    @Test
    void 수동티켓_예외() {
        Money money = new Money(1_400);

        assertThatIllegalArgumentException().isThrownBy(()->new LottoCounter(money, 3))
                .withMessage("돈이 부족하여 수동티켓을 줄 수 없습니다.");
    }
}
