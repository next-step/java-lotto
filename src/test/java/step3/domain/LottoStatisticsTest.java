package step3.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    @DisplayName("통계 데이터를 요청하면, 데이터에 상관없이 이하 형태의 리스트 데이터를 가져옴"
        + "제목 행, 구분선, 맞춘 개수 당 통계 데이터 1줄씩 총 4줄(3, 4, 5, 6), 총 수익률"
        + "합쳐서 7행")
    @Test
    void dataSizeTest() {
        RandomLottoCreator creator = new RandomLottoCreator();
        LottoStatistics lottoStatistics = new LottoStatistics(creator.create());

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lottos.add(creator.create());
        }

        List<String> statistics = lottoStatistics.getStatistics(lottos);
        System.out.println(statistics.size());
    }
}
