package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Scanner;
import lotto.domain.LottoMoney;
import lotto.domain.PurchaseCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameApplicationTest {

  @DisplayName("로또묶음 객체 생성 테스트.")
  @Test
  void 로또묶음객체생성() {
    PurchaseCount purchaseCount = new PurchaseCount(new LottoMoney(2000),1);
    Scanner scanner = new Scanner("1,2,3,4,5,6");
    List<String> manualNumbers = purchaseCount.createManualNumbers(scanner);

    assertThat(LottoGameApplication.createLottos(purchaseCount, manualNumbers)).isNotNull();
  }
}