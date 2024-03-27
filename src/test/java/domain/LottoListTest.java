package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    List<Integer> numbers = lottoList.getLottoNumbers().get(0).getNumbers();
    Map<Integer, Integer> lottoResult = lottoList.getLottoResult(new HashSet<>(numbers));
    assertThat(lottoResult.containsKey(6)).isTrue();
  }
}
