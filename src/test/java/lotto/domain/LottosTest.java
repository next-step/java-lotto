package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    Lottos lottos;

    @BeforeEach
    void setUp(){
        lottos = new Lottos(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,2,3,4,5,45"),
                new Lotto("1,2,3,4,5,44"),
                new Lotto("1,2,3,4,30,45"),
                new Lotto("1,2,3,4,30,44"),
                new Lotto("1,2,3,20,30,45"),
                new Lotto("1,2,3,20,30,44"),
                new Lotto("1,2,3,20,30,43"),
                new Lotto("1,2,3,4,5,7")
        );
    }

}
