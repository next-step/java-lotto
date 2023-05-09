package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoDtos {
    private final List<LottoDto> lottoDtos;
    public LottoDtos(List<LottoDto> lottoDtos) {
        this.lottoDtos = new ArrayList<>(lottoDtos);
    }

    @Override
    public String toString() {
        return lottoDtos.stream()
                .map(LottoDto::toString)
                .collect(Collectors.joining("\n"));
    }
}
