package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또_번호와_당첨_번호_일치_개수_계산() {
        //given
        List<LottoNumber> myLottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumbers myLottoNumbers = new LottoNumbers(myLottoNumberList);

        List<LottoNumber> winningLottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningLottoNumberList);

        //when
        int result = Lotto.matchCount(myLottoNumbers, winningLottoNumbers);

        //then
        assertThat(result).isEqualTo(6);
    }
}
