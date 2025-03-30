package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {
  @DisplayName("로또 번호 일치 갯수 구하는 테스트")
  @Test
  void testCountMatchingNumbers() {
    Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            )),
            new Lotto(List.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ))
    ));

    WinningLotto winningLotto = new WinningLotto(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    ), new LottoNumber(7));

    List<Integer> matchingNumbers = lottos.countMatchingNumbers(winningLotto);
    assertEquals(List.of(6, 6), matchingNumbers);
  }

  @DisplayName("로또 보너스 일치 여부 구하는 테스트")
  @Test
  void testCountMatchingBonus() {
    Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            )),
            new Lotto(List.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ))
    ));

    WinningLotto winningLotto = new WinningLotto(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    ), new LottoNumber(7));

    List<Boolean> matchingBonus = lottos.countMatchingBonus(winningLotto);
    assertEquals(List.of(false, false), matchingBonus);
  }
}
