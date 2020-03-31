package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    private ResultView resultView;

    @BeforeEach
    void setUp() {
        String input = "1,2,3,4,5,6";
        int bonusBall = 42;
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumbers(new HashSet<>(Stream.of(new LottoNo(1),
                                                                  new LottoNo(2),
                                                                  new LottoNo(3),
                                                                  new LottoNo(4),
                                                                  new LottoNo(5),
                                                                  new LottoNo(6))
                                                              .collect(Collectors.toSet())))); //1등

        lottoNumbers.add(new LottoNumbers(new HashSet<>(Stream.of(new LottoNo(1),
                                                                  new LottoNo(2),
                                                                  new LottoNo(3),
                                                                  new LottoNo(34),
                                                                  new LottoNo(35),
                                                                  new LottoNo(45))
                                                              .collect(Collectors.toSet()))));//5등

        lottoNumbers.add(new LottoNumbers(new HashSet<>(Stream.of(new LottoNo(2),
                                                                  new LottoNo(3),
                                                                  new LottoNo(4),
                                                                  new LottoNo(5),
                                                                  new LottoNo(35),
                                                                  new LottoNo(42))
                                                              .collect(Collectors.toSet())))); //4등

        lottoNumbers.add(new LottoNumbers(new HashSet<>(Stream.of(new LottoNo(2),
                                                                  new LottoNo(3),
                                                                  new LottoNo(4),
                                                                  new LottoNo(5),
                                                                  new LottoNo(6),
                                                                  new LottoNo(42))
                                                              .collect(Collectors.toSet()))));// 2등

        lottoNumbers.add(new LottoNumbers(new HashSet<>(Stream.of(new LottoNo(21),
                                                                  new LottoNo(22),
                                                                  new LottoNo(23),
                                                                  new LottoNo(24),
                                                                  new LottoNo(25),
                                                                  new LottoNo(26))
                                                              .collect(Collectors.toSet()))));//꽝

        lottoNumbers.add(new LottoNumbers(new HashSet<>(Stream.of(new LottoNo(2),
                                                                  new LottoNo(22),
                                                                  new LottoNo(23),
                                                                  new LottoNo(24),
                                                                  new LottoNo(25),
                                                                  new LottoNo(26))
                                                              .collect(Collectors.toSet()))));//꽝

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        resultView = new ResultView(input, lottoTicket, bonusBall);

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
        Map<String, WinningLotto> winningLottos = resultView.getWinningLottos();

        assertThat(winningLottos).hasSize(4);
    }

    @DisplayName("당첨 내역을 출력한다")
    @Test
    void printWinningResult() {
        String result = resultView.printWinningResult();
        System.out.println(result);
        assertThat(result).isEqualTo("당첨통계\n"
                                     + "---------\n"
                                     + "3개 일치(5000원)- 1개\n"
                                     + "4개 일치(50000원)- 1개\n"
                                     + "5개 일치(1500000원)- 0개\n"
                                     + "5개 일치, 보너스 볼 일치(30000000원)- 1개\n"
                                     + "6개 일치(2000000000원)- 1개\n");
    }

    @DisplayName("총 구매금액을 계산한다")
    @Test
    void totalPurchaseAmount() {
        int result = resultView.totalPurchaseAmount();
        assertThat(result).isEqualTo(6000);
    }

    @DisplayName("총 당첨금액을 계산한다")
    @Test
    void totalWinningAmount() {
        int result = resultView.totalWinningAmount();
        assertThat(result).isEqualTo(2030055000);
    }

    @DisplayName("총 수익률을 계산한다.")
    @Test
    void calculateRevenuePercent() {
        double result = resultView.calculateRevenuePercent(5000, 14000);
        assertThat(result).isEqualTo(0.35);
    }

    @DisplayName("보너스 볼에 유효성을 검사한다. 1~45 사이가 아닐때는 예외처리")
    @Test
    void validateBonusBall() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            resultView = new ResultView(46);
        });
    }

    @DisplayName("구매한 로또티켓에 보너스 볼이 있는지 확인한다.")
    @Test
    void checkMatchBonusBall() {
        resultView = new ResultView(5);
        boolean match = resultView.checkMatchBonusBall(new HashSet<>(Stream.of(new LottoNo(1),
                                                                               new LottoNo(2),
                                                                               new LottoNo(3),
                                                                               new LottoNo(4),
                                                                               new LottoNo(5),
                                                                               new LottoNo(6))
                                                                           .collect(Collectors.toSet())));

        assertThat(match).isTrue();
    }
}
