package AutoLotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static AutoLotto.utils.Constants.*;

public class UserLotto {

    private final List<LottoNumber> userLotto;

    public UserLotto() {
        this (createLotto());  //테스트 후 다시 복구
    }

    public UserLotto(List<LottoNumber> userLotto) {
        this.userLotto = userLotto;
    }

    public List<LottoNumber> getUserLotto() {
        return userLotto;
    }

    private static List<LottoNumber> createLotto() {
            List<LottoNumber> lottoNumberList = IntStream
                                                    .rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
                                                    .mapToObj(number -> new LottoNumber(number))
                                                    .collect(Collectors.toList());
            Collections.shuffle(lottoNumberList);
            return lottoNumberList.stream()
                        .limit(LOTTO_NUMBER_COUNT)
                        .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        UserLotto userLotto1 = (UserLotto) o;
        return Objects.equals(userLotto, userLotto1.userLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLotto);
    }
}

