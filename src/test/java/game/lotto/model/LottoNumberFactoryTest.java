package game.lotto.model;

import game.lotto.util.WinningNumberSplitor;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.filter;

public class LottoNumberFactoryTest {

    @Test
    public void 랜덤_로또_번호_생성() {
        Set<LottoNumber> lottoNumbers = LottoNumberFactory.createRandomLottoNumbers();

        assertThat(lottoNumbers).hasSize(Lotto.NUMBER_SIZE);
    }

    //TODO 고쳐야댐
    @Test(expected = IllegalArgumentException.class)
    public void 당첨_번호_생성_당첨번호_갯수_적을때() {
        final String stringWinningNumbers = "1, 2, 3, 4, 5";
        LottoNumberFactory.createWinningLottoNumbers(stringWinningNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 당첨_번호_생성_당첨번호_갯수_많을때() {
        final String stringWinningNumbers = "1, 2, 3, 4, 5, 6, 7";
        LottoNumberFactory.createWinningLottoNumbers(stringWinningNumbers);
    }

    @Test
    public void 당첨_번호_생성() {
        final String stringWinningNumbers = "1, 2, 3, 4, 5, 6";
        final String[] expectedNumbers = WinningNumberSplitor.split(stringWinningNumbers);
        Arrays.sort(expectedNumbers);

        Set<LottoNumber> winningLottoNumbers = LottoNumberFactory.createWinningLottoNumbers(stringWinningNumbers);

        assertThat(winningLottoNumbers.toString()).isEqualTo(Arrays.toString(expectedNumbers));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복_당첨_번호_생성() {
        final String stringWinningNumbers = "1, 2, 3, 4, 5, 5";

        LottoNumberFactory.createWinningLottoNumbers(stringWinningNumbers);
    }

}