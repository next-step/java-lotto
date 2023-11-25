package step2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 로또생성테스트() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            list.add(i);
        }
        assertThat(new Lotto(list).toString()).isEqualTo(list.toString());
    }
}