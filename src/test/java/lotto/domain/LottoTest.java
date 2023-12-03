package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.joining;


class LottoTest {

    @Test
    @DisplayName("로또 번호는 [1, 2, 3 ... ] 문자로 변환되어야 한다.")
    void numberList_convertStr() {
        List<Integer> lottoNumberList = List.of(1, 2, 3, 4, 5, 6);
        String lottoNumberFormat = "[%s]";
        String collect = String.format(lottoNumberFormat, lottoNumberList.stream().map(String::valueOf).collect(joining(", ")));
        Assertions.assertThat(collect).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

}
