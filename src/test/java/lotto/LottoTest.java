package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 로또결과_3개일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        LottoMatcher result = lotto.result(createLottoNumber(1, 2, 3, 7, 8, 9));

        assertThat(result).isEqualTo(LottoMatcher.FOURTH);
    }

    @Test
    void 로또결과_4개일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        LottoMatcher result = lotto.result(createLottoNumber(1, 2, 3, 4, 8, 9));

        assertThat(result).isEqualTo(LottoMatcher.THIRD);
    }

    @Test
    void 로또결과_5개일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        LottoMatcher result = lotto.result(createLottoNumber(1, 2, 3, 4, 5, 9));

        assertThat(result).isEqualTo(LottoMatcher.SECOND);
    }

    @Test
    void 로또결과_6개일치() {
        Lotto lotto = new Lotto(createLottoNumber(1, 2, 3, 4, 5, 6));
        LottoMatcher result = lotto.result(createLottoNumber(1, 2, 3, 4, 5, 6));

        assertThat(result).isEqualTo(LottoMatcher.FIRST);
    }

    @Test
    void 로또결과_2개_이하_일치() {
        Lotto lotto_matched_2 = new Lotto(createLottoNumber(1, 2, 10, 11, 12, 13));
        Lotto lotto_matched_1 = new Lotto(createLottoNumber(1, 14, 10, 11, 12, 13));
        Lotto lotto_matched_0 = new Lotto(createLottoNumber(15, 14, 10, 11, 12, 13));
        List<LottoNumber> lottoNumber = createLottoNumber(1, 2, 3, 4, 5, 6);

        LottoMatcher result_matched_2 = lotto_matched_2.result(lottoNumber);
        LottoMatcher result_matched_1 = lotto_matched_1.result(lottoNumber);
        LottoMatcher result_matched_0 = lotto_matched_0.result(lottoNumber);

        assertThat(result_matched_2).isEqualTo(LottoMatcher.NOTHING);
        assertThat(result_matched_1).isEqualTo(LottoMatcher.NOTHING);
        assertThat(result_matched_0).isEqualTo(LottoMatcher.NOTHING);
    }

    private static List<LottoNumber> createLottoNumber(
            int number1,
            int number2,
            int number3,
            int number4,
            int number5,
            int number6
    ) {
        return List.of(
                new LottoNumber(number1),
                new LottoNumber(number2),
                new LottoNumber(number3),
                new LottoNumber(number4),
                new LottoNumber(number5),
                new LottoNumber(number6)
        );
    }
}
