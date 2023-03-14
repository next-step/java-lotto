package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER = 6;

    private final List<Integer> lottoLimiteds;  // vo로   Integer  수정

    public Lotto() {   // 1~ 45   번호 리스트 생성
        this.lottoLimiteds = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    }

    // 구입 한 로또 리스트
    private ManyTickets purChase(List<Integer> lottoSize, int number) {
        List<LottoTicket> lottoObjects = IntStream.range(0, number)
                .mapToObj(i -> {
                    Collections.shuffle(lottoSize);
                    LottoTicket lottoObject = new LottoTicket();
                    lottoSize.subList(0, LOTTO_NUMBER).forEach(lottoObject::add);
                    return lottoObject;
                })
                .collect(Collectors.toList());
        return new ManyTickets(lottoObjects);
    }


    // 당첨 통계 결과 map으로 추출
    private Map<LottoType, Long> winningStatistics(ManyTickets tickets, List<Integer> winningNumbers, int bonusNumber) {
        return tickets.getManyTickets().stream().map(object -> object.contains(winningNumbers, bonusNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    // 당첨번호 리스트 추출
    private List<Integer> winningNumber(String winningText) {
        String[] winning = winningText.replace(" ", "").split(",");
        return Arrays.stream(winning).map(Integer::parseInt).collect(Collectors.toList());
    }

    public BigDecimal lotto(int amount, String winngingText, int bonusNumber) {
        System.out.println("구입금액을 입력해 주세요");
        System.out.println(amount);

        int number = amount / LOTTO_PRICE; // 반복 갯수
        System.out.println(number + "개를 구매했습니다.");

        ManyTickets manyLottoTickets = purChase(lottoLimiteds, number); // 구입 한 로또 리스트

        printTickets(manyLottoTickets); // UI.메소드

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> winningNumbers = winningNumber(winngingText);  // 지난주 당첨 번호 리스트

        System.out.println("보너스 볼을 입력해 주세요..");

        System.out.println(bonusNumber);

        System.out.println("당첨 통계");

        Map<LottoType, Long> results = winningStatistics(manyLottoTickets, winningNumbers, bonusNumber);// 당첨 통계 메소드

        printWinningList(results); // 당첨 통계  ui 메소드

        BigDecimal rate = rateResult(results, amount); // 수익률  계산 메소드

        System.out.println("총 수익률은 " + rate + "입니다.");

        return rate;
    }


    //   수익률 구하는 메소드
    private BigDecimal rateResult(Map<LottoType, Long> winningStatistics, int amount) {
        return BigDecimal.valueOf(totalWinnings(winningStatistics))
                .divide(BigDecimal.valueOf(amount), 2, RoundingMode.DOWN);
    }

    // 총 당첨금 을 구하는 메소드
    private int totalWinnings(Map<LottoType, Long> winningStatistics) {
        return winningStatistics.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPriceMultiply(entry.getValue()))
                .reduce(0, Integer::sum);
    }

    private void printWinningList(Map<LottoType, Long> winningResult) {
        winningResult.forEach((key, value) -> System.out.println(key.getPrintString() + "- " + value + "개"));
    }

    private void printTickets(ManyTickets tickets) {
        tickets.getManyTickets().forEach(ticket -> System.out.println(ticket.toString()));
    }
}
