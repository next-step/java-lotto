package lotto;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SPLIT_TEXT = ",";
    private static final String SECOND_NAME = "2등";
    private static final int MIN_WIN_MATCH_COUNT = LottoRule.MIN_WIN_MATCH_COUNT.getValue();
    private static final int MIN_PURCHASE_AMOUNT = LottoRule.MIN_PURCHASE_AMOUNT.getValue();

    private static ResultView resultView = new ResultView();
    private static Scanner scanner = new Scanner(System.in);

    private LottoNumbers winningNumbers;
    private LottoTicket lottoTicket;
    private Map<String, WinningLotto> winningLottos;
    private LottoNo bonusBall;

    public ResultView() {
    }

    public ResultView(int bonusBall) {
        this.bonusBall = new LottoNo(bonusBall);
    }

    public ResultView(String inputText) {
        this(inputText, null, 0);
    }

    public ResultView(String inputText, LottoTicket lottoTicket, int bonusBall) {
        this.bonusBall = new LottoNo(bonusBall);
        Set<LottoNo> numbers = splitWinningNumber(inputText);
        winningNumbers = new LottoNumbers(numbers);
        this.lottoTicket = lottoTicket;
        this.winningLottos = getWinningLottos();
    }

    public Map<String, WinningLotto> getWinningLottos() {
        Map<String, WinningLotto> winningLottos = new HashMap<>();
        Set<LottoNo> winningNums = winningNumbers.getNumbers();
        for (int i = 0; i < lottoTicket.getLottoNumbers().size(); i++) {
            int matchCount = 0;
            Set<LottoNo> purchaseNumbers = lottoTicket.getLottoNumbers().get(i).getNumbers();
            matchCount = repeatByWinNumberSize(winningNums, matchCount, purchaseNumbers);
            boolean matchBonus = checkMatchBonusBall(purchaseNumbers);

            addWinningLotto(winningLottos, matchCount, matchBonus);
        }
        return Collections.unmodifiableMap(winningLottos);
    }

    private void addWinningLotto(Map<String, WinningLotto> winningLottos, int matchCount, boolean matchBonus) {
        if (matchCount < MIN_WIN_MATCH_COUNT) {
            return;
        }
        if (!winningLottos.containsKey(matchCount)) {
            Rank rank = Rank.valueOf(matchCount, matchBonus);
            winningLottos.put(rank.getName(), new WinningLotto(rank.getWinningAmount(), 1));
            return;
        }

        WinningLotto winningLotto = winningLottos.get(matchCount);
        winningLotto.addCount();

    }

    public String printPurchaseLottoNumbers(LottoTicket lottoTicket) {
        String result = "";
        for (LottoNumbers lottoNumbers : lottoTicket.getLottoNumbers()) {
            result += lottoNumbers.getNumbers().stream().map(LottoNo::getNo).collect(Collectors.toList())
                      + "\n";
        }

        return result;
    }

    public String printWinningResult() {
        String result = "당첨통계\n---------\n";
        Rank[] values = Rank.values();
        for (Rank value : values) {
            String key = value.getName();
            int matchCount = value.getMatchCount();
            int resultCount = getResultCount(key);
            result = getResultByRank(result, value, key, matchCount, resultCount);

        }

        return result;
    }

    public String printRevenuePercent() {
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
        for (String name : winningLottos.keySet()) {
            totalWinningAmount += winningLottos.get(name).getTotalAmount();
        }
        return totalWinningAmount;
    }

    public int totalPurchaseAmount() {
        return lottoTicket.getLottoNumbers().size() * MIN_PURCHASE_AMOUNT;
    }

    public boolean checkMatchBonusBall(Set<LottoNo> lottoNumber) {
        boolean matchFlag = false;

        if (lottoNumber.contains(this.bonusBall)) {
            matchFlag = true;
        }
        return matchFlag;
    }

    private int getResultCount(String name) {
        int resultCount = 0;
        if (winningLottos.containsKey(name)) {
            resultCount = winningLottos.get(name).getCount();
        }
        return resultCount;
    }

    private Set<LottoNo> splitWinningNumber(String inputText) {
        return Arrays
                .stream(inputText.split(SPLIT_TEXT))
                .map(num -> new LottoNo(Integer.parseInt(num)))
                .collect(toSet());
    }

    private int repeatByWinNumberSize(Set<LottoNo> winningNums, int matchCount, Set<LottoNo> purchaseNumbers) {
        for (LottoNo winningNum : winningNums) {
            matchCount = checkContainsWinNumber(matchCount, purchaseNumbers, winningNum);
        }
        return matchCount;
    }

    private int checkContainsWinNumber(int matchCount, Set<LottoNo> purchaseNumbers, LottoNo winningNum) {
        if (purchaseNumbers.contains(winningNum)) {
            ++matchCount;
        }
        return matchCount;
    }

    public void enterValue() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String inputText = scanner.next();
        System.out.println("\n보너스 볼을 입력해 주세요");
        LottoNo bonusBall = new LottoNo(scanner.nextInt());

        this.bonusBall = bonusBall;
        Set<LottoNo> numbers = splitWinningNumber(inputText);
        winningNumbers = new LottoNumbers(numbers);
        this.winningLottos = getWinningLottos();
    }

    public String getResultByRank(String result, Rank value, String key, int matchCount, int resultCount) {
        if (SECOND_NAME.equals(key)) {
            result += matchCount + "개 일치, 보너스 볼 일치(" + value.getWinningAmount() + "원)- " + resultCount
                      + "개\n";
            return result;
        }
        result += matchCount + "개 일치(" + value.getWinningAmount() + "원)- " + resultCount + "개\n";

        return result;
    }

    public void setLottoTicket(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public static ResultView getResultView() {
        return resultView;
    }
}
