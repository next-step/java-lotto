package study.step4;


import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import study.step4.domain.Lotto;
import study.step4.domain.LottoNumber;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(6,5,4,3,2,1).stream()
            .map(i->LottoNumber.of(i))
            .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("생성 예외 테스트")
    public void create() {
        List<LottoNumber> lottoNumbers = Arrays.asList(1,2,3,4,5).stream()
            .map(i -> LottoNumber.of(i))
            .collect(Collectors.toList());
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("정렬 테스트")
    public void sort() {
        // given
        List<Integer> expectNumbers = Arrays.asList(1,2,3,4,5,6);
        // when & then
        assertThat(lotto.getLottoNumbers().toString()).isEqualTo(expectNumbers.toString());
    }

    @ParameterizedTest(name = "로또 넘버 중복 테스트")
    @ValueSource(strings = {"1,2,3,3,4,5,6", "1,2,2,2,2,3,4,5,6"})
    public void duplicate(String inputs) {
        // given
        String[] inputNumbers = inputs.split(",");
        Lotto test = new Lotto(Arrays.stream(inputs.split(","))
            .map(i -> LottoNumber.of(i))
            .collect(Collectors.toList()));
        // when & then
        assertThat(lotto).isEqualTo(test);
    }


    @ParameterizedTest(name = "로또 넘버 맞춤 테스트")
    @CsvSource(value={"1,2,3,4,5,6:6", "1,2,3,4,10,6:5"}, delimiter = ':')
    public void match(String inputs, int expect) {
        // given
        String[] inputNumbers = inputs.split(",");
        List<LottoNumber> winInput = Arrays.asList(inputNumbers).stream()
            .map(i -> LottoNumber.of(i))
            .collect(Collectors.toList());
        // when & then
        assertThat(lotto.match(winInput)).isEqualTo(expect);
    }

    @ParameterizedTest(name = "로또 넘버 맞춤 테스트")
    @CsvSource(value={"1:true", "6:true", "7:false"}, delimiter = ':')
    public void matchBonus(int inputs, boolean expect) {
        assertThat(lotto.matchBonus(LottoNumber.of(inputs))).isEqualTo(expect);
    }

}
