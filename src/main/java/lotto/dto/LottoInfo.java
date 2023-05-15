package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoInfo {

    private final List<String> lottoInfo;

    private LottoInfo(List<String> lottoInfo) {
        this.lottoInfo = lottoInfo;
    }

    public static LottoInfo from(Lotto lotto) {
        return new LottoInfo(lottoToInfo(lotto));
    }

    private static List<String> lottoToInfo(Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public List<String> getLottoInfo() {
        return lottoInfo;
    }
}
