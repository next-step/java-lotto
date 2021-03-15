package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final ArrayList<Integer> lottoNumbers;
    private LottoPrice lottoPrice;

    public Lotto() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 46; i++) {
            lottoNumbers.add(i);
        }
        this.lottoPrice = new LottoPriceImpl();
    }

    public List<Integer> getLottoNumbers() {
        ArrayList<Integer> shuffledNumbers = (ArrayList<Integer>) lottoNumbers.clone();
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    public int howManyPass(int receiveMoney) {
        return this.lottoPrice.howManyPass(receiveMoney);
    }
}
