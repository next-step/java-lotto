package Lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPaper {

    private final int LOTTO_NUMBER_BOUND = 45;
    private final int LOTTO_MAX_LENGTH = 6;

    private List<Integer> lottoNumbers;

    public LottoPaper() {
        lottoNumbers = new ArrayList<>();
        makeDeal();
    }

    private List<Integer> makeDeal() {

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

}
