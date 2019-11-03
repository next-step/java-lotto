package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
  private int result = 0;
  private String inputValue;
  private static final String SPLIT_REGEX = ",|:";

  public StringAddCalculator(String value) {
    this.inputValue = value;
  }

  int calculate() {
    return add(this.inputValue);
  }

  public int add(String arg) {
    if(arg == null || arg.length() == 0) return result;

      Matcher m = Pattern.compile("//(.)\n(.*)").matcher(arg);

      String[] splitedValue;
      if (m.find()) {
        String customDelimiter = m.group(1);
        splitedValue =  m.group(2).split(customDelimiter);
      }else{
        splitedValue = arg.split(SPLIT_REGEX);
      }

      int loopVal;
      for(String val : splitedValue) {
        loopVal = Integer.parseInt(val);
        if(loopVal < 0){
          throw new IllegalArgumentException();
        }else{
          result += Integer.parseInt(val);
        }
      }
      return result;
    }


}

