package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
  @Test
  @DisplayName("생성이 제대로 되는가")
  public void create() throws Exception {
    //given
    //when
    Money money = new Money(1000);
    //then
    assertEquals(money.toInt(), 1000);
  }
}