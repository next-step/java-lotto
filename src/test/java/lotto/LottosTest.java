package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottosTest {
  @DisplayName("로또 갯수 구하는 테스트")
  @Test
  void testGetCount() {
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

    int count = lottos.getCount();
    assertEquals(2, count);
  }

  @DisplayName("로또 목록으로부터 당첨 로또와 비교하여 일치: 갯수 구하는 테스트")
  @Test
  void testCalculatePrize() {
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
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6),
                    new LottoNumber(7)
            ))
    ));

    Lotto winningLotto = new Lotto(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    ));

    Map<LottoPrize, Integer> actual = lottos.calculatePrize(winningLotto);
    assertEquals(1, actual.get(LottoPrize.SIX_MATCHES));
    assertEquals(1, actual.get(LottoPrize.FIVE_MATCHES));
    assertEquals(0, actual.get(LottoPrize.FOUR_MATCHES));
    assertEquals(0, actual.get(LottoPrize.THREE_MATCHES));
    assertEquals(4, actual.size());
  }
}
