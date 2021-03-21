package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨자테스트")
class WinningNumbersTest {
    @Test
    void isWinner() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,3,5,7,9));
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(lottoNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1,2,3,4,5,6});
        Map<Integer, Integer> winNumbers = winningNumbers.getWinNumbers(lottoNumbersList);
        System.out.println(winNumbers.toString());
        assertThat(winNumbers.get(3)).isEqualTo(3);
    }

    LottoNumbers lottoNumbers1;
    LottoNumbers lottoNumbers2;
    LottoNumbers lottoNumbers3;
    LottoNumbers lottoNumbers4;
    LottoNumbers lottoNumbers5;
    LottoNumbers lottoNumbers6;
    LottoNumbers lottoNumbers7;
    LottoNumbers lottoNumbers8;
    LottoNumbers lottoNumbers9;
    LottoNumbers lottoNumbers10;
    LottoNumbers lottoNumbers11;
    LottoNumbers lottoNumbers12;
    LottoNumbers lottoNumbers13;
    LottoNumbers lottoNumbers14;

    @Test
    @DisplayName("당첨번호의 갯수를 찾는다.")
    void ex1() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();

        lottoNumbers.add(lottoNumbers1);
        lottoNumbers.add(lottoNumbers2);
        lottoNumbers.add(lottoNumbers3);
        lottoNumbers.add(lottoNumbers4);
        lottoNumbers.add(lottoNumbers5);
        lottoNumbers.add(lottoNumbers6);
        lottoNumbers.add(lottoNumbers7);
        lottoNumbers.add(lottoNumbers8);
        lottoNumbers.add(lottoNumbers9);
        lottoNumbers.add(lottoNumbers10);
        lottoNumbers.add(lottoNumbers11);
        lottoNumbers.add(lottoNumbers12);
        lottoNumbers.add(lottoNumbers13);
        lottoNumbers.add(lottoNumbers14);

        WinningNumbers winningNumbers = new WinningNumbers(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(winningNumbers.getWinNumbers(lottoNumbers).get(3))
                .isEqualTo(1);
        assertThat(winningNumbers.getWinNumbers(lottoNumbers).get(4))
                .isEqualTo(0);
        assertThat(winningNumbers.getWinNumbers(lottoNumbers).get(5))
                .isEqualTo(0);
        assertThat(winningNumbers.getWinNumbers(lottoNumbers).get(6))
                .isEqualTo(0);
    }

    @BeforeEach
    void init() {
        lottoNumbers1 = new LottoNumbers(Arrays.asList(8, 21, 23, 41, 42, 43));
        lottoNumbers2 = new LottoNumbers(Arrays.asList(3, 5, 11, 16, 32, 38));
        lottoNumbers3 = new LottoNumbers(Arrays.asList(7, 11, 16, 35, 36, 44));
        lottoNumbers4 = new LottoNumbers(Arrays.asList(1, 8, 11, 31, 41, 42));
        lottoNumbers5 = new LottoNumbers(Arrays.asList(13, 14, 16, 38, 42, 45));
        lottoNumbers6 = new LottoNumbers(Arrays.asList(7, 11, 30, 40, 42, 43));
        lottoNumbers7 = new LottoNumbers(Arrays.asList(2, 13, 22, 32, 38, 45));
        lottoNumbers8 = new LottoNumbers(Arrays.asList(23, 25, 33, 36, 39, 41));
        lottoNumbers9 = new LottoNumbers(Arrays.asList(1, 3, 5, 14, 22, 45));
        lottoNumbers10 = new LottoNumbers(Arrays.asList(5, 9, 38, 41, 43, 44));
        lottoNumbers11 = new LottoNumbers(Arrays.asList(2, 8, 9, 18, 19, 21));
        lottoNumbers12 = new LottoNumbers(Arrays.asList(13, 14, 18, 21, 23, 35));
        lottoNumbers13 = new LottoNumbers(Arrays.asList(17, 21, 29, 37, 42, 45));
        lottoNumbers14 = new LottoNumbers(Arrays.asList(3, 8, 27, 30, 35, 44));
    }
}
