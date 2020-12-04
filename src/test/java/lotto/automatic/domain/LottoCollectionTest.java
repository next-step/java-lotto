package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoCollectionTest {

    @Test
    @DisplayName("로또 컬렉션 생성 테스트 ")
    public void creation_로또_컬렉션_인스턴스() {

        LottoCollection collection = new LottoCollection(asList(Lotto.auto(), Lotto.auto()));
        assertThat(collection.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 컬렉션에 추가")
    public void append_로또_컬렉션() {

        LottoCollection lottoCollection = new LottoCollection(asList(Lotto.auto(), Lotto.auto()));

        lottoCollection.append(Lotto.auto());
        assertThat(lottoCollection.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("로또 컬렉션에 리스트 추가")
    public void append_로또_컬렉션_리스트_추가() {

        LottoCollection lottoCollection = new LottoCollection(asList(Lotto.auto(), Lotto.auto()));

        lottoCollection.append(asList(Lotto.auto(), Lotto.auto()));
        assertThat(lottoCollection.size()).isEqualTo(4);

    }

    @Test
    @DisplayName("로또 컬렉션에 컬렉션 추가")
    public void append_로또_컬렉션_컬렉션_추가() {

        LottoCollection lottoCollection1 = new LottoCollection(asList(Lotto.auto(), Lotto.auto()));
        LottoCollection lottoCollection2 = new LottoCollection(asList(Lotto.auto(), Lotto.auto()));

        lottoCollection1.append(lottoCollection2);
        assertThat(lottoCollection1.size()).isEqualTo(4);

    }

}
