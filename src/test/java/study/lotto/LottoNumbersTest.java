package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @DisplayName("로또 번호는 1~45 사이이다.")
    @Test
    public void createLottoPaperTest(){
        LottoNumbers lottoNumbers = new LottoNumbers();

        List<Integer> availableLottoNumbers = lottoNumbers.values();        //이름을 고민하던 중 일급객체는 enum과 비슷하단 느낌이 들어 value를 사용해보았습니다.
        assertThat(availableLottoNumbers.size()).isEqualTo(45);

        for (Integer lottoNumber : availableLottoNumbers) {
            assertThat(lottoNumber).isBetween(1,45);
        }
    }

    @DisplayName("자동 생성했을때 랜덤하게 중복없는 6개의 로도 번호가 얻어진다")
    @Test
    public void autoLottoNumbersTest(){
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> autoCreatedNumbers = lottoNumbers.autoCreatedNumbers();

        availableLottoNumbersTest(autoCreatedNumbers);
    }

    public static void availableLottoNumbersTest(List<Integer> numbers){
        assertThat(numbers.size()).isEqualTo(6);
        Set<Integer> numberSet = new HashSet<>();
        for (Integer lottoNumber : numbers) {
            assertThat(lottoNumber).isBetween(1,45);
            numberSet.add(lottoNumber);
        }
        assertThat(numberSet.size()).isEqualTo(6);  //중복없이 6개인지 확인

    }


}
