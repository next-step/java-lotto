package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BundleDrawResultTest {

    @DisplayName("돈 합 구하기 테스트")
    @Test
    public void sumMoneyTest() {

        List<DrawResult> list = new ArrayList<>();
        list.add(DrawResult.THIRD);
        list.add(DrawResult.SECOND);
        list.add(DrawResult.FIRST);

        int sum = list.stream()
                .mapToInt(item -> (int) item.getMoney())
                .sum();

        BundleDrawResult bundleDrawResult = new BundleDrawResult(list);
        assertThat(bundleDrawResult.getTotalMoney()).isEqualTo(sum);
    }

    @DisplayName("등수별 갯수 테스트")
    @Test
    public void getRankLottoCountTest() {

        List<DrawResult> list = new ArrayList<>();
        list.add(DrawResult.THIRD);
        list.add(DrawResult.SECOND);
        list.add(DrawResult.FIRST);
        BundleDrawResult bundleDrawResult = new BundleDrawResult(list);
        assertAll(
                () -> assertThat(bundleDrawResult.getRankLottoCount(1)).isEqualTo(1),
                () -> assertThat(bundleDrawResult.getRankLottoCount(2)).isEqualTo(1),
                () -> assertThat(bundleDrawResult.getRankLottoCount(3)).isEqualTo(1)
        );
    }

}
