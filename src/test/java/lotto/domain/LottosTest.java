package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottosTest {

    @Test
    void 당첨_로또에따른_결과_리스트를_반환() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"),
                new Lotto("1, 2, 3, 4, 5, 8"),
                new Lotto("1, 2, 3, 4, 7, 8"),
                new Lotto("1, 2, 3, 7, 8, 9"),
                new Lotto("7, 8, 9, 10, 11, 12")
        ));

        Lotto winning = new Lotto("1, 2, 3, 4, 5, 6");

        LottoNumber bonus = new LottoNumber(7);

        assertThat(lottos.getResults(winning, bonus)).isEqualTo(Arrays.asList(
                LottoResult.FIRST_PRIZE,
                LottoResult.SECOND_PRIZE,
                LottoResult.THIRD_PRIZE,
                LottoResult.FOURTH_PRIZE,
                LottoResult.FIFTH_PRIZE,
                LottoResult.NO_MATCH
        ));
    }



    @Test
    void 원하는_갯수만큼_로또번호를_발행() {
        assertThat(new Lottos(2).getSize()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "1990,1", "1999,1", "2001,2"})
    void 로또_금액에_따라_로또_발급횟수를_계산(int money, int terms) {
        assertThat(Lottos.buyLottos(money).getSize()).isEqualTo(terms);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 1, 3, 0})
    void 천원_이하에_돈이_입력되면_오류를_출력(int money) {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    Lottos.buyLottos(money);
                });
    }
}
