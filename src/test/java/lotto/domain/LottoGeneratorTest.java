package lotto.domain;

import static lotto.domain.LottoGenerator.lottoGenerator;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    @DisplayName("로또 개수 구하기(1000원 이상)")
    void 로또_개수_구하기_1000원_이상(){

        assertThat(LottoShuffleGenerator.calculateNumberOfLotto(14000)).isEqualTo(14);

    }

    @Test
    @DisplayName("1000원 미만 입력 시 예외 발생")
    void 로또_구매_불가_1000원_미만(){
        Assertions.assertThatThrownBy(
                () -> LottoShuffleGenerator.calculateNumberOfLotto(999)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성 테스트")
    void 로또_생성_테스트() {
        Lottos lottos = Lottos.createLottos(3000, purchaseAmount -> {
            List<Lotto> generatedLottos = new ArrayList<>();
            for (int i = 0; i < purchaseAmount / LottoGenerator.PRICE_OF_LOTTO; i++) {
                generatedLottos.add(new Lotto(lottoGenerator.subList(0, LottoGenerator.LOTTO_SIZE)));
            }
            return generatedLottos;
        });

        Assertions.assertThat(lottos.getNumberOfLotto()).isEqualTo(3);
    }

}

