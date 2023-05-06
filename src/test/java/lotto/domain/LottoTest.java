package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    Lotto myLotto, winningLotto;

    @BeforeEach
    void setUp() {
        myLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 43, 44, 45));
    }

    @Test
    void Lotto_생성() {
        assertThat(myLotto.value()).contains(new LottoNumber(1), new LottoNumber(6));
    }

    @Test
    void Lotto_생성_사이즈_예외() {
        assertThatThrownBy(() -> new Lotto(
                Stream.of(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5)
                ).collect(Collectors.toSet())))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("로또 번호의 개수는 6개여야 합니다.");
    }

    @Test
    void 로또_번호와_당첨_번호_일치_개수_계산() {
        assertThat(myLotto.matchCount(winningLotto))
                .isEqualTo(3);
    }
}
