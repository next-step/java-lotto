package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @Before
    public void initWinningNumbers() throws Exception {
        this.winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @Test(expected = Exception.class)
    public void 로또_7개_입력시() throws Exception {
        Lotto lotto  = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }

    @Test(expected = Exception.class)
    public void 로또_범위_오류() throws Exception {
        Lotto lotto  = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 48)));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }

    @Test
    public void 로또_1개일치() throws Exception {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 10, 11, 12, 14, 15)));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(1);
    }

    @Test
    public void 로또_2개일치() throws Exception {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 11, 12, 14, 15)));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(2);
    }

    @Test
    public void 로또_3개일치() throws Exception {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 12, 14, 15)));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(3);
    }

    @Test
    public void 로또_4개일치() throws Exception {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 14, 15)));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(4);
    }

    @Test
    public void 로또_5개일치() throws Exception {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 15)));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(5);
    }

    @Test
    public void 로또_6개일치() throws Exception {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(this.winningNumbers.calcMatchCount(lotto)).isEqualTo(6);
    }

    @Test
    public void 로또_5개미만_일치_보너스볼_일치() throws Exception {
        Lotto lotto  = new Lotto(new LottoNumbers(Arrays.asList(1, 4, 6, 10, 13, 15)));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }

    @Test
    public void 로또_5개_일치_보너스볼_불일치() throws Exception {
        Lotto lotto  = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 15)));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }

    @Test
    public void 로또_5개_일치_보너스볼_일치() throws Exception {
        Lotto lotto  = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isTrue();
    }

    @Test
    public void 로또_6개_일치() throws Exception {
        Lotto lotto  = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(this.winningNumbers.isContainsBonusBall(lotto)).isFalse();
    }
}