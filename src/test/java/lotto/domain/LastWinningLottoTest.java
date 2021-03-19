package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LastWinningLottoTest {

  @Test
  @DisplayName("보너스볼이랑 현재 로또 넘버가 일치하는지 확인")
  public void matchBonusBall() {
    LastWinningLotto lastWinningLotto = LastWinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 4);
    LottoNumber lottoNumber = new LottoNumber(4);
    assertEquals(true, lastWinningLotto.matchBonusBall(lottoNumber));
  }

  @Test
  @DisplayName("지난주 로또와 현재 로또 넘버가 일치하는 값이 있는지 확인")
  public void contains() {
    LastWinningLotto lastWinningLotto = LastWinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 4);
    LottoNumber lottoNumber = new LottoNumber(5);
    assertEquals(true, lastWinningLotto.contains(lottoNumber));
  }
}
