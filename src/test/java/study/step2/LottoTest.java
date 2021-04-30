package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.Lotto;

public class LottoTest {

  @DisplayName("번호를 입력 했을때, lotto 객체를 생성하는지 테스트")
  @Test
  void createLotto() {
    // given
    String inputText = "1, 3, 5, 10, 11, 19";

    // when
    Lotto lotto = new Lotto(inputText);

    // then
    assertThat(lotto).isEqualTo(new Lotto(inputText));
  }

  @DisplayName("번호를 입력하지 않았을 때, 로또 번호가 없는 빈 lotto 객체 생성")
  @Test
  void createLottoFail() {
    // given
    String inputText = "1, 3, 5, 10, 11, 19";

    // when
    Lotto lotto = new Lotto(inputText);

    // then
    assertThat(lotto).isEqualTo(new Lotto(inputText));
  }

  @DisplayName("당첨 번호와 로또 번호가 몇개 맞는지 테스트")
  @Test
  void lottoNumberMatch() {
    // given
    String winningLottoNumbers = "1, 2, 3, 4, 5, 6";
    String pickedLottoNumbers = "1, 2, 3, 4, 5, 6";

    // when
    Lotto pickedLotto = new Lotto(pickedLottoNumbers);
    Lotto winingLotto = new Lotto(winningLottoNumbers);

    // then
    assertThat(winingLotto.matchCount(pickedLotto.getLottoNumbers())).isEqualTo(6);
  }

  @DisplayName("당첨 번호와 로또 번호가 맞지 않는지 테스트")
  @Test
  void lottoNumberMatchFail() {
    // given
    String winningLottoNumbers = "10, 11, 17, 18, 19, 20";
    String pickedLottoNumbers = "1, 2, 3, 12, 15, 16";

    // when
    Lotto pickedLotto = new Lotto(pickedLottoNumbers);
    Lotto winingLotto = new Lotto(winningLottoNumbers);

    // then
    assertThat(winingLotto.matchCount(pickedLotto.getLottoNumbers())).isEqualTo(0);
  }

}
