package lotto.domain;

import static lotto.domain.LottoNumbers.pick;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

  List<LottoNumber> lastWeekNumbers = List.of(pick("1"), pick("2"),
      pick("3"), pick("4"), pick("5"), pick("6"));

  @Test
  @DisplayName("지난주 당첨 번호에 BonusNumber가 포함된다면 예외가 발생한다")
  void bonusNumberDuplicateTest() {
    assertThatThrownBy(() -> new BonusNumber(pick("1")).validateLastWeekDuplicate(lastWeekNumbers))
        .isInstanceOf(IllegalArgumentException.class);
  }
}