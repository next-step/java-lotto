package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SPLIT_TEXT = ",";
    private static final int MIN_WIN_MATCH_COUNT = 3;
    private static final int MIN_PURCHASE_AMOUNT = 1000;

    private Scanner scanner = new Scanner(System.in);
    private LottoNumber winningNumbers;
    private List<LottoNumber> purchaseLottoNumbers;
    private Map<Integer, WinningLotto> winningLottos;

    public ResultView() {
    }

    public ResultView(String inputText) {
        this(inputText, null);
    }

    public ResultView(List<LottoNumber> purchaseLottoNumbers) {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String inputText = scanner.next();
        Set<Integer> numbers = splitWinningNumber(inputText);
        winningNumbers = new LottoNumber(numbers);
        this.purchaseLottoNumbers = purchaseLottoNumbers;
        this.winningLottos = getWinningLottos();
    }

    public ResultView(String inputText, List<LottoNumber> purchaseLottoNumbers) {
        Set<Integer> numbers = splitWinningNumber(inputText);
        winningNumbers = new LottoNumber(numbers);
        this.purchaseLottoNumbers = purchaseLottoNumbers;
        this.winningLottos = getWinningLottos();
    }

    public Map<Integer, WinningLotto> getWinningLottos() {
        Map<Integer, WinningLotto> winningLottos = new HashMap<>();
        Set<Integer> winningNums = winningNumbers.getNumbers();
        for (int i = 0; i < purchaseLottoNumbers.size(); i++) {
            int matchCount = 0;
            Set<Integer> purchaseNumbers = purchaseLottoNumbers.get(i).getNumbers();
            matchCount = repeatByWinNumberSize(winningNums, matchCount, purchaseNumbers);

            addWinningLotto(winningLottos, matchCount);
        }
        return winningLottos;
    }

    private void addWinningLotto(Map<Integer, WinningLotto> winningLottos, int matchCount) {
        if (matchCount < MIN_WIN_MATCH_COUNT) {
            return;
        }
        if (!winningLottos.containsKey(matchCount)) {
            LottoWinningInfo lottoWinningInfo = LottoWinningInfo.valueOf(matchCount);
            winningLottos.put(matchCount, new WinningLotto(lottoWinningInfo.getWinningAmount(), 1));
            return;
        }

        WinningLotto winningLotto = winningLottos.get(matchCount);
        winningLotto.addCount();

    }

    public String printPurchaseLottoNumbers(List<LottoNumber> lottoNumbers) {
        String result = "";
        for (LottoNumber lottoNumber : lottoNumbers) {
            result += lottoNumber.getNumbers() + "\n";
        }

        return result;
    }

    public String printWinningResult() {
        String result = "당첨통계\n---------\n";
        LottoWinningInfo[] values = LottoWinningInfo.values();
        for (LottoWinningInfo value : values) {
            int matchCount = value.getMatchCount();
            int resultCount = getResultCount(matchCount);
            result += matchCount + "개 일치(" + value.getWinningAmount() + "원)- " + resultCount + "개\n";
        }

        return result;
    }

    public String printeRevenuePercent() {
        String result = "총 수익률은 ";
        double revenuePercent = calculateRevenuePercent(totalWinningAmount(),
                                                        totalPurchaseAmount());
        result += revenuePercent + "입니다.";
        if (revenuePercent < 1) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        return result;
    }

    public double calculateRevenuePercent(int totalWinningAmount, int totalPurchaseAmount) {
        double revenuePercent = totalWinningAmount / (double) totalPurchaseAmount;
        double decimalPoint = Math.pow(10.0, 2);

        return Math.floor(revenuePercent * decimalPoint) / decimalPoint;
    }

    public int totalWinningAmount() {
        int totalWinningAmount = 0;
        for (Integer matchCount : winningLottos.keySet()) {
            totalWinningAmount += winningLottos.get(matchCount).getTotalAmount();
        }
        return totalWinningAmount;
    }

    public int totalPurchaseAmount() {
        return purchaseLottoNumbers.size() * MIN_PURCHASE_AMOUNT;
    }

    private int getResultCount(int matchCount) {
        int resultCount = 0;
        if (winningLottos.containsKey(matchCount)) {
            resultCount = winningLottos.get(matchCount).getCount();
        }
        return resultCount;
    }

    private Set<Integer> splitWinningNumber(String inputText) {
        return Arrays
                .stream(inputText.split(SPLIT_TEXT))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toSet());
    }

    private int repeatByWinNumberSize(Set<Integer> winningNums, int matchCount, Set<Integer> purchaseNumbers) {
        for (Integer winningNum : winningNums) {
            matchCount = checkContainsWinNumber(matchCount, purchaseNumbers, winningNum);
        }
        return matchCount;
    }

    private int checkContainsWinNumber(int matchCount, Set<Integer> purchaseNumbers, Integer winningNum) {
        if (purchaseNumbers.contains(winningNum)) {
            ++matchCount;
        }
        return matchCount;
    }

}
