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
        assertThat(LottoMaker.getSixNumsAfterShuffle()).hasSize(6);
    }

    @Test
    public void 수동게임파서() {
        String games = "1, 2, 3, 4, 5, 6\n" +
                "3,4,5,7,8,9\n" +
                "11,14,23,44,55, 77";
        assertThat(LottoMaker.ofNewLine(games)).hasSize(3);
    }
}
