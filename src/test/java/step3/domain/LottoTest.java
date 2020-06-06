package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    private static List<Integer> lottoGameNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());


    @DisplayName("init Class 생성테스트")
    @ParameterizedTest
    @ValueSource(ints = {6})
    public void testGetInstance(int lottoDrawLimit) {

        Lotto lotto = Lotto.getInstance();
        assertThat(lotto.getNumbers().size()).isEqualTo(lottoDrawLimit);

    }

    @DisplayName("init Class 생성테스트")
    @Test
    public void testFrom() {

        Integer[] test = {6, 2, 3, 4, 5, 1};
        Integer[] testResult = {1, 2, 3, 4, 5, 6};

        Lotto lotto = Lotto.from(Arrays.asList(test));

        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(testResult));

    }

    @DisplayName("6 개 번호 선별 테스트")
    @Test
    public void testDrawLottoNumbers() {

        assertThat(Lotto.drawLottoNumbers(lottoGameNumbers).size()).isEqualTo(6);

    }


    @DisplayName("당첨번호 체크 오류입력")
    @Test
    public void testCheckWiningNumberWithError() {

        String[] testString = {"2", "3", "A", "7", "8", "10"};

        assertThatIllegalArgumentException().isThrownBy(() ->
                Lotto.checkWiningNumber(testString));

    }

}





