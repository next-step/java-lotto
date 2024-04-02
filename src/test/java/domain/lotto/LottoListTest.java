package domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import domain.lotto.vo.LottoNumber;
import domain.lotto.vo.WinNumbers;
import domain.machine.LottoNumberGenerator;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoListTest {

  LottoList lottoList;

  @BeforeEach
  void setUp() {
    lottoList = new LottoList(new LottoNumberGenerator(), 10);
  }


  @Test
  @DisplayName("생성된 로또 갯수가 맞는지 확인한다")
  void createLotto() {
    assertThat(lottoList.getLottoNumbers().size()).isEqualTo(10);
    assertThat(lottoList.getLottoCount()).isEqualTo(10);
  }

  @Test
  @DisplayName("지난주 결과가 첫 번째 로또와 동일 할 때 카운트가 6인것을 반환한다")
  void matchFirstWin() {
    Set<LottoNumber> numbers = lottoList.getLottoNumbers().get(0).getNumbers();
    Map<Integer, Integer> lottoResult = lottoList.getLottoResult(new WinNumbers(numbers,  LottoNumber.of(1)));
    assertThat(lottoResult.containsKey(6)).isTrue();
  }
}
