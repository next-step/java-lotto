package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class CollectionsTest {

  private final List<Integer> sortedNumbers
      = Stream.iterate(1, n -> n + 1).limit(45).collect(Collectors.toList());;

  private final List<Integer> shuffleNumbers =
      Stream.iterate(1, n -> n + 1).limit(45).collect(Collectors.toList());
  @Test
  void shuffle() {
    assertThat(sortedNumbers).isEqualTo(shuffleNumbers);

    Collections.shuffle(sortedNumbers);
    assertThat(sortedNumbers).isNotEqualTo(shuffleNumbers);
  }

}
