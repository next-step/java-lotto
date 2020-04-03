package lotto2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto2.domain.Fixture.oneLotto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTest {

    private List<Integer> sixNumbers;
    private List<Integer> fiveNumbers;

    @BeforeEach
    void setUp() {
        sixNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        fiveNumbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @DisplayName("로또는 한 장에 숫자 6개로 생성된다.")
    @Test
    void testLottoCreate() {
        // given
        List<LottoNumber> lottoNumbers = fiveNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(lottoNumbers));
    }

    @DisplayName("추출 번호는 오름차순으로 정렬되어 표시 된다.")
    @Test
    void testLottoSort() {
        List<Integer> unorderedNumber = Arrays.asList(3, 2, 1, 5, 4, 6);
        List<LottoNumber> lottoNumbers = unorderedNumber.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto actual = new Lotto(lottoNumbers);

        assertThat(sixNumbers.toString()).isEqualTo(actual.toString());
    }

}
