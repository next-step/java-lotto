package study.lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.LottoNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {
    @DisplayName("랜덤으로 6개의 로또 번호를 생성")
    @Test
    public void lottoGeneratorRandomNumbersTest(){
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.randomNumbers();
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        assertThat(lottoNumberSet.size()).isEqualTo(6);
        sortCheck(lottoNumbers);
    }

    private void sortCheck(List<LottoNumber> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size()-1; i++) {
            assertThat(lottoNumbers.get(i).value() < lottoNumbers.get(i+1).value()).isTrue();
        }
    }

    @DisplayName("숫자를 입력받아 로또 번호 생성")
    @Test
    public void lottoGeneratorMarkingNumberByListTest(){
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.markedNumbers(Arrays.asList(3,2,1,4,5,7));

        assertThat(lottoNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7));
    }

    @DisplayName("스트링 당첨번호 입력받아 로또 번호 생성")
    @Test
    public void LottoGeneratorMarkingNumberByStringTest(){
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.markedNumbers("3,2,1,4,5,7");

        assertThat(lottoNumbers).containsExactly(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(7));
    }

    @DisplayName("중복된 번호 입력시 에러 발생")
    @Test
    public void wrongInputTest(){

        assertThatThrownBy(() -> LottoNumberGenerator.markedNumbers("3,3,1,4,5,7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumberGenerator.markedNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumberGenerator.markedNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}