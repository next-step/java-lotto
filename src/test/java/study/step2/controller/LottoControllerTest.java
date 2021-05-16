package study.step2.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2.domain.Lotto;
import study.step2.domain.LottoNumber;
import study.step2.domain.LottoResult;
import study.step2.domain.Lottos;
import study.step2.domain.Rank;
import study.step2.domain.WinningLotto;

public class LottoControllerTest {

  @DisplayName("구매 금액을 입력 후 복권의 수 만큼  lottos 객체를 셍성하는지 테스트")
  @Test
  void createLottos() {
    // given
    int money = 3000;
    int lottoCount = 3;
    int manualLottosCount = 0;

    LottoController lottoController = new LottoController();

    // when
    Lottos lottos = lottoController.createLottos(money, manualLottosCount);

    // then
    assertThat(lottos.getLottos().size()).isEqualTo(lottoCount);
  }

  @DisplayName("구매 금액을 0으로 입력했을 때, lottos 객체 크기가 0인지 테스트")
  @Test
  void createLottosFail() {
    // given
    int money = 0;
    int lottoCount = 0;
    int manualLottosCount = 0;

    LottoController lottoController = new LottoController();

    // when
    Lottos lottos = lottoController.createLottos(money, manualLottosCount);

    // then
    assertThat(lottos.getLottos().size()).isEqualTo(lottoCount);
  }

  @DisplayName("구매 금액, 로또 번호와 당첨 금액을 입력했을때, 당첨 결과가 null이 아닌지 테스트")
  @Test
  void findLottoWinning() {
    // given
    int money = 1000;

    LottoNumber bonusNumber = new LottoNumber(19);

    String pickedLottoNumbers = "1, 2, 3, 12, 15, 16";

    WinningLotto winingLotto = new WinningLotto(pickedLottoNumbers);
    Lottos lottos = new Lottos(new ArrayList<>(Collections.singletonList(new Lotto(pickedLottoNumbers))));

    LottoController lottoController = new LottoController();

    // when
    LottoResult lottoResult = lottoController.findLottoWinning(lottos, winingLotto, money, bonusNumber);

    // then
    assertThat(lottoResult).isNotNull();
  }

  @DisplayName("번호를 다 맞췄을 때, 1등인지 테스트")
  @Test
  void findLottoWinningFirst() {
    // given
    int money = 1000;
    LottoNumber bonusNumber = new LottoNumber(19);

    String pickedLottoNumbers = "1, 2, 3, 12, 15, 16";

    WinningLotto winingLotto = new WinningLotto(pickedLottoNumbers);
    Lottos lottos = new Lottos(new ArrayList<>(Collections.singletonList(new Lotto(pickedLottoNumbers))));

    LottoController lottoController = new LottoController();

    // when
    LottoResult lottoResult = lottoController.findLottoWinning(lottos, winingLotto, money, bonusNumber);

    // then
    assertThat(lottoResult.getValue(Rank.FIRST)).isEqualTo(1);
  }

  @DisplayName("번호를 5개 맞추고 보너스 번호까지 맞췄을 경우 2등인지 테스트")
  @Test
  void findLottoWinningSecondWithBonus() {
    // given
    int money = 1000;

    String pickedLottoNumbers = "1, 2, 3, 12, 15, 16";
    String winingLottoNumbers = "1, 2, 3, 12, 15, 19";

    LottoNumber bonusNumber = new LottoNumber(16);

    WinningLotto winingLotto = new WinningLotto(winingLottoNumbers);
    Lottos lottos = new Lottos(new ArrayList<>(Collections.singletonList(new Lotto(pickedLottoNumbers))));

    LottoController lottoController = new LottoController();

    // when
    LottoResult lottoResult = lottoController.findLottoWinning(lottos, winingLotto, money, bonusNumber);

    // then
    assertThat(lottoResult.getValue(Rank.SECOND)).isEqualTo(1);
  }

  @DisplayName("당첨번호와 보너스 번호가 동일한 번호가 있을 경우 에러 테스트")
  @Test
  void findLottoWinningSecondWithBonusFail() {
    // given
    int money = 1000;

    String pickedLottoNumbers = "1, 2, 3, 12, 15, 16";
    String winingLottoNumbers = "1, 2, 3, 12, 15, 19";

    LottoNumber bonusNumber = new LottoNumber(19);

    WinningLotto winingLotto = new WinningLotto(winingLottoNumbers);
    Lottos lottos = new Lottos(new ArrayList<>(Collections.singletonList(new Lotto(pickedLottoNumbers))));

    LottoController lottoController = new LottoController();

    // when
    Throwable thrown =  catchThrowable(() -> lottoController.findLottoWinning(lottos, winingLotto, money, bonusNumber));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);

  }

}
