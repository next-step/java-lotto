package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.domain.game.Lotto;
import lotto.domain.game.LottoCount;
import lotto.domain.game.Lottos;
import lotto.domain.game.NumberGenerator;
import lotto.domain.game.Payment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @DisplayName("로또 리스트 객체가 정상적으로 생성된다")
    @Test
    void 로또_리스트_객체_생성() {
        int LottoManualCount = 2;
        List<String> lottosManual = List.of(
            "1,2,3,4,5,6",
            "7,8,9,10,11,12"
        );
        Payment payment = new Payment(5000);
        LottoCount lottoCount = new LottoCount(payment, LottoManualCount);
        NumberGenerator numberGenerator = new NumberGenerator(){
            @Override
            public List<Integer> shuffleNumbers() {
                return List.of(1,2,3,4,5,6);
            }
        };

        assertDoesNotThrow(() -> new Lottos(lottoCount, lottosManual, numberGenerator));
    }

    @DisplayName("로또스에 로또 리스트를 저장한다")
    @Test
    void 로또_저장_성공() {
        int LottoManualCount = 2;
        List<String> lottosManual = List.of(
            "1,2,3,4,5,6",
            "7,8,9,10,11,12"
        );
        Payment payment = new Payment(5000);
        LottoCount lottoCount = new LottoCount(payment, LottoManualCount);
        NumberGenerator numberGenerator = new NumberGenerator(){
            @Override
            public List<Integer> shuffleNumbers() {
                return List.of(40,41,42,43,44,45);
            }
        };

        Lottos lottos = new Lottos(lottoCount, lottosManual, numberGenerator);

        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6), false);
        Lotto lotto2 = new Lotto(List.of(7,8,9,10,11,12), false);
        Lotto lotto3 = new Lotto(List.of(40,41,42,43,44,45), true);

        assertThat(lottos.getLottos()).contains(lotto1);
        assertThat(lottos.getLottos()).contains(lotto2);
        assertThat(lottos.getLottos()).contains(lotto3);
    }
}
