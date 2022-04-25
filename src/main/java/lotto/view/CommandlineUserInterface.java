package lotto.view;

import static java.lang.System.out;
import static lotto.domain.LottoTicket.ONE_TICKET_LOTTO_NUMBER;
import static lotto.domain.LottoTicket.ONE_TICKET_PRICE;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Grade;
import lotto.domain.LottoResults;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class CommandlineUserInterface {

    private static final int MINIMUM_WIN_COUNT = 3;

    public int inputLottoBuyingBudget() {
        out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int buyingBudget = scanner.nextInt();

        if (buyingBudget <= 0 || buyingBudget % ONE_TICKET_PRICE != 0) {
            out.println("로또 구입 금액은 0 이상, "+
                ONE_TICKET_PRICE+"원 배수단위여야 합니다.");
            return inputLottoBuyingBudget();
        }

        return buyingBudget;
    }

    public List<Integer> inputWinLottoNumber() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String lottoNumberString = scanner.nextLine();

        List<Integer> lottoNumbers = Arrays.stream(lottoNumberString.replaceAll(" ", "").split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        if (lottoNumbers.size() != ONE_TICKET_LOTTO_NUMBER) {
            out.println("로또 당첨 숫자는 "
                +ONE_TICKET_LOTTO_NUMBER+"개 입력해야 합니다.");
            out.println("다시 입력, ex) 1,2,3,4,5,6 ");
            return inputWinLottoNumber();
        }

        return lottoNumbers;
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        out.println(lottoTickets.count() + "개를 구매했습니다.");
        List<LottoTicket> lottoTickets1 = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTickets1) {
            out.println(lottoTicket);
        }
    }

    public void print(LottoResults lottoResults) {
        Grade[] grades = Grade.values();
        Arrays.sort(grades);

        out.println("\n당첨통계\n--------");
        for (Grade grade : grades) {
            printWinLotteries(grade, lottoResults);
        }

        Double roi = lottoResults.getRoi();
        if (isOverInvestment(roi)) {
            out.print("총 투자대비수익률은 " + roi + "입니다.");
            out.println(" 기준이 1이기 때문에 결과적으로 이득이라는 의미");
            return;
        }

        out.println("총 투자대비수익률은 " + roi + "입니다.");
        out.println(" 기준이 1이기 때문에 결과적으로 손해라는 의미");
    }

    private void printWinLotteries(Grade grade, LottoResults lottoResults) {
        if (grade.getFitCount() < MINIMUM_WIN_COUNT) {
            return;
        }

        out.printf("%d개 일치 (%d원)\n",
            lottoResults.countOf(grade.getFitCount()),
            grade.getReward()
        );
    }

    private boolean isOverInvestment(Double roi) {
        return roi > 1;
    }

}
