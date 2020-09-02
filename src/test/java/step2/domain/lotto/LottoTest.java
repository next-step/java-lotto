package step2.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.util.ManualLottoNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @DisplayName("로또와 당첨번호의 맞은 갯수 확인")
    @Test
    public void getMatchCount() {
        Lotto numbers = Lotto.createLottoNumbers(it -> Arrays.asList(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6))
                );


        Lotto winningNumbers = Lotto.createLottoNumbers(it -> Arrays.asList(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(33), new LottoNumber(44),
                new LottoNumber(5), new LottoNumber(6))
        );

        assertThat(numbers.getHitCount(winningNumbers.getNumbers())).isEqualTo(4);
    }

    @DisplayName("상금 계산이 올바른지 테스트")
    @Test
    public void prizeTest() {
        Lotto lotto = Lotto.createLottoNumbers(it -> Arrays.asList(
                new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(33), new LottoNumber(44),
                new LottoNumber(5), new LottoNumber(6))
        );

        int prize = lotto.getHitCount(Arrays.asList(1, 2, 33, 7, 9, 11));

        assertThat(prize).isEqualTo(3);
    }

    @DisplayName("수동 로또 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,3,5,7,9,45", "45,9,7,5,3,1"})
    public void manual_Lotto(String input) {
        Lotto lotto = Lotto.createLottoNumbers(input, new ManualLottoNumberGenerator());

        assertThat(lotto.getNumbers()).containsExactly(1,3,5,7,9,45);
    }
}