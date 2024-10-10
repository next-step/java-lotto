package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Objects;

public class PurchasedLottosDTO {
    private List<Lotto> purchasedLottos;

    PurchasedLottosDTO(List<Lotto> purchasedLottos) {
        this.purchasedLottos = purchasedLottos;
    }

    public static PurchasedLottosDTO valueOf(List<Lotto> purchasedLottos) {
        return new PurchasedLottosDTO(purchasedLottos);
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasedLottosDTO that = (PurchasedLottosDTO) o;
        return Objects.equals(purchasedLottos, that.purchasedLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(purchasedLottos);
    }
}
