package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1).stream()
            .map(i-> LottoNumber.of(i))
            .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("생성 테스트")
    public void create() {
        // given & when
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(i -> LottoNumber.of(i))
            .collect(Collectors.toList());
        // then
        assertThat(lotto.lottoNumbers()).isEqualTo(lottoNumbers);
    }

    @Test
    @DisplayName("유효성 테스트")
    public void validate() {
        // given & when
        List<LottoNumber> lottoNumbers = Arrays.asList(1,2,3,4,5).stream()
            .map(i -> LottoNumber.of(i))
            .collect(Collectors.toList());
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @ParameterizedTest(name = "유효성 테스트 - 중복")
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
}
