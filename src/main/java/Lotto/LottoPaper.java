package Lotto;


import java.util.*;

public class LottoPaper {

    private final int LOTTO_NUMBER_BOUND = 45;
    private final int LOTTO_MAX_LENGTH = 6;

    private List<Integer> lottoNumbers;

    public LottoPaper() {
        makeDeal();
    }

    public LottoPaper(LottoNumbers lottoNumberList) {
        this.lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoNumberList.getSize(); i++) {
            this.lottoNumbers.add(lottoNumberList.getNumber(i).getNumber());
        }
    }

    private List<Integer> makeDeal() {
        lottoNumbers = new ArrayList<>();

        for (int i = 1; i <= LOTTO_NUMBER_BOUND; i++) {
            lottoNumbers.add(i);
        }

        Collections.shuffle(lottoNumbers);

        lottoNumbers = lottoNumbers.subList(0, LOTTO_MAX_LENGTH);

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public int getSize() {
        return lottoNumbers.size();
    }

    public int getNumber(int index) {
        return lottoNumbers.get(index);
    }

    public boolean contains(int value) {
        return lottoNumbers.contains(value);
    }

    public boolean isMatchNumber(int prizeNumber) {
        return lottoNumbers.contains(prizeNumber);
    }

    public boolean isMatchBonus(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
