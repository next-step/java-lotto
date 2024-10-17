package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final int purchaseAmount;
    private static final int PURCHASE_PRICE = 1000;
    private static final int LIMIT_AMOUNT = 100000;

    public LottoGenerator(int purchaseAmount) {
        if(purchaseAmount > LIMIT_AMOUNT) {
            throw new IllegalArgumentException("구매금액은 " + LIMIT_AMOUNT + "를 초과할 수 없습니다.");
        }
        this.purchaseAmount = purchaseAmount;
    }

    public List<Lotto> generateLottoTickets() {
        return chooseLottoNumber(purchase());
    }

    public int purchase() {
        return this.purchaseAmount / PURCHASE_PRICE;
    }

    public List<Lotto> chooseLottoNumber(int purchaseCount) {
        List<Integer> initialLottoNumbers = generateInitialLottoNumber();
        List<Lotto> purcahsedLottoList = new ArrayList<>();

        for(int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = getWinningNumbers(initialLottoNumbers);
            purcahsedLottoList.add(new Lotto(numbers));
        }

        return purcahsedLottoList;

    }

    private List<Integer> generateInitialLottoNumber() {
        List<Integer> initialLottoNumbers = new ArrayList<>();
        for(int i =1; i <= 45; i++) {
            initialLottoNumbers.add(i);
        }
        return initialLottoNumbers;
    }

    private List<Integer> getWinningNumbers(List<Integer> initialNumbers) {
        Collections.shuffle(initialNumbers);
        return initialNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    public List<Integer> parseWinningNumbers(String winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .filter(number -> !number.isBlank())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
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
                ", purchaseAmount=" + purchaseAmount +
                '}';
    }


}
