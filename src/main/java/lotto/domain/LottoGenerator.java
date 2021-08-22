package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

  private static final List<Integer> CANDIDATE_NUMBERS = initCandidateNumbers();

  public static List<Lotto> generate(long cnt) {
    checkCnt(cnt);
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < cnt; i++) {
      lottos.add(new Lotto(selectedNumbers()));
    }
    return lottos;
  }

  private static List<Integer> selectedNumbers() {
    Collections.shuffle(CANDIDATE_NUMBERS);
    return CANDIDATE_NUMBERS.subList(0, Lotto.NUMBER_SIZE);
  }

  private static List<Integer> initCandidateNumbers() {
    return IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
        .boxed().collect(Collectors.toList());
  }

  private static void checkCnt(long cnt) {
    if (cnt <= 0) {
      throw new IllegalArgumentException("생성하려는 로또의 수를 1개 이상 입력해주세요.");
    }
  }
}
