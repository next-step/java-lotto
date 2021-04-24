package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.Lotto;
import study.step2.domain.LottoNumbers;

public class LottoTest {

  @DisplayName("번호를 입력 했을때, lotto 객체를 생성하는지 테스트")
  @Test
  void createLotto() {
    // given
    List<Integer> pickedLottoNumbers = LottoNumbers.pick();

    // when
    Lotto lotto = new Lotto(pickedLottoNumbers);

    // then
    assertThat(lotto).isEqualTo(new Lotto(pickedLottoNumbers));
  }

  @DisplayName("번호를 입력하지 않았을 때, 로또 번호가 없는 빈 lotto 객체 생성")
  @Test
  void createLottoFail() {
    // given
    List<Integer> pickedLottoNumbers = new ArrayList<>();

    // when
    Lotto lotto = new Lotto(pickedLottoNumbers);

    // then
    assertThat(lotto).isEqualTo(new Lotto(pickedLottoNumbers));
  }

}
