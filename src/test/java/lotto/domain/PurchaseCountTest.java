package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseCountTest {

  @DisplayName("구매카운트 객체를 생성해서 자동구매 카운트 반환 테스트.")
  @Test
  void 구매카운트정보생성및자동구매카운트반환() {
    PurchaseCount purchaseCount = new PurchaseCount(new LottoMoney(2000),1);
    assertThat(purchaseCount.getAutoCount()).isEqualTo(1);
  }

  @DisplayName("수동구매 카운트값 만큼 로또를 입력받아서 반환하는 테스트.")
  @Test
  void 수동구매카운트만큼입력값리스트로반환() {
    PurchaseCount purchaseCount = new PurchaseCount(new LottoMoney(2000),1);
    Scanner scanner = new Scanner("1,2,3,4,5,6");
    List<String> manualNumbers = purchaseCount.createManualNumbers(scanner);
    scanner.close();
    assertThat(manualNumbers.size()).isEqualTo(1);
    assertThat(manualNumbers).containsExactly("1,2,3,4,5,6");
  }
}