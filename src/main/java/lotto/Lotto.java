package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumberList;
    private final static int LOTTO_SIZE = 6;

    public static Lotto create(LottoGeneration generation) {
        List<Integer> numberList = generation.generate();
        validate(numberList);

        return new Lotto(createLottoNumberList(numberList));
    }

    private static void validate(List<Integer> integerList) {
        HashSet<Integer> integers = new HashSet<>(integerList);

        if (integers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("요청하신 번호 배열이 로또 사이즈" + LOTTO_SIZE + "와 일치하지 않습니다.");
        }
    }

    private static List<LottoNumber> createLottoNumberList(List<Integer> numberList) {
        List<LottoNumber> lottoNumbers = numberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumberList = lottoNumbers;
    }

    public List<LottoNumber> numbers() {
        return this.lottoNumberList;
    }

    @Override
    public String toString() {
        return lottoNumberList.toString();
    }

    public LottoPrize getMatchedLottoPrize(Lotto lotto) {
        long count = numbers().stream()
                .filter(numbers -> lotto.contain(numbers))
                .count();
        return LottoPrize.createPrize(count);
    }

    private boolean contain(LottoNumber otherLottoNumber) {
        return numbers().contains(otherLottoNumber);
    }

    public long getMatchedLottoPrizePrice(Lotto winnerLotto) {
        LottoPrize matchedLottoPrize = getMatchedLottoPrize(winnerLotto);
        if(matchedLottoPrize == null){
            return 0;
        }
        return matchedLottoPrize.getPrize();
    }
}
