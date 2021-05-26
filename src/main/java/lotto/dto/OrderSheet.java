package lotto.dto;

import java.util.List;
import java.util.Objects;

public class OrderSheet {
  private static final int PRICE_PER_GAME = 1000;
  private static final String INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME = "최소 구입 금액은 %d원 이상입니다.";
  private static final String MANUAL_COUNT_SHOULD_NOT_LARGER_THAN_TOTAL_COUNT = "수동 구매 갯수(%d 개)가 입금액으로 구매할 수 있는 갯수(%d 개)보다 많습니다.";

  private final long purchasingAmount;
  private final List<List<Integer>> manualOrderedLottoNumbers;

  private OrderSheet(long purchasingAmount, List<List<Integer>> manualOrderedLottoNumbers) {
    this.purchasingAmount = purchasingAmount;
    this.manualOrderedLottoNumbers = manualOrderedLottoNumbers;
  }

  public static OrderSheet of(long purchasingAmount, List<List<Integer>> manualOrderedLottoNumbers) {
    validateOrderSheet(purchasingAmount, manualOrderedLottoNumbers);
    return new OrderSheet(purchasingAmount, manualOrderedLottoNumbers);
  }

  private static void validateOrderSheet(long purchasingAmount, List<List<Integer>> manualOrderedLottoNumbers) {
    if (purchasingAmount < PRICE_PER_GAME) {
      throw new IllegalArgumentException(String.format(INPUT_SHOULD_NOT_LESS_THAN_PRICE_PER_GAME, PRICE_PER_GAME));
    }

    long orderAbleCount = purchasingAmount / PRICE_PER_GAME;
    int manualOrderCount =manualOrderedLottoNumbers.size();
    if (orderAbleCount < manualOrderCount) {
      throw new IllegalArgumentException(String.format(MANUAL_COUNT_SHOULD_NOT_LARGER_THAN_TOTAL_COUNT, manualOrderCount, orderAbleCount));
    }
  }

  public long getPurchasingAmount() {
    return purchasingAmount;
  }

  public List<List<Integer>> getManualOrderedLottoNumbers() {
    return manualOrderedLottoNumbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderSheet that = (OrderSheet) o;
    return purchasingAmount == that.purchasingAmount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchasingAmount);
  }
}
