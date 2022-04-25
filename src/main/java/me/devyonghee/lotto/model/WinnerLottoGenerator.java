package me.devyonghee.lotto.model;

import me.devyonghee.common.StringsProvider;

import java.util.Objects;
import java.util.stream.Collectors;

public final class WinnerLottoGenerator {

    private static final String NULL_PROVIDER_ERROR_MESSAGE = "provider must not be null";
    private static final String NULL_BONUS_NUMBER_ERROR_MESSAGE = "bonus number must not be null";

    private final StringsProvider provider;
    private final LottoNumber bonusNumber;

    private WinnerLottoGenerator(StringsProvider provider, LottoNumber bonusNumber) {
        Objects.requireNonNull(provider, NULL_PROVIDER_ERROR_MESSAGE);
        Objects.requireNonNull(bonusNumber, NULL_BONUS_NUMBER_ERROR_MESSAGE);
        this.provider = provider;
        this.bonusNumber = bonusNumber;
    }

    public static WinnerLottoGenerator of(StringsProvider provider, LottoNumber bonusNumber) {
        return new WinnerLottoGenerator(provider, bonusNumber);
    }

    public WinnerLotto lotto() {
        return WinnerLotto.of(
                Lotto.from(LottoNumbers.from(provider.strings()
                        .stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toList()))),
                bonusNumber
        );
    }
}
