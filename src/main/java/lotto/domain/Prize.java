package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
                .map(ticket -> ticket.checkLotteryWinningStatus(winningNumber))
                .collect(Collectors.toList());
    }

    public static double returnRate(LottoTickets lottoTickets, WinningNumber winningNumber) {
        double result = (double) sumOfPrize(lottoTickets, winningNumber) / lottoTickets.totalPrice();
        return Math.floor(result * 100) / 100;
    }

    public static WinningStatus winningStatus(LottoTickets lottoTickets, WinningNumber winningNumber) {
        List<PrizeType> prizeTypes = Prize.listOfPrize(lottoTickets, winningNumber);
        return makeWinningStatus(prizeTypes);
    }

    private static WinningStatus makeWinningStatus(List<PrizeType> prizeTypes) {
        Map<PrizeType, Integer> winningStatus = new HashMap<>();
        Arrays.stream(PrizeType.values())
                .forEach(prizeType -> winningStatus.put(prizeType, sumOfPrize(prizeTypes, prizeType)));
        return WinningStatus.from(winningStatus);
    }

    public static int sumOfPrize(List<PrizeType> prizeTypes, PrizeType prizeType) {
        return (int) prizeTypes.stream()
                .filter(t -> t == prizeType)
                .count();
    }
}
