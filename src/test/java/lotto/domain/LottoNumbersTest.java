package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoNumberTest.createLottoNumber;
import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("from 호출 시 LottoNumbers 반환")
    void from() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(createLottoNumber(1, 2, 3, 4, 5, 6));
        lottoNumberList.add(createLottoNumber(1, 2, 3, 4, 5, 6));
        lottoNumberList.add(createLottoNumber(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumberList);
        assertThat(lottoNumbers.size()).isEqualTo(3);
        lottoNumberList.add(createLottoNumber(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("computeLottoResult로 넘어오는 LottoNumber로 LottoResult 반환")
    void computeLottoResult() {

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(createLottoNumber(1, 2, 3, 11, 22, 33));
        lottoNumberList.add(createLottoNumber(1, 2, 3, 21, 42, 45));
        lottoNumberList.add(createLottoNumber(1, 2, 3, 4, 44, 11));
        lottoNumberList.add(createLottoNumber(1, 2, 3, 4, 5, 11));

        LottoNumber winningNumber = createLottoNumber(1, 2, 3, 4, 5, 6);

        LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumberList);

        LottoResult lottoResult = lottoNumbers.computeLottoResult(new WinningNumber(winningNumber, MyNumber.bonusNumberFrom(30, winningNumber)));
        assertThat(lottoResult.getCorrectCountsByLottoRank(LottoRank.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("getLottoNumbers 호출 시 문자열로 치환된 모든 LottoNumber의 리스트를 반환")
    void getLottoNumbers() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(createLottoNumber(1, 2, 3, 11, 22, 33));
        lottoNumberList.add(createLottoNumber(1, 2, 3, 21, 42, 45));

        LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumberList);
        assertThat(lottoNumbers.getLottoNumbersToString()).containsExactly("[1, 2, 3, 11, 22, 33]", "[1, 2, 3, 21, 42, 45]");
        assertThat(lottoNumbers.getLottoNumbersToString()).doesNotContain("[1, 2, 3, 4, 5, 6]");
    }
}
