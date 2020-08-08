package camp.nextstep.edu.rebellion.lotto.rule;

import java.io.*;
import java.util.Properties;

public class LottoGameRulePropertiesLoader {

    private static final String RESOURCE = "lotto-game-rule.properties";

    private LottoGameRulePropertiesLoader() {}

    public static Properties load() {
        InputStream inputStream = LottoGameRulePropertiesLoader.class.getClassLoader()
                .getResourceAsStream(RESOURCE);
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
        } catch (Exception e) {
            throw new IllegalArgumentException("로또 게임 Rule 을 읽어오는 데 실패하였습니다");
        }

        return properties;
    }
}
