package step2.dto;

import step2.domain.request.Money;

public final class LottoCreationRequestDto {

    private final Money money;

    public static final LottoCreationRequestDto newInstance(int money) {
        return new LottoCreationRequestDto(money);
    }

    public static final LottoCreationRequestDto newInstance(Money money) {
        return new LottoCreationRequestDto(money);
    }

    private LottoCreationRequestDto(int money) {
        this(Money.valueOf(money));
    }

    private LottoCreationRequestDto(Money money) {
        this.money = money;
    }


    public final Money getMoney() {
        return money;
    }
}
