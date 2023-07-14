package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;

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
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getLottoStatus() {
        return lottoStatus;
    }
}
