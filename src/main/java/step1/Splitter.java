package step1;

import step1.domain.Number;

import java.util.ArrayList;
import java.util.List;

public class Splitter {
  List<Number> numberList;

  public Splitter(){
    numberList = new ArrayList<>();
  }

  public List<Number> split(String expression){
    if (expression == null || expression.trim().isEmpty()) {
      numberList.add(new Number(0));
      return numberList;
    }

    return numberList;
  }

}
