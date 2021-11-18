package step2.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import step2.model.Lotto;
import step2.model.Lottos;

public class LottoResultDto {

    private List<LottoDTO> lottoDTOs;
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int sixMatchCount;
    private double yield;

    public LottoResultDto(Lottos lottos, Lotto winner) {
        this.lottoDTOs = getLottoDtoList(lottos);
        Map<Integer, Integer> winners = lottos.getWinners(winner);
        threeMatchCount = winners.get(3);
        fourMatchCount = winners.get(4);
        fiveMatchCount = winners.get(5);
        sixMatchCount = winners.get(6);
        yield = lottos.getYield(winner);
    }

    private List<LottoDTO> getLottoDtoList(Lottos lottos) {
        return lottos.getLottos()
            .stream()
            .map(LottoDTO::new)
            .collect(Collectors.toList());
    }
}
