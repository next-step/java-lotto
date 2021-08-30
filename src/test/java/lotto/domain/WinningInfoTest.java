package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningInfoTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    int[] numbers = {1, 2, 3, 4, 5, 6};
    int bonusNumber = 7;

    //when
    WinningInfo winningInfo = new WinningInfo(numbers, bonusNumber);

    //then
    assertThat(winningInfo.winningLottoNumbers()).isEqualTo(new LottoNumbers(numbers));
    assertThat(winningInfo.bonusLottoNumber()).isEqualTo(LottoNumber.valueOf(7));
  }

  @Test
  @DisplayName("잘못된 생성 테스트(보너스볼 중복)")
  void invalidCreateTest() {
    //given
    int[] numbers = {1, 2, 3, 4, 5, 6};
    int bonusNumber = 3;

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new WinningInfo(numbers, bonusNumber);
    });
  }
}
