package step2.domain;

import java.util.stream.Collectors;

import step2.dto.LottosDto;

public class UserPickLottosFactory implements LottoFactory<LottosDto, Lottos> {
    @Override
    public Lottos apply(LottosDto lottosDTO) {
        return new Lottos(lottosDTO.getLottos()
                                   .stream()
                                   .map(lottoDTO -> Lotto.create(lottoDTO.getLottoNumbers()))
                                   .collect(Collectors.toList()));
    }
}
