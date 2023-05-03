package lotto.model.dto;

import lotto.model.Lottos;

import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LottosDto {
    private final List<LottoDto> lottos;

    private LottosDto(List<LottoDto> lottoDtos) {
        this.lottos = lottoDtos;
    }

    public static LottosDto from(Lottos lottos) {
        List<LottoDto> lottoDtos = lottos.stream()
                .map(LottoDto::from)
                .collect(toList());

        return new LottosDto(lottoDtos);
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(LottoDto::toString)
                .collect(joining("\n"));
    }
}
