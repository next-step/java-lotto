package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    private ResultView resultView;

    @BeforeEach
    void setUp() {
        String input = "1,2,3,4,5,6";
        List<LottoNumber> purchaseLottoNumbers = Arrays.asList(
                new LottoNumber(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                new LottoNumber(new HashSet<>(Arrays.asList(1, 2, 3, 34, 35, 45))),
                new LottoNumber(new HashSet<>(Arrays.asList(2, 3, 4, 5, 35, 42))),
                new LottoNumber(new HashSet<>(Arrays.asList(2, 3, 4, 5, 6, 42))),
                new LottoNumber(new HashSet<>(Arrays.asList(22, 23, 24, 25, 35, 42))),
                new LottoNumber(new HashSet<>(Arrays.asList(2, 23, 24, 25, 35, 42)))
        );
        resultView = new ResultView(input, purchaseLottoNumbers);

    }

    @DisplayName("당첨번호를 입력 받고 유효성을 체크한다. 동일 숫자가 입력되는 경우")
    @Test
    void inputWinningNumbers() {
        String errorInput = "1,2,2,3,4,5";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            resultView = new ResultView(errorInput);
        });

    }

    @DisplayName("당첨된 로또의 개수를 확인한다")
    @Test
    void winningResultSize() {
        Map<Integer, WinningLotto> winningLottos = resultView.getWinningLottos();

        assertThat(winningLottos).hasSize(4);
    }

    @DisplayName("당첨 내역을 출력한다")
    @Test
    void printWinningResult() {
        String result = resultView.printWinningResult();
        assertThat(result).isEqualTo("3개 일치(5000원)- 1개\n"
                                     + "4개 일치(50000원)- 1개\n"
                                     + "5개 일치(1500000원)- 1개\n"
                                     + "6개 일치(2000000000원)- 1개\n");
    }

}
