package AutoLotto.domain.lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLotto {

    private final List<LottoNumber> userLotto;

    public UserLotto() {
        this.userLotto = createLotto();
    }

    public List<LottoNumber> getUserLotto() {
        return userLotto;
    }

    private static List<LottoNumber> createLotto() {
            List<LottoNumber> lottoNumberList = IntStream.range(1, 45).mapToObj(LottoNumber::new).collect(Collectors.toList());
            Collections.shuffle(lottoNumberList);
            return lottoNumberList.stream().limit(6).collect(Collectors.toList());
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

