package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottoTest {

  @Test
  void lottoHasNumbers() {
    Lotto lotto = new Lotto();
    assertThat(lotto.toString()).contains("41", "33", "3");
  }
}
