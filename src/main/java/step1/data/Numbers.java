package step1.data;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
  List<Number> numberList;

  public Numbers(String[] strings) {
    numberList = new ArrayList<>();
    for(String str : strings) {
      numberList.add(new Number(str));
    }
  }

  public int sum() {
    int result = 0;
    for(Number number : this.numberList) {
      result += number.getValue();
    }
    return result;
  }

}
