package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoResultTest {
    @Test
    void create() {
        Lotto winLotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});

        LottoGroup lottoGroup = new LottoGroup(
                List.of(
                new Lotto(new String[]{"1", "2", "3", "9", "8", "7"}),
                new Lotto(new String[]{"1", "2", "3", "44", "15", "26"}),
                new Lotto(new String[]{"1", "2", "31", "34", "45", "36"})
            )
        );

        LottoResult lottoResult = new LottoResult(lottoGroup, winLotto);

        Assertions.assertThat(lottoResult.calTotal()).isEqualTo(10000);
    }
}
