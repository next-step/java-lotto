package step2.domain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class MakeLottoFactoryTest {

    private MakeLottoFactory makeLotto;
    private Lotto lotto;
    Lotto winningLotto;
    @BeforeEach
    void setUp() {
        makeLotto = new MakeLottoFactory(0);
        lotto = makeLotto.makeLottoWithString("1,2,3,4,5,6");
        winningLotto= makeLotto.makeLottoWithString("1,2,3,8,9,10");
    }
}
