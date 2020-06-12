package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    private static List<Integer> lottoGameNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    @DisplayName("6 개 번호 선별 테스트")
    @Test
    public void testDrawLottoNumbers() {
        Lotto lotto = Lotto.auto();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }


    @DisplayName("입력번호 중복")
    @Test
    public void testCheckWiningNumberDuplicateWithError() {
        String[] testString = {"2", "3", "3", "7", "8", "10"};
        TreeSet<Integer> setInput = new TreeSet<>(Arrays.stream(testString).map(Integer::parseInt).collect(Collectors.toSet()));
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Lotto(setInput));
    }

}





