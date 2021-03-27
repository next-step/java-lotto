package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallMachineTest {

  private static LottoBallMachine lottoBallMachine;

  @BeforeAll
  static void setUp() {
    lottoBallMachine = new LottoBallMachine();
    lottoBallMachine.initialize();
  }

  @DisplayName("서로다른 6개의 공을 뽑아야 한다.")
  @Test
  void draw() {
    List<LottoBall> drawResult = lottoBallMachine.draw();
    assertThat(drawResult.size()).isEqualTo(6);
    assertThat(drawResult).doesNotHaveDuplicates();
  }

}