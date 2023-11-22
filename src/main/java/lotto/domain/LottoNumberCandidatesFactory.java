package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberCandidatesFactory {

        private static final List<LottoNumber> lottoNumberCandidates = new ArrayList<>();

        private LottoNumberCandidatesFactory() {
        }

        public static List<LottoNumber> getInstance() {
                if (lottoNumberCandidates.isEmpty()) {
                        for (int i = 1; i <= 45; i++) {
                                lottoNumberCandidates.add(new LottoNumber(i));
                        }
                }
                return lottoNumberCandidates;
        }
}
