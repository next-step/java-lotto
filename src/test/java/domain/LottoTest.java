package domain;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 셔플함수테스트() {
        List<Integer> nums = IntStream.range(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(nums);

        nums.subList(0, 6).stream().forEach(v -> System.out.println(v));
    }

    @Test
    public void 로또한장구매() {
        Lotto lotto = new Lotto(LottoGenerator.run(new Random()));

        assertThat(lotto).isNotNull();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

}
