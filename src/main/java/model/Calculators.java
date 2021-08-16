package model;

import java.util.List;

public class Calculators {

  List<Calculator> calculators;

  public Calculators(List<Calculator> calculators) {
    this.calculators = calculators;
  }

  public int getCalculatorSize() {
    return calculators.size();
  }

  public Calculator getCalculator(int i) {
    return calculators.get(i);
  }
}
