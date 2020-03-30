package lotto;

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
    private static final int MIN_WIN_MATCH_COUNT = 3;
    private static final int MIN_PURCHASE_AMOUNT = 1000;

    private Scanner scanner = new Scanner(System.in);
    private LottoNumber winningNumbers;
    private LottoTicket lottoTicket;
    private Map<String, WinningLotto> winningLottos;
    private int bonusBall;

    public ResultView() {
    }

    public ResultView(int bonusBall) {
        validateBonusBall(bonusBall);
        this.bonusBall = bonusBall;
    }

    public ResultView(String inputText) {
        this(inputText, null, 0);
    }

    public ResultView(LottoTicket lottoTicket) {
        String inputText = enterWinningValue();
        int bonusBall = enterBonusValue();
        validateBonusBall(bonusBall);

        this.bonusBall = bonusBall;
        Set<Integer> numbers = splitWinningNumber(inputText);
        winningNumbers = new LottoNumber(numbers);
        this.lottoTicket = lottoTicket;
        this.winningLottos = getWinningLottos();

    }

    public ResultView(String inputText, LottoTicket lottoTicket, int bonusBall) {
        validateBonusBall(bonusBall);
        this.bonusBall = bonusBall;
        Set<Integer> numbers = splitWinningNumber(inputText);
        winningNumbers = new LottoNumber(numbers);
        this.lottoTicket = lottoTicket;
        this.winningLottos = getWinningLottos();
        this.bonusBall = bonusBall;
    }

    public Map<String, WinningLotto> getWinningLottos() {
        Map<String, WinningLotto> winningLottos = new HashMap<>();
        Set<Integer> winningNums = winningNumbers.getNumbers();
        for (int i = 0; i < lottoTicket.getLottoNumbers().size(); i++) {
            int matchCount = 0;
            Set<Integer> purchaseNumbers = lottoTicket.getLottoNumbers().get(i).getNumbers();
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
        for (LottoNumber lottoNumber : lottoTicket.getLottoNumbers()) {
            result += lottoNumber.getNumbers() + "\n";
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

    public void validateBonusBall(int bonusBall) {
        if (bonusBall < 1 || bonusBall > 45) {
            throw new IllegalArgumentException("입력할 수 있는 범위는 1~45 사이입니다.");
        }
    }

    public boolean checkMatchBonusBall(Set<Integer> lottoNumber) {
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

    private int enterBonusValue() {
        System.out.println("\n보너스 볼을 입력해 주세요");
        return scanner.nextInt();
    }

    private String enterWinningValue() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.next();
    }

    private String getResultByRank(String result, Rank value, String key, int matchCount, int resultCount) {
        if (SECOND_NAME.equals(key)) {
            result += matchCount + "개 일치, 보너스 볼 일치(" + value.getWinningAmount() + "원)- " + resultCount
                      + "개\n";
            return result;
        }
        result += matchCount + "개 일치(" + value.getWinningAmount() + "원)- " + resultCount + "개\n";

        return result;
    }

}
