package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("로또 일급 컬렉션은 생성자에 로또 목록을 넘길 경우 이를 필드로 갖는다.")
    @Test
    void constructor() {
        final List<LottoNumber> numbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Lottos lottos = new Lottos(List.of(new Lotto(numbers)));
        assertThat(lottos.isEmpty()).isFalse();
    }


}
