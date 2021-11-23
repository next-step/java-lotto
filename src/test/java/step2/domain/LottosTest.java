package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.strategy.RandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0", "999,0", "1999,1", "10999,10"}, delimiter = ',')
    void 로또를_구입한다(int price, int lottoCount) {
        //given
        Lottos lottos = Lottos.purchase(price, new RandomNumberGenerator());
        //when
        List<Lotto> purchaseList = lottos.getLottos();
        //then
        assertThat(purchaseList.size()).isEqualTo(lottoCount);
    }
}
