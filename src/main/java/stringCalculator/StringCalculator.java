package stringCalculator;

public class StringCalculator {

  private String text;

  public static final String DEFAULT_VALUE = "0";

  public StringCalculator(String inputText) {
    this.text = validationText(inputText);
  }

  private String validationText(String text) {
    if(text == null || text.isEmpty()){
      return DEFAULT_VALUE;
    }
    return text;
  }

  public String getText() {
    return text;
  }

  public String[] getSplitValues() {
    return text.split(",|:");
  }
}
