package lotto.view;

import static java.lang.System.out;
import static lotto.domain.LottoTicket.LOTTO_NUMBER_COUNT;
import static lotto.domain.LottoTicket.ONE_TICKET_PRICE;

import java.util.ArrayList;
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

    public int inputLottoBuyingManual() {
        out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int buyingManual = scanner.nextInt();

        if (buyingManual <= 0) {
            out.println("수동로또 구입 개수는 0 이상 입니다. ");
            return inputLottoBuyingManual();
        }

        return buyingManual;
    }

    public List<List<Integer>> inputManualLottoNumbers(int buyingManualCount) {
        out.println("수동로또 번호(들을)를 입력해 주세요.");
        List<String> manualLottoNumberStrings = new ArrayList<>();
        while (buyingManualCount-- > 0) {
            Scanner scanner = new Scanner(System.in);
            manualLottoNumberStrings.add(scanner.nextLine());
        }

        List<List<Integer>> manualLottos = new ArrayList<>();
        for (String manualLottoNumberString : manualLottoNumberStrings) {
            List<Integer> lottoNumbers = Arrays.stream(manualLottoNumberString.replaceAll(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            validateLottoNumbers(lottoNumbers);

            manualLottos.add(lottoNumbers);
        }

        return manualLottos;
    }

    private void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            out.println("로또 당첨 숫자는 "
                + LOTTO_NUMBER_COUNT +"개 입력해야 합니다.");
            out.println("다시 입력, ex) 1,2,3,4,5,6 ");
            System.exit(1);
        }
    }

    public List<Integer> inputWinLottoNumber() {
        out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String lottoNumberString = scanner.nextLine();

        List<Integer> lottoNumbers = Arrays.stream(lottoNumberString.replaceAll(" ", "").split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            out.println("로또 당첨 숫자는 "
                + LOTTO_NUMBER_COUNT +"개 입력해야 합니다.");
            out.println("다시 입력, ex) 1,2,3,4,5,6 ");
            return inputWinLottoNumber();
        }

        return lottoNumbers;
    }

    public int inputBonusBallNumber() {
        out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public void printLottoTickets(LottoTickets lottoTickets, int buyingManualCount) {
        out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.",
            buyingManualCount, lottoTickets.size()-buyingManualCount);
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
