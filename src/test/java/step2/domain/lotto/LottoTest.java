package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또와 당첨번호의 맞은 갯수 확인")
    @Test
    public void getMatchCount() {
        Lotto numbers = Lotto.createLottoNumbers(() -> Arrays.asList(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6))
                );


        Lotto winningNumbers = Lotto.createLottoNumbers(() -> Arrays.asList(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(33), new LottoNumber(44),
                new LottoNumber(5), new LottoNumber(6))
        );

        assertThat(numbers.getHitCount(winningNumbers.getNumbers())).isEqualTo(4);
    }

    @DisplayName("상금 계산이 올바른지 테스트")
    @Test
    public void prizeTest() {
        Lotto lotto = Lotto.createLottoNumbers(() -> Arrays.asList(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(33), new LottoNumber(44),
                new LottoNumber(5), new LottoNumber(6))
        );

        int prize = lotto.getHitCount(Arrays.asList(1, 2, 33, 7, 9, 11));

        assertThat(prize).isEqualTo(3);
    }
}