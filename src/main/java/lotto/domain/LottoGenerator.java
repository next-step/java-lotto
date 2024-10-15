package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final int purchasePrice;
    private final int purchaseAmount;

    public LottoGenerator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.purchasePrice = 1000;
    }

    public int purchase() {
        return this.purchaseAmount / this.purchasePrice;
    }

    public List<Integer> parseWinningNumbers(String winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> getWinningNumbers(List<Integer> initialNumbers) {
        Collections.shuffle(initialNumbers);
        return initialNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> chooseLottoNumber(int purchaseCount) {
        List<Integer> initialLottoNumbers = generateInitialLottoNumber();
        return shuffleLottoNumber(initialLottoNumbers, purchaseCount);
    }

    private List<List<Integer>> shuffleLottoNumber(List<Integer> initialLottoNumbers, int purchaseCount) {

        List<List<Integer>> purcahsedLottoList = new ArrayList<>();

        for(int i = 0; i < purchaseCount; i++) {
            purcahsedLottoList.add(getWinningNumbers(initialLottoNumbers));
        }
        return purcahsedLottoList;
    }

    public List<Integer> generateInitialLottoNumber() {
        List<Integer> initialLottoNumbers = new ArrayList<>();
        for(int i =1; i <= 45; i++) {
            initialLottoNumbers.add(i);
        }
        return initialLottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGenerator lottoGenerator = (LottoGenerator) o;
        return purchaseAmount == lottoGenerator.purchaseAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(purchaseAmount);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "purchasePrice=" + purchasePrice +
                ", purchaseAmount=" + purchaseAmount +
                '}';
    }


}
