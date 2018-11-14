package lotto.utils;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMakerTest {
    @Test
    public void 로또기본리스트생성() {
        assertThat(LottoMaker.getOnetoFortyFive()).hasSize(45);
    }

    @Test
    public void 여섯개번호뽑기테스트() {
        assertThat(LottoMaker.getSixNumsAfterShuffle(LottoMaker.getOnetoFortyFive())).hasSize(6);
    }
}
