package step01.code.domain;

import org.junit.platform.commons.util.StringUtils;

public class Number {
  
  private final int number;

  public Number(int number) {
    this.number = number;
  }

  public Number(String str) {
    this.number = parseInt(str);
  }

  public int number() {
    return number;
  }

  public int parseInt(String str) {
    if(StringUtils.isBlank(str)) {
      return 0;
    }
    return Integer.parseInt(str);
  }

}
