package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;
import lotto.lotto.LottoWinning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private List<LottoNumber> lottoNumberList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(10));
    }

    @Test
    void 로또_번호_찾기_findLottoNumber() {
        Lotto lotto = new Lotto(lottoNumberList);
        IntStream.range(0, lotto.getLotto().size()).forEach(i -> {
            assertThat(lotto.findLottoNumber(i)).isEqualTo(lottoNumberList.get(i).getNumber());
        });
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 로또번호의 매칭 개수를 계산")
    @CsvSource({
            "'1, 2, 3, 4, 5, 10' , 44, 6",
            "'41, 42, 30, 44, 6' , 7, 0"
    })
    void calculateMatchingCnt(String winNumber, int bonusNumber, int expectedResult) {
        LottoWinning winning = new LottoWinning(winNumber, bonusNumber);
        Lotto lotto = new Lotto(lottoNumberList);

        assertThat(lotto.calculateMatchingCnt(winning)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("보너스번호는 당첨번호와 로또번호의 매칭 개수에서 제외")
    @CsvSource({
            "'1, 2, 3, 4, 5, 11' , 10, 5"
    })
    void calculateMatchingCntIncludeBonusNumber(String winNumber, int bonusNumber, int expectedResult) {
        LottoWinning winning = new LottoWinning(winNumber, bonusNumber);
        Lotto lotto = new Lotto(lottoNumberList);

        assertThat(lotto.calculateMatchingCnt(winning)).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
            "'1, 2, 3, 4, 5, 45' , 5, 10 ",
            "'1, 2, 3, 4, 7, 45' , 5, 44 "
    })
    @DisplayName("5개 일치하고 보너스번호가있는경우 보너스여부는 true, 없는경우 false")
    void isTwoBonusWin(String abc, int matchingCnt, int bonusNumber) {
        LottoWinning winning = new LottoWinning(abc, bonusNumber);
        Lotto lotto = new Lotto(lottoNumberList);;
        boolean result = bonusNumber == 10;

        assertThat(lotto.isTwoBonusWin(matchingCnt, winning)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "'1, 2, 3, 4, 7, 45' , 4, 10 ",
            "'1, 2, 3, 4, 7, 45' , 4, 44 "
    })
    @DisplayName("4개 일치하고 보너스번호가 있든 없든 false")
    void notTwoBonusWin(String abc, int matchingCnt, int bonusNumber) {
        LottoWinning winning = new LottoWinning(abc, bonusNumber);
        Lotto lotto = new Lotto(lottoNumberList);;
        assertThat(lotto.isTwoBonusWin(matchingCnt, winning)).isFalse();
    }
}
