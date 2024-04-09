package domain.machine;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.vo.LottoNumber;
import domain.lotto.vo.LottoResult;
import domain.lotto.vo.WinNumbers;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

  LottoMachine lottoMachine;

  @BeforeEach
  void setUp() {
    lottoMachine = new LottoMachine();
  }

  @Test
  @DisplayName("로또 한장을 생성한다")
  void createLotto() {
    int lottoNum = lottoMachine.createLotto(1000);
    assertThat(lottoNum).isEqualTo(1);
  }

  @Test
  @DisplayName("로또 여러장을 생성한다")
  void createLottos() {
    lottoMachine.createLotto(4000);
    assertThat(lottoMachine.getAllLottoList().size()).isEqualTo(4);
  }

  @Test
  @DisplayName("수동 로또를 포함해 여러장을 생성한다")
  void createLottosWithManual() {
    List<LottoNumber> lottoNumbers = List.of(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),LottoNumber.of(4),LottoNumber.of(5),LottoNumber.of(6) );

    lottoMachine.createLotto(5000, List.of(lottoNumbers));
    assertThat(lottoMachine.getAllLottoList().size()).isEqualTo(5);
  }

  @Test
  @DisplayName("로또 결과를 확인한다")
  void getLottoResult() {
    lottoMachine.createLotto(4000);
    LottoResult result = lottoMachine.getLottoResult(new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 10));
    assertThat(result.getMatchedResult()).isNotEmpty();
    assertThat(result.getProfitRate()).isGreaterThanOrEqualTo(0.0);
  }

  @Test
  @DisplayName("수동 로또가 당첨되는지 결과를 확인한다")
  void getLottoResultWithManual() {
    List<LottoNumber> lottoNumbers = List.of(LottoNumber.of(1),LottoNumber.of(2),LottoNumber.of(3),LottoNumber.of(4),LottoNumber.of(5),LottoNumber.of(6) );

    lottoMachine.createLotto(1000, List.of(lottoNumbers));

    LottoResult result = lottoMachine.getLottoResult(new WinNumbers(List.of(1, 2, 3, 4, 5, 6), 10));
    assertThat(result.getMatchedResult()).isNotEmpty();
    assertThat(result.getProfitRate()).isEqualTo(2_000_000);
  }
}
