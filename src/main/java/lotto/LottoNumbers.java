package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int MAX_SIZE = 6;
    public static final int LOTTO_LIMIT_NUMBER = 46;
    private final List<Integer> lottoNumbers;
    private LottoPrice lottoPrice;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_LIMIT_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        this.lottoPrice = new LottoPrice();
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    /**
     * 로또번호를 제공
     * @return
     */
    public List<Integer> lottoNumbers() {
        List<Integer> cloneNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(cloneNumbers);
        return sixNumbers(cloneNumbers);
    }

    /**
     * 6개의 번호를 전달
     * @param shuffledNumbers
     * @return
     */
    private List<Integer> sixNumbers(List<Integer> shuffledNumbers) {
        return shuffledNumbers.stream()
                .limit(MAX_SIZE)
                .collect(Collectors.toList());
    }

    /**
     * 전달받은 금액으로 로또갯수를 반환
     * @param receiveMoney
     * @return
     */
    public int lottoCount(int receiveMoney) {
        return this.lottoPrice.lottos(receiveMoney);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
