package view;

import domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResultView {
    private static final String WINNER_INPUT_ANNOUNCEMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_ANNOUNCEMENT = "보너스 볼을 입력해 주세요.";
    private final Scanner scanner;

    public ResultView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static LottoResult printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계\n"
                + "---------");
        System.out.println(lottoResultByRankToString(lottoResult, Rank.FOURTH));
        System.out.println(lottoResultByRankToString(lottoResult, Rank.THIRD));
        System.out.println(lottoResultByRankToString(lottoResult, Rank.SECOND));
        System.out.println(lottoResultByRankToString(lottoResult, Rank.FIRST));
        System.out.println(winningRateToString(lottoResult));
        return lottoResult;
    }

    private static String lottoResultByRankToString(LottoResult lottoResult, Rank rank) {
        return String.format("%d개 일치 (%s원)- %d개",
                rank.getMatchCount(), rank.getWinningMoney(), lottoResult.count(rank));
    }

    private static String winningRateToString(LottoResult lottoResult) {
        String result = "손해";
        if (lottoResult.isGain()) {
            result = "이득";
        }
        return String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", lottoResult.winningRate(), result);
    }

    public Winner scanWinner() {
        LottoNumbers winnerNumbers = scanWinnerNumbersWithAnnouncement();
        BonusNumber bonusNumber = scanBonusNumberWithAnnouncement();
        return createValidWinner(winnerNumbers, bonusNumber);
    }

    private Winner createValidWinner(LottoNumbers winnerNumbers, BonusNumber bonusNumber) {
        try {
            return new Winner(winnerNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return createValidWinner(winnerNumbers, scanBonusNumber());
        }
    }

    private LottoNumbers scanWinnerNumbersWithAnnouncement() {
        System.out.println(WINNER_INPUT_ANNOUNCEMENT);
        return scanWinnerNumbers();
    }

    private LottoNumbers scanWinnerNumbers() {
        String input = scanner.nextLine();
        List<Integer> inputNumbers = parseNumbers(input);
        try {
            return LottoNumbers.create(inputNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanWinnerNumbers();
        }
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private BonusNumber scanBonusNumberWithAnnouncement() {
        System.out.println(BONUS_INPUT_ANNOUNCEMENT);
        return scanBonusNumber();
    }

    private BonusNumber scanBonusNumber() {
        try {
            return new BonusNumber(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanBonusNumber();
        }
    }
}
