package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    @Test
    @DisplayName("로또숫자가 6개인지 테스트")
    void isLottoNumbersSizeEqualsSix() {
        // given
        LottoNumberGenerator lottoNumberGenerator = new AutoLottoNumberGenerator();
        LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);

        // when
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();
        int actual = lottoNumbers.size();

        // then
        assertEquals(6, actual);
    }

    @Test
    @DisplayName("로또 번호 범위가 1~45인지 테스트")
    void checkRangeOfLottoNumbers(){
        // given
        List<Integer> numbers = Arrays.asList(1,2,3,43,44,45);

        // when
        LottoNumberGenerator lottoNumberGenerator = new TestLottoNumberGenerator(numbers);
        LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator);
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();

        int minNumber = whichSmallestNumber(lottoNumbers);
        int maxNumber = whichBigNumbers(lottoNumbers);

        // then
        assertAll(
                () -> assertThat(minNumber).isGreaterThanOrEqualTo(LottoNumberGenerator.lottoMinNumber),
                () -> assertThat(maxNumber).isLessThanOrEqualTo(LottoNumberGenerator.lottoMaxNumber)
        );
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있을때 RuntimeException 던지는지 테스트")
    void checkDuplicationNumbers(){
        // given
        List<Integer> numbers = Arrays.asList(1,7,27,41,44,44);

        // when
        LottoNumberGenerator lottoNumberGenerator = new TestLottoNumberGenerator(numbers);

        // then
        assertThrows(RuntimeException.class, () -> {
            new LottoTicket(lottoNumberGenerator);
        });
    }

    int whichSmallestNumber(List<Integer> list){
        int min = list.get(0);
        for (Integer integer : list) {
            if(min<integer){
                min = integer;
            }
        }
        return min;
    }

    int whichBigNumbers(List<Integer> list){
        int max = list.get(0);
        for (Integer integer : list) {
            if(max>integer){
                max = integer;
            }
        }
        return max;
    }
}
