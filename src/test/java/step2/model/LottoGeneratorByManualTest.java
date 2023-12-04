package step2.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottoGeneratorByManualTest {

    @Test
    public void 사용자가_입력한_수동_로또_1장_생성하기() {
        LottoGenerator lottoGenerator = new LottoGeneratorByManual("1, 2, 3, 4, 5, 6");

        assertThat(lottoGenerator.generateLotto())
                .isEqualTo(new Lotto(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
