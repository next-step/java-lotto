package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SPLIT_TEXT = ",";
    private static final int MIN_WIN_MATCH_COUNT = 3;

    private LottoNumber winningNumbers;
    private List<LottoNumber> purchaseLottoNumbers;

    public ResultView(String inputText) {
        this(inputText, null);
    }

    public ResultView(String inputText, List<LottoNumber> purchaseLottoNumbers) {
        Set<Integer> numbers = splitWinningNumber(inputText);
        winningNumbers = new LottoNumber(numbers);
        this.purchaseLottoNumbers = purchaseLottoNumbers;
    }

    private Set<Integer> splitWinningNumber(String inputText) {
        return Arrays
                .stream(inputText.split(SPLIT_TEXT))
                .map(num -> Integer.parseInt(num))
                .collect(Collectors.toSet());
    }

    public List<WinningLotto> getWinningLottos() {
        List<WinningLotto> winningLottos = new ArrayList<>();
        Set<Integer> winningNums = winningNumbers.getNumbers();
        for (int i = 0; i < purchaseLottoNumbers.size(); i++) {
            int matchCount = 0;
            Set<Integer> purchaseNumbers = purchaseLottoNumbers.get(i).getNumbers();
            matchCount = repeatByWinNumberSize(winningNums, matchCount, purchaseNumbers);

            if (matchCount >= MIN_WIN_MATCH_COUNT) {
                winningLottos.add(new WinningLotto(matchCount, LottoWinningInfo.valueOf(matchCount)));
            }
        }
        return winningLottos;
    }

    private int repeatByWinNumberSize(Set<Integer> winningNums, int matchCount, Set<Integer> purchaseNumbers) {
        for (Integer winningNum : winningNums) {
            matchCount = checkCotainsWinNumber(matchCount, purchaseNumbers, winningNum);
        }
        return matchCount;
    }

    private int checkCotainsWinNumber(int matchCount, Set<Integer> purchaseNumbers, Integer winningNum) {
        if (purchaseNumbers.contains(winningNum)) {
            ++matchCount;
        }
        return matchCount;
    }

}
