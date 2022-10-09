package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private final Lottos lottos;

    public static LottoResult of(Lottos lottos) {
        return new LottoResult(lottos);
    }

    public LottoResult(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<String> lottoInfos() {
        return lottos.values()
                .stream()
                .map(this::createLottoInfo)
                .collect(Collectors.toList());
    }

    private String createLottoInfo(Lotto lotto) {
        List<String> lottoStringNumbers = getStringNumbers(lotto);
        return "[ " + String.join(", ", lottoStringNumbers) + " ]";
    }

    private static List<String> getStringNumbers(Lotto lotto) {
        return lotto.lottoNumbers()
                .stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.number()))
                .collect(Collectors.toUnmodifiableList());
    }

    public Lottos lottos() {
        return lottos;
    }

    public int autoQuantity() {
        return (int) lottos.values()
                .stream()
                .filter(Lotto::isAuto)
                .count();
    }

    public int manualQuantity() {
        return (int) lottos.values()
                .stream()
                .filter(lotto -> !lotto.isAuto())
                .count();
    }

    public int quantity() {
        return lottos.values()
                .size();
    }
}
