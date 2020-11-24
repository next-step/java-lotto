package lotto;

import lotto.model.Hit;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class HitTest {

    @Test
    public void 맞은_개수_정상_리턴() {
        SortedSet<LottoNumber> hit3 = TestUtils.arrayToSortedSet(new int[]{1,2,3});
        assertThat(Hit.findByNumbers(hit3, new LottoNumber(7))).isEqualTo(Hit.HIT_3);

        SortedSet<LottoNumber> hit4 = TestUtils.arrayToSortedSet(new int[]{1,2,3,4});
        assertThat(Hit.findByNumbers(hit4,new LottoNumber(7))).isEqualTo(Hit.HIT_4);

        SortedSet<LottoNumber> hit5 = TestUtils.arrayToSortedSet(new int[]{1,2,3,4,5});
        assertThat(Hit.findByNumbers(hit5,new LottoNumber(7))).isEqualTo(Hit.HIT_5);

        SortedSet<LottoNumber> hit5Second = TestUtils.arrayToSortedSet(new int[]{1,2,3,4,5,7});
        assertThat(Hit.findByNumbers(hit5Second,new LottoNumber(7))).isEqualTo(Hit.HIT_6_BONUS);

        SortedSet<LottoNumber> hit6 = TestUtils.arrayToSortedSet(new int[]{1,2,3,4,5,6});
        assertThat(Hit.findByNumbers(hit6, new LottoNumber(7))).isEqualTo(Hit.HIT_6);

        SortedSet<LottoNumber> hitNone = new TreeSet<>(Collections.emptyList());
        assertThat(Hit.findByNumbers(hitNone, new LottoNumber(7))).isEqualTo(Hit.HIT_NONE);
    }



}
