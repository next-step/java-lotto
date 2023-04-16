package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER = 6;

    private final List<Integer> lottoLimiteds;  // vo로   Integer  수정

    public Lotto() {   // 1~ 45   번호 리스트 생성
        this.lottoLimiteds = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    }

    // 구입 한 로또 리스트
    public ManyTickets purChase(List<LottoTicket> pasiveTickets,int number) {
        List<LottoTicket> lottoObjects = IntStream.range(0, number)
                .mapToObj(i -> {
                    Collections.shuffle(lottoLimiteds);
                    LottoTicket lottoObject = new LottoTicket();
                    lottoLimiteds.subList(0, LOTTO_NUMBER).forEach(lottoObject::add);
                    return lottoObject;
                })
                .collect(Collectors.toList());

        List<LottoTicket> sumTickets = Stream.of(pasiveTickets, lottoObjects)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return new ManyTickets(sumTickets);
    }


    // 당첨 통계 결과 map으로 추출
    public Map<LottoType, Long> winningStatistics(ManyTickets tickets, List<Integer> winningNumbers, int bonusNumber) {
        return tickets.getManyTickets().stream().map(object -> object.contains(winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

//    public BigDecimal lotto(int amount,int manualTicket,  String winngingText, int bonusNumber ) {
//        System.out.println("구입금액을 입력해 주세요");
//        System.out.println(amount);
//
//        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
//        System.out.println(manualTicket);
//
//        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
//
//        int number = amount / LOTTO_PRICE; // 반복 갯수
//        int manualTicketNumber  = number - manualTicket;
//        System.out.println("수동으로 "+manualTicket+"장, 자동으로 "+manualTicketNumber+"개를 구매했습니다.");
//
//        ManyTickets manyLottoTickets = purChase(number); // 구입 한 로또 리스트
//        //manyLottoTickets.getManyTickets().
//        printTickets(manyLottoTickets); // UI.메소드
//
//        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
//
//        List<Integer> winningNumbers = winningNumber(winngingText);  // 지난주 당첨 번호 리스트
//
//        System.out.println("보너스 볼을 입력해 주세요..");
//
//        System.out.println(bonusNumber);
//
//        System.out.println("당첨 통계");
//
//        Map<LottoType, Long> results = winningStatistics(manyLottoTickets, winningNumbers, bonusNumber);// 당첨 통계 메소드
//
//        printWinningList(results); // 당첨 통계  ui 메소드
//
//        BigDecimal rate = rateResult(results, amount); // 수익률  계산 메소드
//
//        System.out.println("총 수익률은 " + rate + "입니다.");
//
//        return rate;
//    }


    //   수익률 구하는 메소드
    public BigDecimal rateResult(Map<LottoType, Long> winningStatistics) {
        return BigDecimal.valueOf(totalWinnings(winningStatistics))
                .divide(BigDecimal.valueOf(1000), 2, RoundingMode.DOWN);
    }

    // 총 당첨금 을 구하는 메소드
    private int totalWinnings(Map<LottoType, Long> winningStatistics) {
        return winningStatistics.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPriceMultiply(entry.getValue()))
                .reduce(0, Integer::sum);
    }

}
