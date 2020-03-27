package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @DisplayName("로또 번호로 로또 번호들을 만들 수 있다.")
    @Test
    public void test() {
        LottoNumber game1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber game2 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoNumbers lottoNumbers = new LottoNumbers(game1, game2);

        assertThat(lottoNumbers.size()).isEqualTo(2);
    }

    @DisplayName("당첨 번호를 입력하면 각 로또 번호중 일치하는 번호의 개수를 반환한다.")
    @Test
    public void test2() {
        LottoNumber game1 = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber game2 = new LottoNumber(Arrays.asList(7, 8, 9, 10, 11, 12));
        LottoNumbers lottoNumbers = new LottoNumbers(game1, game2);

        LottoNumber winningNumber = new LottoNumber(Arrays.asList(5, 6, 7, 8, 9, 10));
        List<Long> lottoGameResult = lottoNumbers.checkWinningNumber(winningNumber);

        assertThat(lottoGameResult).hasSize(2);
        assertThat(lottoGameResult.get(0)).isEqualTo(2);
        assertThat(lottoGameResult.get(1)).isEqualTo(4);
    }

}
