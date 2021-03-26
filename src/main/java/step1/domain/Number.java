package step1.domain;

public class Number {
  private final int number;

  public Number(){
    this(0);
  }

  public Number(int number){
    if(number <0){
      throw new RuntimeException("음수가 들어올 수 없습니다.");

    }
    this.number = number;
  }

  public Number sum(Number targetNumber){
    return new Number(this.number + targetNumber.number);
  }

  public int getNumber(){
    return number;
  }
}
