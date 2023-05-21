package study.lotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.model.LottoNumber;

public class LottoTest {
  @Test
  @DisplayName("6자리 입력 테스트")
  public void test1 () throws Exception {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoNumber("3, 8, 27, 30, 35, 44, 55");
    });
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoNumber("3, 8, 27, 30, 35");
    });

    new LottoNumber("5, 9, 38, 41, 43, 44");
  }

  @Test
  @DisplayName("로또는 45이하 숫자다.")
  public void test2() throws Exception {

    new LottoNumber("5, 9, 38, 41, 43, 44");

    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoNumber("3, 8, 27, 30, 35, 77");
    });
  }

  @Test
  @DisplayName("중복숫자 허용안한다.")
  public void test3() throws Exception {

    new LottoNumber("5, 9, 38, 41, 43, 44");

    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoNumber("3, 8, 27, 30, 35, 35");
    });
  }
}
