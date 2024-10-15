package lotto.domain.sales;

import lotto.domain.number.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    @Test
    void 수동_생성() {
        String[] manuals = List.of("1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,9,10").toArray(new String[0]);

        LottoBundle manualLotto = new LottoBundle(manuals);

        assertThat(manualLotto.lottos()).contains(Arrays.stream(manuals)
                .map(Lotto::new).toArray(Lotto[]::new));
    }

    @Test
    void 로또들_합친_로또_생성() {
        String[] manual1 = List.of("1,2,3,4,5,6", "4,5,6,7,8,9").toArray(new String[0]);
        String[] manual2 = List.of("2,3,4,5,6,7", "7,8,9,10,11,12").toArray(new String[0]);
        LottoBundle lottoBundle1 = new LottoBundle(manual1);
        LottoBundle lottoBundle2 = new LottoBundle(manual2);
        LottoBundle quickPick = new LottoBundle(5);

        LottoBundle integrated = new LottoBundle(lottoBundle1, lottoBundle2, quickPick);

        assertThat(integrated.lottos()).contains(lottoBundle1.lottos().toArray(new Lotto[0]));
        assertThat(integrated.lottos()).contains(lottoBundle2.lottos().toArray(new Lotto[0]));
        assertThat(integrated.lottos()).contains(quickPick.lottos().toArray(new Lotto[0]));
    }
}
