import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class HashSetTest {
    @Test
    public void 해쉬셋테스트() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,5,6,6,7);
        Set<Integer> set = new HashSet<>(list);
        assertThat(set.stream().count()).isEqualTo(7);
    }
}
