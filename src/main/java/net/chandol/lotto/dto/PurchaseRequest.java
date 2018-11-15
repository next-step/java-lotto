package net.chandol.lotto.dto;

import net.chandol.lotto.value.LottoNumber;
import net.chandol.lotto.value.Money;

import java.util.List;

import static java.util.Objects.isNull;
import static net.chandol.lotto.util.LottoNumberConstants.LOTTO_PRICE;

public class PurchaseRequest {
    private Money totalPrice;
    private List<LottoNumber> directLottoNumbers;

    public PurchaseRequest(Money totalPrice, List<LottoNumber> directLottoNumbers) {
        validateRequest(totalPrice, directLottoNumbers);
        this.totalPrice = totalPrice;
        this.directLottoNumbers = directLottoNumbers;
    }

    public Money getTotalPrice() {
        return totalPrice;
    }

    public List<LottoNumber> getDirectLottoNumbers() {
        return directLottoNumbers;
    }

    public int getDirectLottoCount() {
        return directLottoNumbers.size();
    }

    public int getAutoLottoCount() {
        int totalLottoCount = totalPrice.divideAsNumber(LOTTO_PRICE);
        return totalLottoCount - getDirectLottoCount();
    }

    private static void validateRequest(Money totalPrice, List<LottoNumber> directLottoNumbers) {
        if (isNull(totalPrice) || isNull(directLottoNumbers)) {
            throw new IllegalArgumentException("입력값은 null이 될 수 없습니다.");
        }

        int totalCount = totalPrice.divideAsNumber(LOTTO_PRICE);
        if (totalCount < directLottoNumbers.size()) {
            throw new IllegalArgumentException("가용 금액이 부족합니다.");
        }
    }

}
