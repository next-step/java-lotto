package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningBoardTest {
  private static List<Integer> list;

  @BeforeEach
  public void setUp() {
    list = new ArrayList<>();
  }

  @ParameterizedTest
  @CsvSource({"3, FOURTH", "4, THIRD", "5, SECOND", "6, FIRST"})
  @DisplayName("구매한 로또 쿠폰에 대한 올바른 당첨 결과에 대한 검증을 제대로 하는가")
  public void validateWinLotto(int winner, String key) throws Exception {
    //given
    list.add(winner);
    WinningBoard lottoResult = WinningBoard.createLottoResult(list, new Money(1000));

    //when
    Map<String, Integer> winningBoard = lottoResult.getWinningBoard();

    //then
    assertEquals((int) winningBoard.get(key), 1);
  }

  @ParameterizedTest
  @CsvSource({"3, 5.0", "4, 50.0", "5, 1500.0", "6, 2000000.0"})
  @DisplayName("구매한 로또 쿠폰에 대한 수익률에 대한 검증을 제대로 하는가")
  public void validateWinLottoEarningRate(int winner, String earningRate) throws Exception {
    //given
    list.add(winner);
    WinningBoard lottoResult = WinningBoard.createLottoResult(list, new Money(1000));

    //when
    lottoResult.calculateEarningRate();

    //then
    assertEquals(lottoResult.calculateEarningRate(), earningRate);
  }
}