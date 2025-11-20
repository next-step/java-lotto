package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TokenizerTest {

  @Test
  void tokenize() {
    Tokenizer tokenizer = new Tokenizer();
    List<String> str = tokenizer.split("1 + 10 / 3 * 5 - 2");
    assertThat(str).containsExactly("1", "+", "10", "/", "3", "*", "5", "-", "2");
  }
}