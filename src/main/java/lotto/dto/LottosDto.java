package lotto.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottosDto {

    private final List<LottoDto> lottoDtos;

    public LottosDto(List<LottoDto> lottoDtos) {
        this.lottoDtos = lottoDtos;
    }

    public static LottosDto valueOf(Lottos lottos) {
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            lottoDtos.add(LottoDto.valueOf(lotto));
        }
        return new LottosDto(lottoDtos);
    }

    public Lottos toLottos() {
        List<List<Integer>> lottos = new ArrayList<>();
        for (LottoDto lottoDto : this.lottoDtos) {
            lottos.add(lottoDto.toLottoNumbers());
        }
        return new Lottos(lottos);
    }

    public List<LottoDto> getLottoDtos() {
        return lottoDtos;
    }
}
