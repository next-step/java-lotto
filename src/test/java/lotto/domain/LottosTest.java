package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private Money money;
    private LottoNumbers lottoNumbers = new LottoNumbers();

    @Test
    @DisplayName("로또 자동 5개 구매 성공 테스트")
    void 로또_5개_구매_성공_테스트() {
        money = new Money(5000); //5000원 입력
        Lottos lottos = new Lottos(money, lottoNumbers);
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
