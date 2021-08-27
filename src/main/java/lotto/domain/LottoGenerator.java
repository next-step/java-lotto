package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

  private static final List<LottoNumber> CANDIDATE_LOTTO_NUMBERS = initCandidateLottoNumbers();

  public static List<Lotto> generatedLottosByRandomNumber(long cnt) {
    checkCnt(cnt);
    List<Lotto> lottos = new ArrayList<>();
    for (int i = 0; i < cnt; i++) {
      lottos.add(Lotto.issueByManual(selectedLottoNumbers().stream().map(LottoNumber::number).collect(Collectors.toList())));
    }
    return lottos;
  }

  private static List<LottoNumber> selectedLottoNumbers() {
    Collections.shuffle(CANDIDATE_LOTTO_NUMBERS);
    return new ArrayList<LottoNumber>(CANDIDATE_LOTTO_NUMBERS.subList(0, Lotto.NUMBER_SIZE));
  }

  private static List<LottoNumber> initCandidateLottoNumbers() {
    return IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
        .mapToObj(LottoNumber::new).collect(Collectors.toList());
  }

  private static void checkCnt(long cnt) {
    if (cnt <= 0) {
      throw new IllegalArgumentException("생성하려는 로또의 수를 1개 이상 입력해주세요.");
    }
  }
}
