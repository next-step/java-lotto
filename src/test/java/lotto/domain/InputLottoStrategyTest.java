package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputLottoStrategyTest {
  @Test
  @DisplayName("로또 번호 입력 시 로또 번호들을 담은 List 객체 반환 테스트")
  public void issue_직접_입력() {
    LottoStrategy inputLottoStrategy = new InputLottoStrategy(List.of(1, 4, 5, 6, 2, 8));
    assertThat(inputLottoStrategy.issue())
            .isEqualTo(new ArrayList<LottoNumber>(List.of(
                    new LottoNumber(1),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6),
                    new LottoNumber(2),
                    new LottoNumber(8))));
  }

  @ParameterizedTest(name = "로또 번호가 아닌 번호 입력 시 IllegalArgumentException throw")
  @ValueSource(ints = {0, 46})
  public void issue_로또_번호_아닌_수자_입력(int input) {
    LottoStrategy inputLottoStrategy = new InputLottoStrategy(List.of(6, 3, 1, 7, 4, input));
    assertThatThrownBy(() -> inputLottoStrategy.issue())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바른 로또 번호를 입력해주세요. 입력된 번호 : " + input);
  }
}
