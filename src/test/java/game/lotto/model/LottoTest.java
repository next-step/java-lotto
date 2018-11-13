package game.lotto.model;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 랜덤_번호_로또_생성() {
        Lotto lotto = Lotto.auto();

        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    public void 입력_번호_로또_생성() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        final Lotto lotto = Lotto.manual(lottoNumbers);

        assertThat(lotto.getLottoNumbers()).hasSize(lottoNumbers.size());
        assertThat(lotto.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 적은_번호_갯수_로또_생성() {
        final String stringNumbers = "1, 2, 3, 7, 8";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        Lotto.manual(lottoNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 많은_번호_갯수_로또_생성() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9, 10";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        Lotto.manual(lottoNumbers);
    }

    @Test
    public void 일치하는_갯수() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        final Lotto lotto = Lotto.manual(lottoNumbers);

        final String otherStringNumbers = "1, 2, 3, 4, 5, 6";
        final Set<LottoNumber> otherNumbers = LottoNumberFactory.createLottoNumbers(otherStringNumbers);
        final Lotto otherLotto = Lotto.manual(otherNumbers);

        int matchCount = lotto.getMatchOfCount(otherLotto);

        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    public void 로또_번호_존재_테스트() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        final Lotto lotto = Lotto.manual(lottoNumbers);

        final LottoNumber yes = new LottoNumber(3);
        final LottoNumber no = new LottoNumber(4);

        assertThat(lotto.contains(yes)).isTrue();
        assertThat(lotto.contains(no)).isFalse();
    }

    @Test
    public void 로또_동등성_테스트() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        final Set<LottoNumber> otherLottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);

        final Lotto lotto = Lotto.manual(lottoNumbers);
        final Lotto other = Lotto.manual(otherLottoNumbers);

        assertThat(lotto).isEqualTo(other);
    }
}