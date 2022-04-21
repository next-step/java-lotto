package calculator.enums;

public enum Sign {
  PLUS("+"), MINAS("-"), MULTIPLE("*"), DIVISION("/");

  private String value;

  Sign(String value) {
    this.value = value;
  }

  public static String search(String value) {
    String result = null;
    for (Sign sign : values()) {
      if(sign.value.equals(value)) {
        result = sign.value;
      }
    }
    return result;
  }
}
