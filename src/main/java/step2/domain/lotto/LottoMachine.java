package step2.domain.lotto;

import step2.domain.Money;
import step2.domain.exception.CustomException;
import step2.domain.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public int normalLottoCapacity(Money money) {
        return money.getAmount() / NormalLotto.PRICE;
    }

    public LottoList buyAutoLotto(int capacity) {
        return new LottoList(IntStream.range(0, capacity)
                .mapToObj(count -> new NormalLotto())
                .collect(Collectors.toList()));
    }

    public LottoList buyManualLotto(List<String> rawLottoList) {
        return LottoList.lottoList(rawLottoList);
    }

    public void verifyCapacity(Money amount, int rawManualLottoCount) {
        if (normalLottoCapacity(amount) < rawManualLottoCount) {
            throw new CustomException(ErrorCode.NOT_ENOUGH_MONEY);
        }
    }

    public int change(Money amount, int rawManualLottoCount) {
        return amount.getAmount() - rawManualLottoCount * NormalLotto.PRICE;
    }

}
