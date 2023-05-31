package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMatcher;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또결과_3개일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(
                createLottoNumber(1, 2, 3, 7, 8, 9),
                45
        );
        LottoMatcher result = winningNumbers.match(lotto);

        assertThat(result).isEqualTo(LottoMatcher.FIFTH_MATCH);
    }

    @Test
    void 로또결과_4개일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(
                createLottoNumber(1, 2, 3, 4, 8, 9),
                45
        );
        LottoMatcher result = winningNumbers.match(lotto);

        assertThat(result).isEqualTo(LottoMatcher.FOURTH_MATCH);
    }

    @Test
    void 로또결과_5개일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(
                createLottoNumber(1, 2, 3, 4, 5, 9),
                45
        );
        LottoMatcher result = winningNumbers.match(lotto);

        assertThat(result).isEqualTo(LottoMatcher.THIRD_MATCH);
    }

    @Test
    void 로또결과_5개일치_보너스일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(
                createLottoNumber(1, 2, 3, 4, 5, 9),
                6
        );
        LottoMatcher result = winningNumbers.match(lotto);

        assertThat(result).isEqualTo(LottoMatcher.SECOND_MATCH);
    }


    @Test
    void 로또결과_6개일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(
                createLottoNumber(1, 2, 3, 4, 5, 6),
                45
        );
        LottoMatcher result = winningNumbers.match(lotto);

        assertThat(result).isEqualTo(LottoMatcher.FIRST_MATCH);
    }

    @Test
    void 로또결과_2개_이하_일치() {
        Lotto lottoMatchedTwo = new Lotto(createLottoNumber(1, 2, 10, 11, 12, 13));
        Lotto lottoMatchedOne = new Lotto(createLottoNumber(1, 14, 10, 11, 12, 13));
        Lotto lottoMatchedZero = new Lotto(createLottoNumber(15, 14, 10, 11, 12, 13));
        WinningNumbers winningNumbers = new WinningNumbers(
                createLottoNumber(1, 2, 3, 4, 5, 6),
                45
        );

        LottoMatcher resultMatchedTwo = winningNumbers.match(lottoMatchedTwo);
        LottoMatcher resultMatchedOne = winningNumbers.match(lottoMatchedOne);
        LottoMatcher resultMatchedZero = winningNumbers.match(lottoMatchedZero);

        assertThat(resultMatchedTwo).isEqualTo(LottoMatcher.NONE_MATCH);
        assertThat(resultMatchedOne).isEqualTo(LottoMatcher.NONE_MATCH);
        assertThat(resultMatchedZero).isEqualTo(LottoMatcher.NONE_MATCH);
    }

    static List<Integer> createLottoNumber(
            int number1,
            int number2,
            int number3,
            int number4,
            int number5,
            int number6
    ) {
        return List.of(number1, number2, number3, number4, number5, number6);
    }
}
