package lotto;

import lotto.model.Hit;
import lotto.model.lotto.LottoNumber;

import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class HitTest {

    @Test
    public void 맞은_개수_정상_리턴() {
        assertThat(Hit.findByNumbers(TestUtils.arrayToList(new int[]{1,2,3}), LottoNumber.of(7))).isEqualTo(Hit.HIT_3);
        assertThat(Hit.findByNumbers(TestUtils.arrayToList(new int[]{1,2,3,4}), LottoNumber.of(7))).isEqualTo(Hit.HIT_4);
        assertThat(Hit.findByNumbers(TestUtils.arrayToList(new int[]{1,2,3,4,5}), LottoNumber.of(7))).isEqualTo(Hit.HIT_5);
        assertThat(Hit.findByNumbers(TestUtils.arrayToList(new int[]{1,2,3,4,5,7}), LottoNumber.of(7))).isEqualTo(Hit.HIT_6_BONUS);
        assertThat(Hit.findByNumbers(TestUtils.arrayToList(new int[]{1,2,3,4,5,6}), LottoNumber.of(7))).isEqualTo(Hit.HIT_6);
        assertThat(Hit.findByNumbers(Collections.emptyList(),  LottoNumber.of(7))).isEqualTo(Hit.HIT_NONE);
    }



}
