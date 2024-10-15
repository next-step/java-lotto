package lotto.view;

import lotto.dto.LottosDto;
import lotto.dto.LottoNumbersDto;
import lotto.dto.PrizeMoneyDto;
import lotto.dto.ResultDto;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String TITLE = "당첨 통계";
    private static final String DIVIDER = "----------";
    private static final String COUNT_MESSAGE = "%d개 일치 (%.0f원)- %d개 \n";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.02f%%입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printCreateLotto(LottosDto lottosDto) {
        List<LottoNumbersDto> lottoNumbersDto = lottosDto.getLottoNumbersDto();
        printLottoSize(lottoNumbersDto);
        printNumbers(lottoNumbersDto);
    }

    private static void printLottoSize(List<LottoNumbersDto> lottoNumbersDto) {
        System.out.println(lottoNumbersDto.size() + BUY_COUNT_MESSAGE);
    }

    private static void printNumbers(List<LottoNumbersDto> lottoNumbersDto) {
        for (LottoNumbersDto lottoNumbers : lottoNumbersDto) {
            List<Integer> collect = toList(lottoNumbers);
            Collections.sort(collect);
            System.out.println(collect);
        }
    }

    private static List<Integer> toList(LottoNumbersDto lottoNumbers) {
        return lottoNumbers.getNumbers().stream().collect(Collectors.toList());
    }

    public static void printResult(ResultDto result) {
        System.out.println(TITLE);
        System.out.println(DIVIDER);

        printRank(result.getPrizeMoneyDto());
        printRateOfReturn(result.getRate());
    }

    private static void printRank(List<PrizeMoneyDto> prizeMoneyDto) {
        prizeMoneyDto.sort(Comparator.comparingInt(PrizeMoneyDto::getCollectCount));
        for (PrizeMoneyDto moneyDto : prizeMoneyDto) {
            System.out.printf(COUNT_MESSAGE, moneyDto.getCollectCount(), moneyDto.getPrizeMoney(), moneyDto.getCount());
        }
    }

    private static void printRateOfReturn(BigDecimal rate) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rate);
    }


}
