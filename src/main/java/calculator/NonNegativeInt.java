package calculator;

public class NonNegativeInt {

  private Integer integer;

  NonNegativeInt(Integer integer) {
    if (integer < 0) {
      throw new IllegalArgumentException("NonNegativeInt can't be negative integer");
    }

    this.integer = integer;
  }

  Integer getInteger() {
    return integer;
  }
}
