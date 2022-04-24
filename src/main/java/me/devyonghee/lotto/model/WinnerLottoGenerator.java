package me.devyonghee.lotto.model;

import me.devyonghee.common.StringsProvider;

import java.util.Objects;
import java.util.stream.Collectors;

public final class WinnerLottoGenerator implements LottoTicketGenerator {

    private static final String NULL_PROVIDER_ERROR_MESSAGE = "provider must not be null";

    private final StringsProvider provider;

    private WinnerLottoGenerator(StringsProvider provider) {
        Objects.requireNonNull(provider, NULL_PROVIDER_ERROR_MESSAGE);
        this.provider = provider;
    }

    public static WinnerLottoGenerator from(StringsProvider provider) {
        return new WinnerLottoGenerator(provider);
    }

    @Override
    public Lotto lotto() {
        return Lotto.from(
                LottoNumbers.from(provider.strings()
                        .stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toList()))
        );
    }
}
