package lotto.dto;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class OrderSheetTest {

  @DisplayName("로또 1장 가격(1000원) 이상의 금액을 입력해야 한다.")
  @Test
  void leakOfPurchasingAmountTest() {
    List<List<Integer>> emptyManual = Collections.emptyList();
    assertAll(
        () -> assertThatThrownBy(() -> OrderSheet.of(999, emptyManual)).isInstanceOf(IllegalArgumentException.class),
        () -> assertThat(OrderSheet.of(1000, Collections.emptyList())).isNotNull()
    );

  }

  @DisplayName("수동 구매하는 갯수가 금액으로 살 수 있는 총 로또 갯수보다 크면 안된다.")
  @Test
  void ManualCountOverTotalCountTest() {
    List<List<Integer>> manualNumbers = Lists.list(Lists.newArrayList(1, 2, 3, 4, 5, 6), Lists.newArrayList(2, 4, 6, 8, 10, 12));
    assertAll(
        () -> assertThatThrownBy(() -> OrderSheet.of(1000, manualNumbers)).isInstanceOf(IllegalArgumentException.class),
        () -> assertThat(OrderSheet.of(2000, manualNumbers)).isNotNull()
    );
  }

}
