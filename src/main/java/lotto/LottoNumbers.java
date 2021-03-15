package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;
    private LottoPrice lottoPrice;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 46; i++) {
            lottoNumbers.add(i);
        }
        this.lottoPrice = new LottoPriceImpl();
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    /**
     * 로또번호를 제공
     * @return
     */
    public List<Integer> getLottoNumbers() {
        List<Integer> cloneNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(cloneNumbers);
        return getSixNumbers(cloneNumbers);
    }

    /**
     * 6개의 번호를 전달
     * @param shuffledNumbers
     * @return
     */
    private List<Integer> getSixNumbers(List<Integer> shuffledNumbers) {
        return shuffledNumbers.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

    /**
     * 전달받은 금액으로 로또갯수를 반환
     * @param receiveMoney
     * @return
     */
    public int howManyPass(int receiveMoney) {
        return this.lottoPrice.howManyPass(receiveMoney);
    }
}
