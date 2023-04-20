package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoStrategyTest {

  private LottoStrategy randomLottoStrategy;

  @BeforeEach
  public void setUp() {
    randomLottoStrategy = new RandomLottoStrategy();
  }

  @Test
  @DisplayName("랜던 로또 번호를 6개 반환하는지 테스트")
  public void create_로또번호_개수() {
    assertThat(randomLottoStrategy.issue())
            .hasSize(6);
  }

  @Test
  @DisplayName("랜덤 로또 번호 생성 시 1 이상 45 이하인지 테스트")
  public void create_로또번호_숫자() {
    assertThat(randomLottoStrategy.issue().get(0).number())
            .isBetween(1, 45);
  }
}
