package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("로또 집합 생성 테스트")
    @Test
    void lottosCreatedTest() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            lottos.add(new Lotto(lottoNumberList));
        }
        Lottos lottos1 = new Lottos(new ArrayList<>(), lottos);
        assertThat(lottos1.lottoCount()).isEqualTo(5);
    }
}
