package game.lotto.model;

import org.junit.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 랜덤_번호_로또_생성() {
        Lotto lotto = new Lotto();

        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    public void 입력_번호_로또_생성() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        final Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.getLottoNumbers()).hasSize(lottoNumbers.size());
        assertThat(lotto.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 적은_번호_갯수_로또_생성() {
        final String stringNumbers = "1, 2, 3, 7, 8";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        new Lotto(lottoNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 많은_번호_갯수_로또_생성() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9, 10";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        new Lotto(lottoNumbers);
    }

    @Test
    public void 일치하는_갯수() {
        final String stringNumbers = "1, 2, 3, 7, 8, 9";
        final Set<LottoNumber> lottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);
        final Lotto lotto = new Lotto(lottoNumbers);

        final String otherStringNumbers = "1, 2, 3, 4, 5, 6";
        final Set<LottoNumber> otherNumbers = LottoNumberFactory.createLottoNumbers(otherStringNumbers);
        final Lotto otherLotto = new Lotto(otherNumbers);

        int matchCount = lotto.match(otherLotto);

        assertThat(matchCount).isEqualTo(3);
    }
}