package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoRankCollectorTest {

    @Test
    @DisplayName("1등 당첨 로또를 소지한 경우 1등 랭크가 잘 나오는지 확인")
    public void 일등_당첨_로또를_소지한_경우_랭크_1등_확인() {

        LottoRankCollector collector = new LottoRankCollector(Arrays.asList(
                // 소지한 로또 1
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::new)
                        .collect(toList())),
                // 소지한 로또 2
                new Lotto(IntStream.rangeClosed(7, 12)
                        .mapToObj(LottoNumber::new)
                        .collect(toList()))),

                // 당첨 로또와 보너스 번호
                new WinningLotto(new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::new)
                        .collect(toList())),
                        new LottoNumber(45))

                );

        List<LottoRank> rankList = collector.getRankList();

        assertThat(rankList.contains(LottoRank.FIRST)).isTrue();

    }

    @Test
    @DisplayName("2등 당첨 로또를 소지한 경우 2등 랭크가 잘 나오는지 확인")
    public void 보너스_번호가_일치하는_2등_당첨_로또_확인() {

        LottoRankCollector collector = new LottoRankCollector(Arrays.asList(
                // 소지한 로또 1
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::new)
                        .collect(toList())),
                // 소지한 로또 2
                new Lotto(IntStream.rangeClosed(7, 12)
                        .mapToObj(LottoNumber::new)
                        .collect(toList()))),

                // 당첨 로또와 보너스 번호
                new WinningLotto(new Lotto(IntStream.rangeClosed(6, 11)
                        .mapToObj(LottoNumber::new)
                        .collect(toList())),
                        new LottoNumber(12))

                );

        List<LottoRank> rankList = collector.getRankList();

        assertThat(rankList.contains(LottoRank.SECOND)).isTrue();

    }

    @Test
    @DisplayName("2등 당첨 로또를 소지한 경우 2등 랭크가 잘 나오는지 확인")
    public void 이등_당첨_로또_확인2() {

        LottoRankCollector collector = new LottoRankCollector(Arrays.asList(
                new Lotto(Stream.of(16, 32, 39, 41, 43, 45).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(2, 8, 10, 18, 26, 30).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(7, 16, 21, 22, 33, 39).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(8, 9, 10, 14, 20, 25).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(1, 4, 21, 35, 37, 41).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(6, 8, 13, 15, 35, 36).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(10, 16, 20, 24, 32, 35).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(5, 13, 14, 21, 36, 39).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(1, 6, 13, 26, 44, 45).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList())),
                new Lotto(Stream.of(1, 9, 12, 13, 32, 36).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList()))
                ),
                // 당첨 로또와 보너스 번호
                new WinningLotto(
                        new Lotto(Stream.of(1, 9, 12, 13, 32, 35).flatMapToInt(IntStream::of).mapToObj(LottoNumber::new).collect(toList()))
                        ,
                        new LottoNumber(36))

                );

        List<LottoRank> rankList = collector.getRankList();

        System.out.println(rankList.toString());

        assertThat(rankList.contains(LottoRank.SECOND)).isTrue();

    }


}