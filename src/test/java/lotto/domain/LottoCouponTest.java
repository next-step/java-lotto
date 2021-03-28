package lotto.domain;

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
    assertEquals(lottoCoupon.getLottoCoupon().size(), 10);
  }
}