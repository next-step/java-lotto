package lottogame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    @Test
    void 로또번호_포함_O() {
        Numbers numbers = Numbers.fromIntegers(List.of(1,2,3,4,5,6));
        Lottos lotto = LottoFactory.createLotto(numbers);
        LottoNumber lottoNumber = new LottoNumber(5);

        assertThat(lotto.match(lottoNumber)).isTrue();
    }

    @Test
    void 로또번호_포함_X() {
        Numbers numbers = Numbers.fromIntegers(List.of(1,2,3,4,5,6));
        Lottos lotto = LottoFactory.createLotto(numbers);
        LottoNumber lottoNumber = new LottoNumber(7);

        assertThat(lotto.match(lottoNumber)).isFalse();
    }
}