package camp.nextstep.edu.lotto.domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.fail;

public interface LotteriesRewardHelper {
    default LotteriesReward createLotteriesReward(EnumMap<RewardType, Integer> rewardMap) {
        try {
            Constructor<LotteriesReward> constructor = LotteriesReward.class.getDeclaredConstructor(Map.class);
            constructor.setAccessible(true);
            return constructor.newInstance(rewardMap);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ignored) {
            return fail("Failed to create instance of LotteriesReward.class");
        }
    }
}
