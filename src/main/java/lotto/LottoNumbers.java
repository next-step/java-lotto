package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int MAX_SIZE = 6;
    public static final int LOTTO_LIMIT_NUMBER = 46;
    private List<Integer> lottoNumbers;
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
    public void mark() {
        Collections.shuffle(lottoNumbers);
        shuffle(lottoNumbers);
    }

    /**
     * 6개의 번호를 전달
     * @param shuffledNumbers
     * @return
     */
    private void shuffle(List<Integer> shuffledNumbers) {
        this.lottoNumbers = shuffledNumbers.stream()
                .limit(MAX_SIZE)
                .collect(Collectors.toList());
    }

    /**
     * 전달받은 금액으로 로또갯수를 반환
     * @param receiveMoney
     * @return
     */
    public int lottoCount(int receiveMoney) {
        return this.lottoPrice.lottoTicketNumber(receiveMoney);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }

    public boolean contains(int win) {
        return this.lottoNumbers.contains(win);
    }
}
