package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoCouponTest {

  @Test
  @DisplayName("수량을 입력해서 LottoCoupon을 생성할 수 있는가")
  public void create() throws Exception {
    //given
    //when
    LottoCoupon lottoCoupon = LottoCoupon.createLottoCoupon(10);
    //then
    assertEquals(lottoCoupon.size(), 10);
  }

  @Test
  @DisplayName("List<Lotto>를 받아서 LottoCoupon으로 생성할 수 있는가")
  public void lottosToLottoCoupon() throws Exception {
    //given
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(Lotto.createAutoLotto());
    //when
    LottoCoupon lottoCoupon = LottoCoupon.asLottoCoupon(lottos);
    //then
    assertNotNull(lottoCoupon);
  }

  @Test
  @DisplayName("여러 로또의 매치 결과를 얻을 수가 있는가")
  public void matches() throws Exception {
    //given
    List<Lotto> lottos = new ArrayList<>();
    lottos.add(Lotto.createManualLotto(Arrays.asList(1,2,3,4,5,6)));
    lottos.add(Lotto.createManualLotto(Arrays.asList(3,4,5,6,7,8)));

    WinningNumber winningNumbers = WinningNumber
        .createWinningNumbers(Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Number(7));

    //when
    LottoCoupon lottoCoupon = LottoCoupon.asLottoCoupon(lottos);
    List<LottoRank> matches = lottoCoupon.matches(winningNumbers);

    //then
    assertAll(
        () -> assertEquals(matches.get(0).name(), "FIRST"),
        () -> assertEquals(matches.get(1).name(), "FOURTH")
    );
  }

  @Test
  @DisplayName("size()를 통해서 LottoCoupon의 size를 알아낼 수 있는가")
  public void size() throws Exception {
    //given
    LottoCoupon lottoCoupon = LottoCoupon.createLottoCoupon(10);

    //when
    //then
    assertEquals(lottoCoupon.size(), 10);
  }

  @Test
  @DisplayName("기존 LottoCoupon에 새로운 LottoCoupon을 추가할 수 있는가")
  public void add() throws Exception {
    //given
    List<Lotto> lottos = new ArrayList<>();
    Lotto manualLotto = Lotto.createManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    lottos.add(manualLotto);

    LottoCoupon lottoCoupon = LottoCoupon.createLottoCoupon(10);

    //when
    LottoCoupon target = LottoCoupon.asLottoCoupon(lottos);
    lottoCoupon.add(target);
    //then
    assertTrue(lottoCoupon.contains(manualLotto));
  }
}