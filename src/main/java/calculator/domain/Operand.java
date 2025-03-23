package calculator.domain;

public class Operand {

  private final int number;

  Operand(int number) {
    this.number = number;
  }

  public static Operand fromString(String token) {
    int number = Integer.parseInt(token);
    return new Operand(number);
  }

  public int toInt() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Operand operand = (Operand) o;
    return number == operand.number;
  }
}
