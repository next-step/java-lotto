package game.lotto.model;

import game.lotto.util.WinningNumberSplitor;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberFactoryTest {

    @Test
    public void 랜덤_로또_번호_생성() {
        Set<LottoNumber> lottoNumbers = LottoNumberFactory.createRandomLottoNumbers();

        assertThat(lottoNumbers).hasSize(Lotto.NUMBER_SIZE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 문자열_번호_생성_번호_갯수_적을때() {
        final String stringNumbers = "1, 2, 3, 4, 5";
        LottoNumberFactory.createLottoNumbers(stringNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 문자열_번호_생성_번호_갯수_많을때() {
        final String stringNumbers = "1, 2, 3, 4, 5, 6, 7";
        LottoNumberFactory.createLottoNumbers(stringNumbers);
    }

    @Test
    public void 문자열_번호_생성() {
        final String stringNumbers = "1, 2, 3, 4, 5, 6";
        final String[] expectedNumbers = WinningNumberSplitor.split(stringNumbers);
        Arrays.sort(expectedNumbers);

        Set<LottoNumber> winningLottoNumbers = LottoNumberFactory.createLottoNumbers(stringNumbers);

        assertThat(winningLottoNumbers.toString()).isEqualTo(Arrays.toString(expectedNumbers));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복_문자열_번호_생성() {
        final String stringNumbers = "1, 2, 3, 4, 5, 5";

        LottoNumberFactory.createLottoNumbers(stringNumbers);
    }

}