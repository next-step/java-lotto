package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.PrizeType.*;

public class Prize {

    private static long sumOfPrize(LottoTickets lottoTickets, WinningNumber winningNumber) {
        long sum = 0;
        List<PrizeType> types = listOfPrize(lottoTickets, winningNumber);
        for (PrizeType type : types) {
            sum += type.prize();
        }
        return sum;
    }

    public static List<PrizeType> listOfPrize(LottoTickets lottoTickets, WinningNumber winningNumber) {
        return lottoTickets.getTickets().stream()
                .map(t -> t.typeOfMatching(winningNumber))
                .collect(Collectors.toList());
    }

    public static double returnRate(LottoTickets lottoTickets, WinningNumber winningNumber) {
        double result = (double) sumOfPrize(lottoTickets, winningNumber) / lottoTickets.totalPrice();
        return Math.floor(result * 100) / 100;
    }

    public static int prizeCount(List<PrizeType> prizeTypes, PrizeType prizeType) {
        return (int) prizeTypes.stream()
                .filter(t -> t == prizeType)
                .count();
    }

    public static Map<PrizeType, Integer> winningStatus(LottoTickets lottoTickets, WinningNumber winningNumber) {
        Map<PrizeType, Integer> winningStatus = new HashMap<>();
        List<PrizeType> prizeTypes = Prize.listOfPrize(lottoTickets, winningNumber);
        winningStatus.put(FIRST_PRIZE, Prize.prizeCount(prizeTypes, FIRST_PRIZE));
        winningStatus.put(SECOND_PRIZE, Prize.prizeCount(prizeTypes, SECOND_PRIZE));
        winningStatus.put(THIRD_PRIZE, Prize.prizeCount(prizeTypes, THIRD_PRIZE));
        winningStatus.put(FOURTH_PRIZE, Prize.prizeCount(prizeTypes, PrizeType.FOURTH_PRIZE));
        return winningStatus;
    }
}
