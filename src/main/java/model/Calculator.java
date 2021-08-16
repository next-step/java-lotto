package model;

public class Calculator {

  private String spliter;

  public Calculator(String spliter) {
    this.spliter = spliter;
  }

  public String[] split(String expr) {
    return expr.split(spliter);
  }
}
