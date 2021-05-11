package study.step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.Lotto;
import study.step2.domain.LottoNumber;
import study.step2.domain.Lottos;

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

  @DisplayName("보너스 번호를 입력했을 때, 뽑은 번호에 포함 되어 있는지 테스트")
  @Test
  void matchBonusNumberTest() {
    // given
    String pickedLottoNumbers = "10, 11, 17, 18, 19, 16";

    LottoNumber bonusNumber = new LottoNumber(16);
    Lotto pickedLotto = new Lotto(pickedLottoNumbers);

    // when
    boolean isMatchBonus = pickedLotto.isMatchBonus(bonusNumber);

    // then
    assertThat(isMatchBonus).isTrue();
  }

  @DisplayName("보너스 번호를 입력했을 때, 뽑은 번호에 포함이 안되어 있는지 테스트")
  @Test
  void matchBonusNumberFailTest() {
    // given
    String pickedLottoNumbers = "10, 11, 17, 18, 19, 16";

    LottoNumber bonusNumber = new LottoNumber(22);
    Lotto pickedLotto = new Lotto(pickedLottoNumbers);

    // when
    boolean isMatchBonus = pickedLotto.isMatchBonus(bonusNumber);

    // then
    assertThat(isMatchBonus).isFalse();
  }

  @DisplayName("구매 금액을 입력 후 복권의 수 만큼  lottos 객체를 셍성하는지 테스트")
  @Test
  void makeLottos() {
    // given
    int lottoCount = 3;

    // when
    Lottos lottos = Lotto.makeLottos(lottoCount);

    // then
    assertThat(lottos).isEqualTo(new Lottos(lottos.getLottos()));
  }

  @DisplayName("구매 금액을 0으로 입력했을 때, lotto 객체 크기가 0인지 테스트")
  @Test
  void makeLottosFail() {
    // given
    int lottoCount = 0;

    // when
    Lottos lottos = Lotto.makeLottos(lottoCount);

    // then
    assertThat(lottos).isEqualTo(new Lottos(new ArrayList<>()));
  }

}
