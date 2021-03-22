package lotto.domain;

public class Number implements Comparable<Number> {

  private int number;

  public Number(int number) {
    this.number = number;
  }

  public int getLottoNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Number that = (Number) o;

    return number == that.number;
  }

  @Override
  public int hashCode() {
    return number;
  }

  @Override
  public int compareTo(Number o) {
    if (this.number < o.number) {
      return -1;
    }
    if (this.number > o.number) {
      return 1;
    }
    return 0;
  }
}
