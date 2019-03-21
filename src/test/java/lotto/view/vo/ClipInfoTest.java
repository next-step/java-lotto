package lotto.view.vo;

import lotto.enums.Rank;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ClipInfoTest {

    @Test
    public void 초기화() {
        CountInfo countInfo = new CountInfo();

        assertThat(countInfo.getCounts().size()).isEqualTo(0);
    }

    @Test
    public void 카운팅_정보_추가() {
        CountInfo countInfo = new CountInfo();
        countInfo.put(Rank.SECOND, 10);

        assertThat(countInfo.getCounts().get(Rank.SECOND)).isEqualTo(10);
    }
}
