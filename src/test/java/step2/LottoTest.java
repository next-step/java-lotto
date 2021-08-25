package step2;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.Lotto.Lotto;

public class LottoTest {

  @Test
  public void Lotto_1개_구매() {
    List lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    Lotto lotto = new Lotto(lottoNumber);

    assertThat(lotto.getLottoNumbers()).isEqualTo(lottoNumber);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1,2,3,4,5,6", "10,20,30,40,45"})
  public void Lotto_N개_구매(String lottoNumStr) {

    String[] lottoNumStrs = lottoNumStr.split(",");
    List lottoNumber = Arrays.asList(lottoNumStrs);
    Lotto lotto = new Lotto(lottoNumber);

    assertThat(lotto.getLottoNumbers()).isEqualTo(lottoNumber);
  }
}
