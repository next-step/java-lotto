package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("로또 리스트를 받았을 때, 수익률 추출")
    void 당첨_금액_수익률() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4);
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(LottoResult.getLottoResult(lottos, winner, 1000).getReturnRate()).isEqualTo(500388.75);
    }

    @Test
    @DisplayName("로또 리스트를 받았을 때, 당첨 금액 추출")
    void 당첨_금액_추출() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4);
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(LottoResult.getLottoResult(lottos, winner, 1000).getPriceTotal()).isEqualTo(2001555000);
    }

    @Test
    @DisplayName("로또 리스트를 받았을 때, 당첨 결과 리스트 추출")
    void 로또_리스트로_당첨_결과_생성() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8));
        Lotto lotto4 = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4);
        Lotto winner = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(LottoResult.getLottoResult(lottos, winner, 1000)).isEqualTo(new LottoResult(Arrays.asList(3, 4, 5, 6), 14000));
    }

    @Test
    @DisplayName("로또 결과에서 수익률 반환")
    void 당첨_수익률_생성() {
        assertThat(new LottoResult(Arrays.asList(5, 6), 10000).getReturnRate()).isEqualTo(200150);
    }

    @Test
    @DisplayName("로또 결과에서 당첨금액 합산한 값 반환")
    void 당첨_결과_생성() {
        assertThat(new LottoResult(Arrays.asList(5, 6), 14000).getPriceTotal()).isEqualTo(2001500000);
    }
}
