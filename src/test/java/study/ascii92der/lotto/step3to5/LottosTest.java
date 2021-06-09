package study.ascii92der.lotto.step3to5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("Lottos 객체 정상 생성 확인")
    void create() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 33));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 41, 16, 17, 18));
        Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2))));
        assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @Test
    @DisplayName("LottoResult list 생성 확인")
    void matchResults() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 33));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 4, 33, 17, 18));
        List<Integer> lottoNumbers3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2))));
        WinningLotto winningLotto = new WinningLotto(new Lotto(lottoNumbers3), new LottoNumber(33));
        assertThat(lottos.matchResults(winningLotto).size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Lottos merge test")
    void merge() {
        List<Integer> lottoNumbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 33));
        List<Integer> lottoNumbers2 = new ArrayList<>(Arrays.asList(1, 2, 4, 33, 17, 18));
        List<Integer> lottoNumbers3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers1),
                new Lotto(lottoNumbers2), new Lotto(lottoNumbers3))));
        List<Integer> lottoNumbers4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 33));
        List<Integer> lottoNumbers5 = new ArrayList<>(Arrays.asList(1, 2, 4, 33, 17, 18));
        Lottos lottos2 = new Lottos(new ArrayList<>(Arrays.asList(new Lotto(lottoNumbers4),
                new Lotto(lottoNumbers5))));

        Lottos mergedLottos = lottos.merge(lottos2);

        assertThat(mergedLottos).extracting("lottos").asList().size().isEqualTo(5);
    }
}