package lotto.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottosDto {
    private final List<LottoDto> lottos;
    public LottosDto(List<LottoDto> lottoDtos) {
        this.lottos = new ArrayList<>(lottoDtos);
    }
    public List<LottoDto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
