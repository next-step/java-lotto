package stringCalculator;

public class StringCalculator {

  private String text;

  public static final String DEFAULT_VALUE = "0";

  public StringCalculator(String inputText) {
    this.text = validationText(inputText);
  }

  private String validationText(String inputText) {
    if(inputText == null || inputText.isEmpty()){
      inputText = DEFAULT_VALUE;
    }
    return inputText;
  }

  public String getText() {
    return text;
  }
}
