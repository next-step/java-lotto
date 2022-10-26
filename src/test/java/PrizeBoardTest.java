import domain.prizeBoard.PrizeBoardMapping;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeBoardTest {

  @Test
  @DisplayName("3개 일치 시 5000원")
  void checkMatch3() {
    int prize = PrizeBoardMapping.getPrize(3);
    Assertions.assertThat(prize).isEqualTo(5000);
  }

  @Test
  @DisplayName("4개 일치 시 50000원")
  void checkMatch4() {
    int prize = PrizeBoardMapping.getPrize(4);
    Assertions.assertThat(prize).isEqualTo(50000);
  }

  @Test
  @DisplayName("5개 일치 시 1500000원")
  void checkMatch5() {
    int prize = PrizeBoardMapping.getPrize(5);
    Assertions.assertThat(prize).isEqualTo(1500000);
  }

  @Test
  @DisplayName("5개 일치 시 2000000000원")
  void checkMatch6() {
    int prize = PrizeBoardMapping.getPrize(6);
    Assertions.assertThat(prize).isEqualTo(2000000000);
  }
}
