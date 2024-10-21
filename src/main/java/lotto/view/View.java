package lotto.view;

import lotto.domain.InputNumber;
import lotto.vo.LottoCreateRequest;
import lotto.domain.Number;
import lotto.enumeration.LottoType;
import lotto.vo.LottoCreateResponse;
import lotto.vo.Winning;
import lotto.domain.Lotto;
import lotto.vo.WinningResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final String SEPARATOR = System.lineSeparator();
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_MANUAL_COUNT = SEPARATOR + "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTOS = SEPARATOR + "수동으로 구매할 번호를 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String OUTPUT_MANUAL_COUNT = SEPARATOR + "수동으로 ";
    public static final String OUTPUT_AUTO_COUNT = "장, 자동으로 ";
    public static final String OUTPUT_PURCHASE_LOTTOS = "개를 구매했습니다.";
    public static final String OUTPUT_WINNING_RESULT = SEPARATOR + "당첨 통계" + SEPARATOR + "---------" + SEPARATOR;
    public static final String OUTPUT_RANK_FIFTH = "개 일치 (5000원)- ";
    public static final String OUTPUT_RANK_FOURTH = "개 일치 (50000원)- ";
    public static final String OUTPUT_RANK_THIRD = "개 일치 (1500000원)- ";
    public static final String OUTPUT_RANK_SECOND = "개 일치, 보너스 볼 일치(30000000원) - ";
    public static final String OUTPUT_RANK_FIRST = "개 일치 (2000000000원)- ";
    public static final String OUTPUT_WINNING_COUNT = "개" + SEPARATOR;
    public static final String OUTPUT_TOTAL_PREFIX = "총 수익률은 ";
    public static final String OUTPUT_TOTAL_SUFFIX = "입니다.";

    public LottoCreateRequest input() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        int inputMoney = purchaseAmount(SCANNER.nextLine());

        System.out.println(INPUT_MANUAL_COUNT);
        int countManual = Integer.parseInt(SCANNER.nextLine());

        System.out.println(INPUT_MANUAL_LOTTOS);
        List<Lotto> manualLottos = manualLottos(countManual);
        return new LottoCreateRequest(inputMoney, manualLottos);
    }

    public static int purchaseAmount(final String value) {
        int purchaseAmount = Integer.parseInt(value);
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("The minimum purchase amount is 1,000.");
        }
        return purchaseAmount;
    }

    private static List<Lotto> manualLottos(final int countManual) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < countManual; i++) {
            String lotto = SCANNER.nextLine();
            String[] values = lotto.split(", ");
            List<Number> numbers = getNumbers(values);
            manualLottos.add(new Lotto(LottoType.MANUAL, numbers));
        }
        return manualLottos;
    }

    private static List<Number> getNumbers(final String[] values) {
        List<Number> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(new Number(Integer.parseInt(value)));
        }
        return numbers;
    }

    public void outputLottos(final LottoCreateResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append(OUTPUT_MANUAL_COUNT).append(response.getCountManual()).append(OUTPUT_AUTO_COUNT).append(response.getCountAuto()).append(OUTPUT_PURCHASE_LOTTOS).append(SEPARATOR);
        for (Lotto lotto : response.getLottos()) {
            sb.append(lotto).append(SEPARATOR);
        }
        System.out.println(sb);
    }

    public InputNumber inputNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        String winningNumbers = SCANNER.nextLine();
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = SCANNER.nextLine();
        return new InputNumber(winningNumbers, bonusNumber);
    }

    public void outputWinningResult(final WinningResult winningResult) {
        List<Winning> winnings = winningResult.getWinnings();
        System.out.println(OUTPUT_WINNING_RESULT +
                winnings.get(1).getRank().getCount() + OUTPUT_RANK_FIFTH + winnings.get(1).getCountWinning() + OUTPUT_WINNING_COUNT +
                winnings.get(2).getRank().getCount() + OUTPUT_RANK_FOURTH + winnings.get(2).getCountWinning() + OUTPUT_WINNING_COUNT +
                winnings.get(3).getRank().getCount() + OUTPUT_RANK_THIRD + winnings.get(3).getCountWinning() + OUTPUT_WINNING_COUNT +
                winnings.get(4).getRank().getCount() + OUTPUT_RANK_SECOND + winnings.get(4).getCountWinning() + OUTPUT_WINNING_COUNT +
                winnings.get(5).getRank().getCount() + OUTPUT_RANK_FIRST + winnings.get(5).getCountWinning() + OUTPUT_WINNING_COUNT +
                OUTPUT_TOTAL_PREFIX + winningResult.getTotalReturn() + OUTPUT_TOTAL_SUFFIX);
    }
}
