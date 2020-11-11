package step1.constans;

import java.util.regex.Pattern;

public class RxPattern {

  public static final Pattern DEFAULT_DELIMITER_PATTERN = Pattern.compile("[,:]");
  public static final Pattern CUSTOM_DELIMITER_INPUT_FINDER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
  public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n((\\d\\1)*\\d)");

  public RxPattern() {}
}
