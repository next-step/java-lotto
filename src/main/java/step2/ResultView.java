package step2;

import java.util.Scanner;

public class ResultView {
    private static final String BLANK = " ";
    private static final String COMMA = ",";

    public void getResultAndPrint(LottoTickets lottoTickets) {
        print("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String winningNumbers = scanner.nextLine();
        print(BLANK);

        String[] splitedWinningNumbers = splitByDelimiter(winningNumbers);

        printStats(lottoTickets.findWinning(splitedWinningNumbers), lottoTickets.getLottoTicketsSize());
    }

    private void printStats(WinningTickets winningTickets, int lottoTicketsSize) {
        print("당첨 통계");
        print("---------");

        print("3개 일치 (5000원) - " + winningTickets.getThirdWinningCount());
        print("4개 일치 (50000원) - " + winningTickets.getFourthWinningCount());
        print("5개 일치 (1500000원) - " + winningTickets.getFifthWinningCount());
        print("6개 일치 (2000000000원) - " + winningTickets.getSixthWinningCount());
        print("총 수익률은 " + winningTickets.getWinningPrice() / (InputView.LOTTO_TICKET_PRICE * lottoTicketsSize) + "입니다.");
    }

    private String[] splitByDelimiter(String winningNumbers) {
        return winningNumbers.split(COMMA);
    }

    public void print(String message) {
        System.out.println(message);
    }

}
