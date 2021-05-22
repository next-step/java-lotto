package lotto.domain;

import lotto.input.PurchaseAmountQuantity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoSellerTest {

  @Test
  void size() {
    // Given
    LottoSeller lottoSeller = new LottoSeller(new RandomNumberGenerator(new Random()));
    PurchaseAmountQuantity purchaseAmountQuantity = new PurchaseAmountQuantity(14200);

    // When
    LottoBucket actualLottoBucket = lottoSeller.getLottoBucketBy(purchaseAmountQuantity);

    // Then
    assertEquals(14, actualLottoBucket.size());
  }

  @Test
  void lottoBucket() {
    // Given
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    LottoSeller lottoSeller = new LottoSeller(numberCount -> numbers);
    LottoBucket expectedLottoBucket = new LottoBucket(singletonList(new Lotto(numberCount -> numbers)));

    PurchaseAmountQuantity purchaseAmountQuantity = new PurchaseAmountQuantity(1300);

    // When
    LottoBucket actualLottoBucket = lottoSeller.getLottoBucketBy(purchaseAmountQuantity);

    // Then
    assertEquals(expectedLottoBucket, actualLottoBucket);
  }
}