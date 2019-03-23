package application;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameResultTest {
    @Test
    public void 세개_맞췄을_경우() {
        List<Integer> result = Arrays.asList(3);

        assertThat(LottoGameResult.match(result.get(0))).isEqualTo(LottoGameResult.THREE);
    }

    @Test
    public void 세개_네개_맞췄을_경우() {
        List<Integer> result = Arrays.asList(3, 4);

        assertThat(LottoGameResult.match(result.get(0))).isEqualTo(LottoGameResult.THREE);
        assertThat(LottoGameResult.match(result.get(1))).isEqualTo(LottoGameResult.FOUR);
    }

    @Test
    public void 모두맞췄을경우_출력확인() {
        List<Integer> result = Arrays.asList(6);

        assertThat(LottoGameResult.match(result.get(0)).getReward()).isEqualTo(2000000000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 결과가_유효범위_밖일경우() {
        List<Integer> result = Arrays.asList(7);

        LottoGameResult.match(result.get(0));
    }
}
