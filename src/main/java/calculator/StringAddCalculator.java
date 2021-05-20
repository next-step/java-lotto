package calculator;

public class StringAddCalculator {

  private final StringSplitter stringSplitter;
  private final InputValidator inputValidator;
  private final NumberAdder numberAdder;

  public StringAddCalculator(StringSplitter stringSplitter, InputValidator inputValidator, NumberAdder numberAdder) {
    this.stringSplitter = stringSplitter;
    this.inputValidator = inputValidator;
    this.numberAdder = numberAdder;
  }

  public int calculate(String text) {
    if (inputValidator.isNullOrEmpty(text)) {
      return 0;
    }

    return numberAdder.add(stringSplitter.split(text));
  }
}
