package me.devyonghee.lotto.view.dto;

import me.devyonghee.lotto.model.Lotto;
import me.devyonghee.lotto.model.LottoNumber;
import me.devyonghee.lotto.model.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public final class LottosResponse {

    private final long manualCount;
    private final long autoCount;
    private final List<List<Integer>> lottos;

    private LottosResponse(long manualCount, long autoCount, List<List<Integer>> lottos) {
        this.manualCount = manualCount;
        this.autoCount = autoCount;
        this.lottos = lottos;
    }

    public static LottosResponse from(Lottos lottos) {
        return new LottosResponse(lottos.manualCount(), lottos.autoCount(),
                lottos.list()
                        .stream()
                        .map(LottosResponse::from)
                        .collect(Collectors.toList()));
    }

    private static List<Integer> from(Lotto ticket) {
        return ticket.numbers()
                .collection()
                .stream()
                .map(LottoNumber::number)
                .sorted()
                .collect(Collectors.toList());
    }

    public long getManualCount() {
        return manualCount;
    }

    public long getAutoCount() {
        return autoCount;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
