package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printTickets(LottoTickets lottoTickets) {
        List<Ticket> tickets = lottoTickets.getTickets();
        tickets.stream().forEach(t -> System.out.println(numbersToString(t.getNumbers())));
    }

    public void printResult(int[] matchingResult, double returnRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + getMatchingResult(matchingResult, 3) + "개");
        System.out.println("4개 일치 (50000원) - " + getMatchingResult(matchingResult, 4) + "개");
        System.out.println("5개 일치 (1500000원) - " + getMatchingResult(matchingResult, 5) + "개");
        System.out.println("6개 일치 (2000000000원) - " + getMatchingResult(matchingResult, 6) + "개");
        System.out.println("총 수익률은 " + returnRate + "입니다.");
    }

    public int getMatchingResult(int[] matchingResult, int number) {
        return matchingResult[number];
    }

    public String numbersToString(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
