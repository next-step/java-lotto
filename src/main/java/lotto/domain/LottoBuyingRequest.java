package lotto.domain;

import static lotto.domain.LottoMachine.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lotto.function.TransformElement;

public class LottoBuyingRequest {

    private static final String INVALID_MANUAL_LOTTO_COUNT_MESSAGE = "로또를 구매할 수 있는 돈이 부족합니다.";
    private static final String NO_MANUAL_LOTTO_NUMBER_MESSAGE = "수동 로또 번호가 없습니다.";

    private final Money money;
    private final ManualLottoNumbers manualLottoNumbers;
    private final int autoLottoCount;

    public LottoBuyingRequest(Money money, ManualLottoNumbers manualLottoNumbers) {
        this.manualLottoNumbers = validManualLottoNumbers(manualLottoNumbers);
        this.money = validMoney(money, manualLottoNumbers.count());
        autoLottoCount = totalLottoCount() - manualLottoCount();
    }

    private ManualLottoNumbers validManualLottoNumbers(ManualLottoNumbers manualLottoNumbers) {
        return Optional.ofNullable(manualLottoNumbers)
            .orElseThrow(() -> new IllegalArgumentException(NO_MANUAL_LOTTO_NUMBER_MESSAGE));
    }

    private Money validMoney(Money money, int manual) {
        return Optional.ofNullable(money)
            .filter(mon -> mon.countOfLottoTickets(PRICE) - manual >= 0)
            .orElseThrow(() -> new IllegalArgumentException(INVALID_MANUAL_LOTTO_COUNT_MESSAGE));
    }

    private int totalLottoCount() {
        return money.countOfLottoTickets(PRICE);
    }

    public int autoLottoCount() {
        return autoLottoCount;
    }

    public int manualLottoCount() {
        return manualLottoNumbers.count();
    }

    public List<String> manualLottoNumberStrings() {
        return new TransformElement<LottoNumberText, String>()
            .andThen(Collections::unmodifiableList)
            .apply(manualLottoNumbers.toList(),
                LottoNumberText::text);
    }
}
