package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.dto.LottoPurchaseResponse;
import lotto.domain.dto.LottoWinnersDto;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    public static void printPurchaseLottos(LottoPurchaseResponse lottoPurchaseResponse) {
        System.out.println(lottoPurchaseResponse.getLottoList().size() + "개를 구매했습니다.");
        lottoPurchaseResponse.getLottoList().stream().forEach(lotto -> printLottoNumbers(lotto.getNumbers()));
    }

    private static void printLottoNumbers(Set<LottoNumber> numbers) {
        List<String> numbersStringList = numbers.stream().map(LottoNumber::getLottoNumber).map(String::valueOf).collect(Collectors.toList());
        System.out.println("[" + String.join(", ", numbersStringList) + "]");
    }

    public static void printWinners(List<LottoWinnersDto> lottoWinnersDtos) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        lottoWinnersDtos.stream()
                .sorted(Comparator.comparingInt(LottoWinnersDto::getAmount))
                .forEach(lottoWinnersDto -> printWinnersByAward(lottoWinnersDto.getMatchNumbers(), lottoWinnersDto.isBonus(), lottoWinnersDto.getAmount(), lottoWinnersDto.getCountWinners()));

    }

    private static void printWinnersByAward(int matchNumbers, boolean bonus, int amount, long countWinners) {
        if(matchNumbers == 5 && bonus == true){
            System.out.println(matchNumbers + "개 일치, 보너스 볼 일치(" + amount + "원)- " + countWinners);
            return ;
        }
        System.out.println(matchNumbers + "개 일치 (" + amount + "원)- " + countWinners);
    }

    public static void printYield(List<LottoWinnersDto> lottoWinnersDtos, int lottoPurchaseAmount) {
        double earnings = lottoWinnersDtos.stream()
                .mapToDouble(lottoWinnerDto -> getYield(lottoWinnerDto.getAmount(), lottoWinnerDto.getCountWinners()))
                .sum();
        double yield = earnings / lottoPurchaseAmount;
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    private static double getYield(int amount, long countWinners) {
        return amount * countWinners;
    }
}
