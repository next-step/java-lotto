package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.entry;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StatsTest {
    @DisplayName("구입한 금액과 당첨 금액을 비교하여 수익률을 반환한다.")
    @Test
    public void returnRate() {
        WinNumbers winNumbers = new WinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        HitResult game1 = new HitResult(new Numbers(Arrays.asList(1, 2, 3, 43, 44, 45)), winNumbers);
        HitResult game2 = new HitResult(new Numbers(Arrays.asList(8, 9, 10, 11, 12, 13)), winNumbers);
        HitResult game3 = new HitResult(new Numbers(Arrays.asList(8, 9, 10, 11, 12, 13)), winNumbers);
        HitResult game4 = new HitResult(new Numbers(Arrays.asList(8, 9, 10, 11, 12, 13)), winNumbers);
        HitResult game5 = new HitResult(new Numbers(Arrays.asList(8, 9, 10, 11, 12, 13)), winNumbers);

        HitResults hitResults = new HitResults(15000);
        hitResults.add(game1);
        hitResults.add(game2);
        hitResults.add(game3);
        hitResults.add(game4);
        hitResults.add(game5);

        Stats stats = new Stats(hitResults);

        assertThat(stats.returnRate()).isEqualTo(0.33);

    }

    @DisplayName("당첨 통계를 반환한다.")
    @Test
    public void stats() {
        List<Integer> winNumberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinNumbers winNumbers = new WinNumbers(winNumberList, bonusNumber);

        HitResult first = new HitResult(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6)), winNumbers);
        HitResult second = new HitResult(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 7)), winNumbers);
        HitResult third = new HitResult(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 10)), winNumbers);
        HitResult fourth1 = new HitResult(new Numbers(Arrays.asList(1, 2, 3, 4, 10, 24)), winNumbers);
        HitResult fourth2 = new HitResult(new Numbers(Arrays.asList(1, 2, 3, 4, 23, 41)), winNumbers);
        HitResult fifth = new HitResult(new Numbers(Arrays.asList(1, 2, 6, 14, 30, 41)), winNumbers);

        HitResults hitResults = new HitResults(5000);
        hitResults.add(first);
        hitResults.add(second);
        hitResults.add(third);
        hitResults.add(fourth1);
        hitResults.add(fourth2);
        hitResults.add(fifth);

        Stats stats = new Stats(hitResults);

        Map<String, Integer> countHitStats = stats.countHitStats();
        assertThat(countHitStats).contains(entry("FIRST", 1)
                , entry("SECOND", 1)
                , entry("THIRD", 1)
                , entry("FOURTH", 2)
                , entry("FIFTH", 1)
        );
    }
}
