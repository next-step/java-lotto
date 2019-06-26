package lotto.util;

import lotto.model.Lotto;
import lotto.util.LottoResultProvider;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTestProviderTest {

    @Test
    void getThreeCorrectResult() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 4, 5, 6, 20, 45))); // 5개 적중
        lottos.add(new Lotto(Arrays.asList(5, 20, 21, 35, 40, 41))); // 2개 적중
        lottos.add(new Lotto(Arrays.asList(6, 7, 20, 25, 30, 37))); // 3개 적중
        lottos.add(new Lotto(Arrays.asList(1, 2, 5, 6, 20, 21))); // 4개 적중
        lottos.add(new Lotto(Arrays.asList(1, 2, 5, 6, 20, 21))); // 4개 적중
        lottos.add(new Lotto(Arrays.asList(1, 2, 5, 6, 20, 21))); // 4개 적중
        lottos.add(new Lotto(Arrays.asList(1, 2, 5, 6, 20, 21))); // 4개 적중

        LottoResultProvider lottoResultProvider = new LottoResultProvider(lottos, Arrays.asList(1, 4, 5, 6, 20, 25));
        assertThat(lottoResultProvider.getResult().getWinningCount3()).isEqualTo(1);
        assertThat(lottoResultProvider.getResult().getWinningCount4()).isEqualTo(4);
        assertThat(lottoResultProvider.getResult().getWinningCount5()).isEqualTo(1);
        assertThat(lottoResultProvider.getResult().getWinningCount6()).isEqualTo(0);
    }
}
