package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("로또를_생성하는_기능_테스트_6가지_숫자를_선택")
    @Test
    void lottoGenerateTest() {
        List<Integer> number = Arrays.asList(8, 21, 23, 41, 42, 43);
        List<LottoNumber> lottoNumber = number.stream().map(LottoNumber::new).collect(Collectors.toList());
        LottoFullNumber lottoNFullNumber = new LottoFullNumber(lottoNumber);
        assertThat(lottoNFullNumber.getLottoFullNumber()).isNotNull();
    }

}
