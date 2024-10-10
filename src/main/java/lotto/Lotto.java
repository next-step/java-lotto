package lotto;

import java.util.*;

public class Lotto {
    public static final String IS_NOT_LOTTO_SIZE = "번호가 6개가 아닙니다.";
    private final List<Integer> lottoNumbers;

    public Lotto() {
        this(makeAutoLotto());
    }

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoSetSize(lottoNumbers);
        this.lottoNumbers = makeSortLotto(lottoNumbers);
    }

    private static List<Integer> makeAutoLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    private static List<Integer> makeSortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private void validateLottoSetSize(List<Integer> lottoSet) {
        if (lottoSet.size() != 6) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoResult(Lotto winningLotto) {
        int equalCount = 0;
        List<Integer> winningLottoNumbers = winningLotto.getLottoNumbers();
        for (int i = 0; i < winningLottoNumbers.size(); i++) {
            equalCount += addCount(winningLottoNumbers.get(i));
        }
        return getRank(equalCount);
    }

    private int addCount(int winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    private int getRank(int equalCount){
        if(equalCount==6){
            return 1;
        }
        if(equalCount==5){
            return 3;
        }
        if(equalCount==4){
            return 4;
        }
        if(equalCount==3){
            return 5;
        }
        return 6;
    }
}
