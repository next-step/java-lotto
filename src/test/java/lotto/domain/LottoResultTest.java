package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void 로또결과에_따라_정상_확인() {
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers beforeLottoNumbers = new LottoNumbers(Arrays.asList(1, 3, 5, 7, 9, 11));
        int purchasesNumber = 1;
        int bonumNumber = 9;
        WinLottoNumber winLottoNumber = new WinLottoNumber(beforeLottoNumbers, bonumNumber);
        assertThat(new LottoResult(lottoNumbers, purchasesNumber, winLottoNumber)).toString();
    }
}