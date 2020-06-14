package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinnerLotto {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final List<Lotto> lottos;

    public WinnerLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Prize> getPrize(final List<Integer> winningLotto) {
        final List<Prize> prizes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Prize prize = Prize.valueOf(lotto.getLottoNumberMappingCount(winningLotto));
            prizes.add(prize);
        }
        return prizes;
    }

    public List<Integer> enterWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final String result = SCANNER.nextLine();
        return Arrays.stream(result.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
