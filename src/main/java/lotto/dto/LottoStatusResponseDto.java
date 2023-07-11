package lotto.dto;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.Lottos;

import java.util.List;
import java.util.stream.Collectors;

public class LottoStatusResponseDto {

    private final List<List<Integer>> lottoStatus;

    public LottoStatusResponseDto(Lottos lottos) {
        this.lottoStatus = lottos.getLottos().stream()
                .map(this::parseLotto)
                .collect(Collectors.toList());
    }

    private List<Integer> parseLotto(Lotto lotto) {
        return lotto.getLottoNumbers()
                .stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getLottoStatus() {
        return lottoStatus;
    }
}
