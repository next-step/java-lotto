package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("로또가격은 1000원, 가지고 있는 금액만큼 로또를 구입한다")
    @Test
    void 금액만큼_로또구입() {
        Lottos lottos = new Lottos(10000);
        assertThat(lottos.numberOfLotto()).isEqualTo(10);
    }

    @DisplayName("로또가격보다 적은 구입금액 입력시 예외")
    @Test
    void 잔액부족() {
        assertThatThrownBy(() -> new Lottos(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잔액이 부족합니다.");
    }

    @DisplayName("")
    @Test
    void result_당첨결과() {
        Lottos lottos = new Lottos(createLottos());
        Lotto winningNumbers = createLotto(new int[]{3,6,9,12,15,2});
        LottoResult result = lottos.result(winningNumbers);

        assertThat(result.numberOfLotto(3)).isEqualTo(1);
    }

    private static List<Lotto> createLottos() {
        return Arrays.asList(
                createLotto(new int[]{1, 2, 3, 4, 5, 6}),
                createLotto(new int[]{6, 7, 8, 9, 10, 11}),
                createLotto(new int[]{12, 13, 14, 15, 16, 17}),
                createLotto(new int[]{20, 25, 30, 25, 40, 45}));
    }

    private static Lotto createLotto(int[] ints) {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(ints[0]),
                new LottoNumber(ints[1]),
                new LottoNumber(ints[2]),
                new LottoNumber(ints[3]),
                new LottoNumber(ints[4]),
                new LottoNumber(ints[5]));

        return new Lotto(lottoNumbers);
    }
}
