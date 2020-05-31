package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.collections.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PurchaseServiceTest {

  PurchaseService purchaseService;

  @BeforeEach
  void setUp() {
    purchaseService = new PurchaseService();
  }

  @DisplayName("구입금액을 입력했을 때 1000으로 나누어 로또가 구입된다.")
  @CsvSource({"14000, 14", "12300, 12", "18800, 18", "12500, 12"})
  @ParameterizedTest
  void 로또가_예상개수만큼_발급된다(Integer payable, Integer expected) {
    assertThat(PurchaseService.purchase(new Money(payable)).numberOfLottoTickets())
        .isEqualTo(expected);
  }
}
