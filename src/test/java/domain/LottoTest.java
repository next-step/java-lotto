package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void lottoTest() {
        lotto = new Lotto(LottoNumbers.convertToLottoNo(Arrays.asList(1, 3, 5, 15, 30, 31)));
    }

    @Test
    public void 숫자_2포함() {
        assertThat(lotto.isContains(LottoNo.of(2))).isFalse();
    }

    @Test
    public void 숫자_1포힘() {
        assertThat(lotto.isContains(LottoNo.of(1))).isTrue();
    }

    @Test
    public void 로또6개_일치() {
        List<LottoNo> lottoNumbers
            = Arrays.asList(LottoNo.of(1), LottoNo.of(3), LottoNo.of(5), LottoNo.of(15), LottoNo.of(30), LottoNo.of(31));
        assertThat(lotto.matchCount(lottoNumbers)).isEqualTo(6);
    }

    @Test
    public void 로또0개_일치() {
        List<LottoNo> lottoNumbers
                = Arrays.asList(LottoNo.of(40), LottoNo.of(41), LottoNo.of(42), LottoNo.of(43), LottoNo.of(44), LottoNo.of(45));
        assertThat(lotto.matchCount(lottoNumbers)).isEqualTo(0);
    }
}