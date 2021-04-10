package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
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
  @DisplayName("2등 당첨 여부 확인")
  public void match() throws Exception {
    //given
    WinningNumber winningNumber = WinningNumber.createWinningNumbers(
        Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
        new Number(6));

    Lotto manualLotto = Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    //then
    LottoRank rank = winningNumber.match(manualLotto);
    assertEquals(rank, LottoRank.SECOND);
  }
}