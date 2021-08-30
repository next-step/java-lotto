package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningInfoTest {

  @Test
  @DisplayName("생성 테스트")
  void createTest() {
    //given
    LottoNumbers winningLottoNumbers = new LottoNumbers(
        Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::valueOf).collect(
            Collectors.toList()));
    LottoNumber bonusLottoNumber = LottoNumber.valueOf(7);

    //when
    WinningInfo winningInfo = new WinningInfo(winningLottoNumbers, bonusLottoNumber);

    //then
    assertThat(winningInfo.winningLottoNumbers()).isEqualTo(winningLottoNumbers);
    assertThat(winningInfo.bonusLottoNumber()).isEqualTo(bonusLottoNumber);
  }

  @Test
  @DisplayName("잘못된 생성 테스트(보너스볼 중복)")
  void invalidCreateTest() {
    //given
    LottoNumbers winningLottoNumbers = new LottoNumbers(
        Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::valueOf)
            .collect(Collectors.toList())
    );
    LottoNumber bonusLottoNumber = LottoNumber.valueOf(3);

    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new WinningInfo(winningLottoNumbers, bonusLottoNumber);
    });
  }
}
