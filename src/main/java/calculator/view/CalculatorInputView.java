package calculator.view;

import calculator.exception.UserInputFailException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CalculatorInputView {
  private static final String INPUT_MESSAGE = "사칙연산 계산식을 입력해주세요.";
  private final Scanner scanner;

  public CalculatorInputView() {
    this.scanner = new Scanner(System.in);
  }

  public void printInputMessage(){
    System.out.println(INPUT_MESSAGE);
  }

  public String getInputFormula(){
    try{
      return getFormula();
    }catch(NoSuchElementException | IllegalStateException e){
      throw new UserInputFailException();
    }
  }

  private String getFormula() {
    return scanner.nextLine();
  }
}
