package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Test;

public class LottoIssueTest {

  @Test
  public void test_issued_by_inputMoney() {

    // Given
    int purchaseAmount = 14000;

    // When
    List<Lotto> lottoList = LottoVendingMachine.issue(purchaseAmount);

    // Then
    assertThat(lottoList.size()).isEqualTo(14);
  }
}
