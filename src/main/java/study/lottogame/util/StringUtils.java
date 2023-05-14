package study.lottogame.util;

public class StringUtils {

  private StringUtils() {
  }

  public static void checkNullOrBlank(String number) {
    if (number == null || number.isBlank()) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
  }
}
