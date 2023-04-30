package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

  private static final int TEST_NUMBER = 6;

  @Test
  @DisplayName("입력한 수 만큼 LottoNumber를 가져온다")
  void lottoNumberCountTest() {
    List<LottoNumber> pick = LottoNumbers.pick(TEST_NUMBER);

    assertThat(pick).hasSize(TEST_NUMBER);
  }

  @Test
  @DisplayName("같은 타입의 요청이라면 같은 LottoNumber 객체를 가져온다")
  void lottoNumberSameAddressTest() {
    List<LottoNumber> pickFirst = LottoNumbers.pick(TEST_NUMBER);
    List<LottoNumber> pickSecond = LottoNumbers.pick(TEST_NUMBER);

    assertThat(pickFirst).isNotIn(pickSecond);

    for (int i = 0; i < TEST_NUMBER; i++) {
      assertThat(pickFirst.get(i)).isSameAs(pickSecond.get(i));
    }
  }
}