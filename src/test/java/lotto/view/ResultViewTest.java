package lotto.view;

import lotto.LottoNumbers;
import lotto.LottoRound;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

class ResultViewTest {
    @DisplayName("로또 번호 출력 테스트")
    @Test
    public void printLottoNumber() throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ResultView.printLottoNumber(new LottoNumbers(Set.of(3,6,1,5,2,4)));

        Assertions.assertThat(output.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n");
        System.setOut(System.out);
    }

    @DisplayName("로또 당첨 통계 출력 테스트")
    @Test
    public void test() throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        LottoRound lottoRound = new LottoRound(Set.of(1, 2, 4, 3, 5, 6));

        LottoNumbers first = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6));
        LottoNumbers second = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 7));
        LottoNumbers third = new LottoNumbers(Set.of(1, 2, 3, 4, 7, 8));
        LottoNumbers fourth = new LottoNumbers(Set.of(1, 2, 3, 7, 8, 9));
        LottoNumbers etc = new LottoNumbers(Set.of(1, 2, 7, 8, 9, 10));

        ResultView.printStat(444950.56, lottoRound.checkLottoRank(List.of(first, first, second, second, second, third, fourth, etc, etc)));

        Assertions.assertThat(output.toString()).isEqualTo("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 1개\n" +
                "5개 일치 (1500000원)- 3개\n" +
                "6개 일치 (2000000000원)- 2개\n" +
                "총 수익률은 444950.56입니다.\n");
        System.setOut(System.out);
    }
}