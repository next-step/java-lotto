package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

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
  @DisplayName("로또 매칭 결과를 제대로 생성할 수 있는가")
  public void generateLottoResultTest() throws Exception {
    //given
    WinningNumber winningNumber = WinningNumber.createWinningNumbers(
        Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Number(6));

    LottoAgency agency = new LottoAgency(new Money(14000));

    //when
    LottoScoreBoard lottoScoreBoard = winningNumber.generateLottoMatchResult(winningNumber, agency);

    //then
    assertNotNull(lottoScoreBoard);
  }
}