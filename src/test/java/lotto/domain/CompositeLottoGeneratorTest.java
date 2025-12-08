package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CompositeLottoGeneratorTest {

    @Test
    void merge() {
        List<Lotto> manualList = List.of(
                new Lotto(1, 2, 3, 4, 5, 6)
                , new Lotto(2, 3, 4, 5, 6, 7)
        );
        LottoGenerator manual = new ManualLottoGenerator(manualList);
        LottoGenerator auto = new AutoLottoGenerator(new LottoCount(2));

        LottoGenerator composite = new CompositeLottoGenerator(
                List.of(manual, auto)
        );

        Lottos merge = composite.generate();
        assertThat(merge.size()).isEqualTo(4);
    }
}