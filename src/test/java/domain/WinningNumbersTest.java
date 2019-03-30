package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @Before
    public void initWinningNumbers() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6));
        LottoNo bonusBall = new LottoNo(7);
        this.winningNumbers = new WinningNumbers(new LottoNumbers(lottoNos), bonusBall);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_7개_입력시() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6), new LottoNo(7));
        Lotto lotto  = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }

    @Test(expected = Exception.class)
    public void 로또_범위_오류() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(48));
        Lotto lotto  = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }

    @Test
    public void 로또_1개일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(10), new LottoNo(11), new LottoNo(12), new LottoNo(13), new LottoNo(14));
        Lotto lotto  = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(1);
    }

    @Test
    public void 로또_2개일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(11), new LottoNo(12), new LottoNo(13), new LottoNo(14));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(2);
    }

    @Test
    public void 로또_3개일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(12), new LottoNo(13), new LottoNo(14));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(3);
    }

    @Test
    public void 로또_4개일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(13), new LottoNo(14));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(4);
    }

    @Test
    public void 로또_5개일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(14));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(5);
    }

    @Test
    public void 로또_6개일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(6);
    }

    @Test
    public void 로또_5개미만_일치_보너스볼_일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(4), new LottoNo(6), new LottoNo(10), new LottoNo(13), new LottoNo(14));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }

    @Test
    public void 로또_5개_일치_보너스볼_불일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(14));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }

    @Test
    public void 로또_5개_일치_보너스볼_일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(7));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isTrue();
    }

    @Test
    public void 로또_6개_일치() {
        List<LottoNo> lottoNos = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6));
        Lotto lotto = new Lotto(new LottoNumbers(lottoNos));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }
}