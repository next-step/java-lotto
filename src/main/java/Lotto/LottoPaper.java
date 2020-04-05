package Lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPaper {

    private final int LOTTO_NUMBER_BOUND = 45;
    private final int LOTTO_MAX_LENGTH = 6;

    private List<Integer> lottoPaper;

    public LottoPaper() {
        lottoPaper = new ArrayList<>();
        makeDeal();
    }

    private List<Integer> makeDeal() {

        for (int i = 1; i <= LOTTO_NUMBER_BOUND; i++) {
            lottoPaper.add(i);
        }

        Collections.shuffle(lottoPaper);
        lottoPaper = lottoPaper.subList(0, LOTTO_MAX_LENGTH);
        
        Collections.sort(lottoPaper);

        return lottoPaper;
    }

    public int getSize() {
        return lottoPaper.size();
    }

    public int getNumber(int index) {
        return lottoPaper.get(index);
    }

    public boolean contains(int value) {
        return lottoPaper.contains(value);
    }

}
