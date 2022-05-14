package lotto.domain.money;

import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

public class Money {

  private static final String WON_FORMAT = "%d원";
  protected static final int MINIMUM_AMOUNT = 0;

  private final int amount;
  private final Currency currency;

  public static Money createWon(int amount) {
    return new Money(Currency.getInstance(Locale.KOREA), amount);
  }

  private Money(Currency currency, int amount) {
    validate(currency, amount);
    this.amount = amount;
    this.currency = currency;
  }

  private void validate(Currency currency, int amount) {
    Objects.requireNonNull(currency, "통화 객체는 null 일 수 없습니다!");
    if (isNotMoneyAmount(amount)) {
      throw new IllegalArgumentException(String.format("입력값: %d, 금액은 음수일 수 없습니다.", amount));
    }
  }

  private boolean isNotMoneyAmount(int amount) {
    return amount < MINIMUM_AMOUNT;
  }

  public Money multiply(double rate) {
    return new Money(currency, (int) (amount * rate));
  }

  public boolean lessThan(Money money) {
    Objects.requireNonNull(money);
    return this.amount < money.amount;
  }

  public Money sum(Money money) {
    Objects.requireNonNull(money);
    return Money.createWon(amount + money.amount);
  }

  public Money divide(Money money) {
    Objects.requireNonNull(money);
    return Money.createWon(amount / money.amount);
  }

  public int value() {
    return amount;
  }

  public String won() {
    return String.format(WON_FORMAT, amount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Money money = (Money) o;
    return amount == money.amount && currency.equals(money.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency);
  }

  @Override
  public String toString() {
    return String.format("Money{amount=%d}", amount);
  }
}