package step2.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoPurchase {

    private final LottoPurchaseMoney lottoPurchaseMoney;
    private final LottoTicketCount lottoTicketCount;
    private final List<String> lottoManualNumbers;

    private static final int LOTTO_PRICE = 1000;

    public LottoPurchase(final int inputMoney) {
        this.lottoPurchaseMoney = new LottoPurchaseMoney(inputMoney);
        this.lottoTicketCount = new LottoTicketCount(inputMoney / LOTTO_PRICE,
            Collections.emptyList().size());
        this.lottoManualNumbers = new ArrayList<>();
    }

    public LottoPurchase(final int inputMoney, final List<String> inputManualNumbers) {
        this.lottoPurchaseMoney = new LottoPurchaseMoney(inputMoney);
        this.lottoTicketCount = new LottoTicketCount(inputMoney / LOTTO_PRICE,
            inputManualNumbers.size());
        this.lottoManualNumbers = new ArrayList<>(inputManualNumbers);
    }

    public LottoTicketCount getLottoTicketCount() {
        return lottoTicketCount;
    }

    public LottoPurchaseMoney getLottoPurchaseMoney() {
        return lottoPurchaseMoney;
    }

    public List<String> getLottoManualNumbers() {
        return Collections.unmodifiableList(lottoManualNumbers);
    }

    private void validateInputMoney(final int inputMoney) {
        if (inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또 구입 최소금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }
}
