package step1.data;

public class Number {
  private Integer value;

  public Number(String str) {
    this.value = Integer.parseInt(str);
    if(value < 0) {
      throw new RuntimeException("음수 입력 불가.");
    }
  }

  public int getValue() {
    return this.value;
  }
}
