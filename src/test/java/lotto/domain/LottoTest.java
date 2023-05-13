package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    @DisplayName("입력 받은 숫자 6개를 정렬된 형태로 가진다.")
    void 정렬() {
        List<LottoNumber> inNumbers = convertToNumberList(new ArrayList<>(Arrays.asList(20,40,30,10,5,25)));
        List<LottoNumber> expected = convertToNumberList(new ArrayList<>(Arrays.asList(5,10,20,25,30,40)));
        Lotto lotto = new Lotto(inNumbers);
        assertThat(lotto.equals(expected)).isTrue();
    }

    @Test
    @DisplayName("숫자가 6개보다 많거나 적으면 예외를 던진다.")
    void 숫자개수() {
        List<LottoNumber> inNumbers1 = convertToNumberList(new ArrayList<>(Arrays.asList(1)));
        List<LottoNumber> inNumbers2 = convertToNumberList(new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1)));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(inNumbers1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(inNumbers2);
        });
    }

    @Test
    @DisplayName("생성된 로또가 자동생성인지 여부를 알려준다.")
    void 랜덤여부() {
        Lotto randomLotto = new Lotto();
        Lotto selectedLotto = new Lotto(convertToNumberList(new ArrayList<>(Arrays.asList(20,40,30,10,5,25))));

        assertThat(randomLotto.isRandom()).isTrue();
        assertThat(selectedLotto.isRandom()).isFalse();
    }

    List<LottoNumber> convertToNumberList(List<Integer> inNumbers) {
        return inNumbers.stream()
                .map(num -> new LottoNumber(num))
                .collect(Collectors.toList());
    }
}
