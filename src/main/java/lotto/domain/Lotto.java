package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto implements Iterable<LottoNumber> {
    private static final int LOTTO_DIGIT = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validateLottoSize(lotto);
        this.lotto = lotto;
    }

    public static Lotto generateLotto(List<Integer> numbers) {
        validateDuplicateLottoNumber(numbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        numbers.forEach(number -> lottoNumbers.add(new LottoNumber(number)));

        return new Lotto(lottoNumbers);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public String getLottoNumber() {
        String i = lotto.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getLottoNumber()))
                .collect(Collectors.joining(","));
        return i;
    }

    private void validateLottoSize(List<LottoNumber> lottoNubmers) {
        if(lottoNubmers.size() != LOTTO_DIGIT) {
            throw new IllegalArgumentException("로또는 총 " + LOTTO_DIGIT + "개의 번호로 이뤄져 있습니다.");
        }
    }

    private static void validateDuplicateLottoNumber(List<Integer> lottoNumbers) {
        boolean duplicated = lottoNumbers.stream()
                .distinct()
                .count() != lottoNumbers.size();

        if(duplicated) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public Rank matchLotto(Lotto winningLotto) {
        int matchCount = 0;
        for(LottoNumber lottoNumber : winningLotto) {
            if(contains(lottoNumber)){
                matchCount ++;
            }
        }
        return Rank.getRank(matchCount);
    }

    public boolean contains(LottoNumber lottoNumber){
        for (int i = 0; i < lotto.size(); i++) {
            if(lotto.get(i).getLottoNumber() == lottoNumber.getLottoNumber()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lotto.iterator();
    }
}
