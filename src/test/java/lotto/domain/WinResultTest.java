package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class WinResultTest {

  @Test
  public void test_reward() {

    // Given
    WinMoney winMoney = WinMoney.FOUR;
    long winCount = 3;

    WinResult winResult = new WinResult(winMoney, winCount);

    // When
    Money reward = winResult.reward();

    // Then
    assertThat(reward).isNotNull();
    assertThat(reward).isEqualTo(new Money(50_000 * winCount));
  }

  @Test
  public void test_reward_zero() {

    // Given
    WinMoney winMoney = WinMoney.FOUR;
    long winCount = 0;

    WinResult winResult = new WinResult(winMoney, winCount);

    // When
    Money reward = winResult.reward();

    // Then
    assertThat(reward).isNotNull();
    assertThat(reward).isEqualTo(new Money(0));
  }

}