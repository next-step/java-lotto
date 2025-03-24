//package lotto.domain;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//class LottoResultAnalyzerTest {
//  @Test
//  @DisplayName("로또 결과 분석기는 1등~4등까지의 당첨 통계를 생성한다.")
//  void createLottoResult() {
//    LottoSet lottoSet = new LottoSet(   );
//
//    LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();
//    LottoResult lottoResult = lottoResultAnalyzer.createLottoResult();
//
//    assertThat(lottoResult.getWinningStatistics()).containsKey(WinningRank.FIRST);
//    assertThat(lottoResult.getWinningStatistics()).containsKey(WinningRank.SECOND);
//    assertThat(lottoResult.getWinningStatistics()).containsKey(WinningRank.THIRD);
//    assertThat(lottoResult.getWinningStatistics()).containsKey(WinningRank.FOURTH);
//  }
//
//  @Test
//  @DisplayName("로또 결과 분석기는 총 수익률을 계산한다.")
//  void createLottoROI() {
//    LottoResultAnalyzer lottoResultAnalyzer = new LottoResultAnalyzer();
//    LottoResult lottoResult = lottoResultAnalyzer.createLottoResult();
//
//    assertThat(lottoResult.getROI()).isInstanceOf();
//  }
//}
