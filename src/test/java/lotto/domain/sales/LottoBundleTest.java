package lotto.domain.sales;

import lotto.domain.number.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    @Test
    void 수동_생성() {
        String[] manuals = List.of("1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,9,10").toArray(new String[0]);

        LottoBundle manualLotto = LottoBundle.of(manuals);

        assertThat(manualLotto.lottos())
            .contains(new Lotto("1,2,3,4,5,6"),
                new Lotto("2,3,4,5,6,7"),
                new Lotto("3,4,5,6,9,10"));
    }

    @Test
    void 로또들_합친_로또_생성() {
        String[] manual1 = List.of("1,2,3,4,5,6", "4,5,6,7,8,9").toArray(new String[0]);
        String[] manual2 = List.of("2,3,4,5,6,7", "7,8,9,10,11,12").toArray(new String[0]);
        LottoBundle lottoBundle1 = LottoBundle.of(manual1);
        LottoBundle lottoBundle2 = LottoBundle.of(manual2);
        LottoBundle quickPick = LottoBundle.of(5);

        LottoBundle integrated = LottoBundle.of(lottoBundle1, lottoBundle2, quickPick);

        assertThat(integrated.lottos()).contains(lottoBundle1.lottos().toArray(new Lotto[0]));
        assertThat(integrated.lottos()).contains(lottoBundle2.lottos().toArray(new Lotto[0]));
        assertThat(integrated.lottos()).contains(quickPick.lottos().toArray(new Lotto[0]));
    }

    @Test
    void 빈_가변인수_예외발생() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoBundle.of(new String[0]));
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoBundle.of(new LottoBundle[0]));
    }
}
