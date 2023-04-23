package lotto.view;

import lotto.dto.LottoNumbersDto;
import lotto.dto.WinningStatDto;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumber(LottoNumbersDto lottoNumbersDto) {
        for (List<Integer> lottoNumber : lottoNumbersDto.getLottoNumbers()) {
            System.out.println(lottoNumber);
        }
    }

    public static void printWinningStat(WinningStatDto winningStatDto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println("3개 일치 (5000원)- " + winningStatDto.getFourthCount() + "개");
        System.out.println("4개 일치 (50000원)- " + winningStatDto.getThirdCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + winningStatDto.getSecondCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + winningStatDto.getFirstCount() + "개");

        System.out.println("총 수익률은 " + winningStatDto.getRateOfReturn() + "입니다.");
    }
}
