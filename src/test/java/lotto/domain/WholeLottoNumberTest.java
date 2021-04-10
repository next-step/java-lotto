package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;




class WholeLottoNumberTest {

    @Test
    @DisplayName("로또 번호 생성 초기번호 테스트")
    void createNumber() {
        WholeLottoNumbers wholeLottoNumbers = new WholeLottoNumbers();
        wholeLottoNumbers.createNumber();
        List<Number> numberList = wholeLottoNumbers.lottoNumberList();

        assertThat(numberList).extracting("number").containsAll(
                IntStream.rangeClosed(1, 45)
                        .boxed()
                        .collect(Collectors.toList())
        );
    }
}
