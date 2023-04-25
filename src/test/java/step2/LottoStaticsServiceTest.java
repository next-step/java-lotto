package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStaticsServiceTest {
    @Test
    void 당첨_확인_테스트() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoStatisService lottoStatisService = new LottoStatisService(lotto);
        assertThat(lottoStatisService.isWin(lotto)).isTrue();
    }


}
