package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

  @Test
  @DisplayName("생성이 제대로 되는가")
  public void create() throws Exception {
    //given
    WinningNumber winningNumber = WinningNumber
        .createWinningNumbers(
            Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Number(6));
    //when
    //then
    assertNotNull(winningNumber);
  }

  @Test
  @DisplayName("LottoCoupon을 이용하여 매치 로또 결과를 제대로 생성할 수 있는가")
  public void generateLottoResultTest() throws Exception {
    //given
    WinningNumber winningNumber = WinningNumber.createWinningNumbers(
        Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Number(6));

    List<Lotto> lottos = new ArrayList<>();
    lottos.add(Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

    LottoCoupon coupon = new LottoCoupon(lottos);

    //when
    LottoScoreBoard lottoScoreBoard = winningNumber.generateLottoMatchResult(new Money(2000000000), coupon, winningNumber);

    //then
    assertEquals(lottoScoreBoard.totalEarningRate(), 1);
  }

  @Test
  @DisplayName("보너스 볼을 가졌는지 판단할 수 있는가")
  public void hasBonusBall() throws Exception {
    //given
    WinningNumber winningNumber = WinningNumber.createWinningNumbers(
        Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Number(6));

    Lotto manualLotto = Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    //when
    boolean hasBonusBall = winningNumber.hasBonusBall(manualLotto);

    //then
    assertTrue(hasBonusBall);
  }
}