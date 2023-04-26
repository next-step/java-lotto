package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleStudyTest {

    @Test
    @Disabled
    @DisplayName("shuffle 테스트")
    void test01() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Collections.shuffle(numbers);

        System.out.println(numbers);
    }

    @Test
    @Disabled
    @DisplayName("shuffle (1 - 45) Number 테스트")
    void test02() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 45).mapToObj(LottoNumber::new).collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);

        System.out.println(lottoNumbers);
    }
}
