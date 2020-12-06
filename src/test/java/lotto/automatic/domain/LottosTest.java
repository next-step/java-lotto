package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    @DisplayName("로또 컬렉션 생성 테스트 ")
    public void creation_로또_컬렉션_인스턴스() {

        Lottos collection = new Lottos(asList(Lotto.auto(), Lotto.auto()));
        assertThat(collection.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 컬렉션에 추가")
    public void append_로또_컬렉션() {

        Lottos lottos = new Lottos(asList(Lotto.auto(), Lotto.auto()));

        lottos.append(Lotto.auto());
        assertThat(lottos.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("로또 컬렉션에 리스트 추가")
    public void append_로또_컬렉션_리스트_추가() {

        Lottos lottos = new Lottos(asList(Lotto.auto(), Lotto.auto()));

        lottos.append(asList(Lotto.auto(), Lotto.auto()));
        assertThat(lottos.size()).isEqualTo(4);

    }

    @Test
    @DisplayName("로또 컬렉션에 컬렉션 추가")
    public void append_로또_컬렉션_컬렉션_추가() {

        Lottos lottos1 = new Lottos(asList(Lotto.auto(), Lotto.auto()));
        Lottos lottos2 = new Lottos(asList(Lotto.auto(), Lotto.auto()));

        lottos1.append(lottos2);
        assertThat(lottos1.size()).isEqualTo(4);

    }

}
