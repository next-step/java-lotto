import static org.assertj.core.api.Assertions.*;

import domain.lotto.LottoPieces;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPiecesTest {

  @Test
  @DisplayName("20000원 지불시 20장 구매")
  void testLottoAmount() {
    LottoPieces lottoPieces = new LottoPieces(20000);
    assertThat(lottoPieces.pieces).isEqualTo(20);
  }

  @Test
  @DisplayName("1000원 단위금액 외 지불시 예외발생")
  void testPaymentValidation() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
        () -> {
          new LottoPieces(1100);
        }
    );
  }
}
