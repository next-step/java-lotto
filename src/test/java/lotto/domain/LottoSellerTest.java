package lotto.domain;

import lotto.input.PurchaseAmountQuantity;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.*;
import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoSellerTest {

  @Test
  void size() {
    // Given
    LottoSeller lottoSeller = new LottoSeller();
    List<String> manualLottoNumbers = asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38", "7, 11, 16, 35, 36, 44");
    PurchaseAmountQuantity purchaseAmountQuantity = new PurchaseAmountQuantity(14200, 3, manualLottoNumbers);

    // When
    LottoBucket actualLottoBucket = lottoSeller.getLottoBucketBy(purchaseAmountQuantity);

    // Then
    assertEquals(14, actualLottoBucket.size());
  }
}