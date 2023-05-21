package lotto.domain;

import java.util.*;

public class LottoNumbers {
    public static final int CHOICE_COUNT = 6;
    public static final List<LottoNo> ALL_NUMBERS;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;

    static {
        ALL_NUMBERS = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            ALL_NUMBERS.add(LottoNo.of(i));
        }
    }

    private final List<LottoNo> lottoNos;

    public LottoNumbers(List<LottoNo> lottoNos) {
        validateCount(lottoNos);
        Collections.sort(lottoNos);
        this.lottoNos = lottoNos;
    }

    public static List<LottoNumbers> toList(List<List<Integer>> manualLottos) {
        if(manualLottos == null){
            return null;
        }
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (List<Integer> manualLotto : manualLottos){
            lottoNumbers.add(new LottoNumbers(LottoNo.toList(manualLotto)));
        }
        return lottoNumbers;
    }

    private void validateCount(List<LottoNo> lottoNos) {
        if (lottoNos.size() != CHOICE_COUNT) {
            throw new IllegalArgumentException("입력된 숫자 개수가 올바르지 않습니다.");
        }
    }

    public LottoNo find(int index) {
        return lottoNos.get(index);
    }

    public boolean contains(LottoNo number) {
        return lottoNos.contains(number);
    }

    public int countContains(Lotto otherLotto) {
        LottoNumbers otherLottoNumbers = otherLotto.numbers();
        int matchCount = 0;
        for (LottoNo number : otherLottoNumbers.lottoNos) {
            matchCount += checkMatch(number);
        }
        return matchCount;
    }

    private int checkMatch(LottoNo number) {
        if(contains(number)){
            return 1;
        }
        return 0;
    }

    public List<LottoNo> getValues() {
        return lottoNos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers lottoNumbers1 = (LottoNumbers) o;
        return Objects.equals(lottoNos, lottoNumbers1.lottoNos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNos);
    }
}
