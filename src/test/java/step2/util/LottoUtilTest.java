package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoUtilTest {

    @Test
    @DisplayName("지불한 금액만큼 로또 티켓 개수 반환")
    void getNumOfTicketsTestSuccess() {
        assertThat(LottoUtil.getNumOfTickets(3000))
                .isEqualTo(3);
    }

    @Test
    @DisplayName("기입한 실 로또 번호를 숫자 리스트로 반환")
    void splitStringToNumbersSuccess() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            numbers.add(i);
        }

        assertThat(LottoUtil.splitStringToNumbers(winningNumbers))
                .isEqualTo(numbers);
    }

    @Test
    @DisplayName("파라미터로 넘어온 숫자 배열의 앞 6개 번호만 잘라서 반환")
    void generateLottoNumbersSuccess() {
        List<Integer> numbers1 = new ArrayList<>();
        for (int i = 5; i < 60; i++) {
            numbers1.add(i);
        }

        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 5; i < 11; i++) {
            lottoNumbers.add(i);
        }

        assertThat(LottoUtil.generateLottoNumbers(numbers1))
                .isEqualTo(lottoNumbers);
    }
}
