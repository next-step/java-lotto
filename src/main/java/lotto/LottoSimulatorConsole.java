package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoSimulatorConsole {

    private static final Scanner IN = new Scanner(System.in);

    private static final String LINE_SP = System.lineSeparator();

    private LottoSimulator lottoSimulator = new LottoSimulator(new RandomLottoNumberGenerator());

    private void run() {
        buy();

        List<LottoNumber> winningNumbers = inputWinningNumbers();

        printResult(winningNumbers);
    }

    private void buy() {
        System.out.println("구입금액을 입력해 주세요.");

        int cost = IN.nextInt();

        List<LottoGame> boughtGames = lottoSimulator.buy(cost);

        System.out.println(boughtGames.size() + "개를 구매했습니다.");

        for(LottoGame lottoGame : boughtGames) {
            String numbers = lottoGame.getNumbers().stream()
                    .sorted()
                    .map(number -> number.toString())
                    .collect(Collectors.joining(", ", "[", "]"));

            System.out.println(numbers);
        }
    }

    private List<LottoNumber> inputWinningNumbers() {
        System.out.println(LINE_SP + "지난 주 당첨 번호를 입력해 주세요.");

        String winningNumbersString = IN.next();
        List<LottoNumber> winningNumbers = Arrays.stream(winningNumbersString.split(","))
                .map(token -> new LottoNumber(Integer.parseInt(token.trim())))
                .collect(Collectors.toList());

        return winningNumbers;
    }

    private void printResult(List<LottoNumber> winningNumbers) {
        LottoResult winnerResult = lottoSimulator.getWinnerResult(winningNumbers);

        System.out.println(LINE_SP + "당첨 통계" + LINE_SP + "---------");

        List<LottoPlace> winnerPlaces = LottoPlace.getWinnerPlaces();
        for (LottoPlace winnerPlace : winnerPlaces) {
            int count = winnerResult.getWinnerPlaceCount(winnerPlace);

            System.out.printf("%d개 일치 (%d원)- %d개" + LINE_SP,
                    winnerPlace.getNumMatched(), winnerPlace.getPrize(), count);
        }

        System.out.printf("총 수익률은 %.2f입니다." + LINE_SP, winnerResult.getProfitRatio());
    }

    public static void main(String[] args) {
        new LottoSimulatorConsole().run();
    }

}
