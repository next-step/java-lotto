package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoWinTest {

    @Test
    void 로또_당첨_확인하기() {
        // Given
        LottoBuy lottoBuy = new LottoBuy(
                "[8, 21, 23, 41, 42, 43]\n" +
                        "[3, 5, 11, 16, 32, 38]\n" +
                        "[7, 11, 16, 35, 36, 44]\n" +
                        "[1, 8, 11, 31, 41, 42]\n" +
                        "[13, 14, 16, 38, 42, 45]\n" +
                        "[7, 11, 30, 40, 42, 43]\n" +
                        "[2, 13, 22, 32, 38, 45]\n" +
                        "[23, 25, 33, 36, 39, 41]\n" +
                        "[1, 3, 5, 14, 22, 45]\n" +
                        "[5, 9, 38, 41, 43, 44]\n" +
                        "[2, 8, 9, 18, 19, 21]\n" +
                        "[13, 14, 18, 21, 23, 35]\n" +
                        "[17, 21, 29, 37, 42, 45]\n" +
                        "[3, 8, 27, 30, 35, 44]");

        // When
        String winNumber = "1, 2, 3, 4, 5, 6";
        LottoWin lottoWin = new LottoWin(lottoBuy, winNumber);

//        System.out.println(lottoBuy.toString());

        System.out.println(lottoWin);

        // Then
        Assertions.assertThat(lottoWin.toString())
                .isEqualTo(
                        "당첨통계\n" +
                        "---------\n" +
                        "3개 일치 (5000원)- 1개\n" +
                        "4개 일치 (50000원)- 0개\n" +
                        "5개 일치 (1500000원)- 0개\n" +
                        "6개 일치 (2000000000원)- 0개\n" +
                        "총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}