package step3.config;

import step3.strategy.LottoRandomShuffleStrategy;
import step3.strategy.LottoShuffleStrategy;

// 관심사 분리를 위한 AppConfig 클래스입니다.
public final class AppConfig {

    public static final LottoShuffleStrategy lottoShuffleStrategy() {
        return LottoRandomShuffleStrategy.getInstance();
    }
}
