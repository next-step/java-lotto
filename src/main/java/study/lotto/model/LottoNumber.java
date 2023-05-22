package study.lotto.model;

import java.util.Arrays;

public class LottoNumber {

  int[] numbers = new int[6];

  public LottoNumber(int[] numbers) {
    if (numbers.length != 6) {
      throw new IllegalArgumentException("로또 숫자는 6자리 입니다.");
    }

    this.numbers = numbers;
    this.validate();
  }

  public LottoNumber(String input) {
    String[] split = input.split(",");

    if (split.length != 6) {
      throw new IllegalArgumentException("로또 숫자는 6자리 입니다.");
    }

    for (int i = 0; i < split.length; i++) {
      this.numbers[i] = Integer.parseInt(split[i].trim());
    }

    Arrays.sort(this.numbers);
    this.validate();
  }

  public String numberString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");

    for (int i = 0; i < 5; i++) {
      sb.append(numbers[i]).append(", ");
    }

    sb.append(numbers[5]).append("]");

    return sb.toString();
  }

  public int sameCount(LottoNumber winning) {
    int count = 0;
    for (int i = 0; i < 6; i++) {
      if (this.numbers[i] == winning.numbers[i]) {
        count++;
      }
    }
    return count;
  }

  public void validate() {
    for(int i=0;i<numbers.length;i++){
      if(this.numbers[i]<0 || this.numbers[i] >45) {
        throw new IllegalArgumentException("숫자가 로또 범위 숫자를 벗어난다.");
      }
    }

    for(int i=0;i<numbers.length -1;i++){
      if(this.numbers[i] == this.numbers[i+1]) {
        throw new IllegalArgumentException("같은 숫자 불가능.");
      }
    }
  }
}