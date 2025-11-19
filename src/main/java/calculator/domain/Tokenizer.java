package calculator.domain;

import java.util.List;

public class Tokenizer {

  private final String REGEX;

  public Tokenizer(String regex) {
    this.REGEX = regex;
  }

  public Tokenizer() {
    this(" ");
  }

  public List<String> split(String input) {
    return List.of(input.split(REGEX));
  }
}
