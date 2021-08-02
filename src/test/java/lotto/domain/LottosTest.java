package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottosTest {

    @DisplayName("비어있을 경우 예외 throw")
    @Test
    void Lottos_값이있는지() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lottos(null);
        }).withMessageMatching("값이 null이거나 비어있습니다.");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lottos(new ArrayList<Lotto>());
        }).withMessageMatching("값이 null이거나 비어있습니다.");
    }

    @DisplayName("값을 가져오는지 size 확인")
    @Test
    void getLottos_값을가져오는지() {

        List<Lotto> Lottolist = new ArrayList<>();
        Lottolist.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        Lottolist.add(new Lotto(Arrays.asList(11,12,13,14,15,16)));
        Lottolist.add(new Lotto(Arrays.asList(21,22,23,24,25,26)));
        Lottos lottos = new Lottos(Lottolist);

        assertThat(lottos.getLottos().size()).isEqualTo(3);
    }





}