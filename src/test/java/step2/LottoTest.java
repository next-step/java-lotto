package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 6개 생성 테스트")
    void six_lottos(){
        List<Integer> numberList = Stream.iterate(1, n -> n + 1)
                .limit(45)
                .collect(Collectors.toList());
        Collections.shuffle(numberList);

        assertThat(numberList.stream().
        limit(6)
        .sorted()
        .map(number->new LottoNumber(number))
        .collect(Collectors.toSet()).size()).isEqualTo(6);
    }
    
}
