package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.Lottos;
import step2.Domain.Money;
import step2.Domain.PurchaseManager;
import step2.Domain.RandomLottoNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseTest {

    @Test
    @DisplayName("로또 구매시 구입금액 만큼 Lottos 번호 자동 생성 테스트")
    void 로또번호_6개_자동생성_테스트(){
        PurchaseManager manager = new PurchaseManager(new Money(14000));
        Lottos lottos = Lottos.of(new RandomLottoNumberGenerator(manager));
        assertThat(lottos.getLottos().size()).isEqualTo(manager.getPurchasedLottoNumber().getNumber());
    }

}
