package lotto.domain.core;

import java.util.Collection;
import java.util.Objects;

import static java.lang.String.format;

class LottoNoValidator {
    static final int FROM_INDEX = 0;
    static final int MAX_LOTTO_NO_COUNT = 6;
    static final String ERROR_MESSAGE_DUPLICATE_LOTTO_NO = format("로또 번호는 중복 없이 %d개의 숫자만 등록 가능합니다.", MAX_LOTTO_NO_COUNT);

    static void verifyLottoNo(Collection<LottoNo> lottoNos) {
        verifyRequireNonNull(lottoNos);
        verifyRequireSixLottoNo(lottoNos);
        verifyDuplicateLottoNo(lottoNos);
    }

    static void verifyRequireNonNull(Object lottoNos) {
        if (Objects.isNull(lottoNos)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_LOTTO_NO);
        }
    }

    static void verifyRequireSixLottoNo(Collection<LottoNo> lottoNos) {
        if (MAX_LOTTO_NO_COUNT != lottoNos.size()){
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_LOTTO_NO);
        }
    }

    static void verifyDuplicateLottoNo(Collection<LottoNo> lottoNos) {
        long count = lottoNos.stream()
                             .distinct()
                             .count()
            ;
        if (MAX_LOTTO_NO_COUNT != count) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_LOTTO_NO);
        }
    }
}
