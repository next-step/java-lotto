package lotto.ui.input;

import lotto.ui.ChannelTypes;

import static lotto.ui.ChannelTypes.SYSTEM;

public interface InputChannel {

	static InputChannel getChannel(ChannelTypes channelTypes) {
		return channelTypes.getInputChannel();
	}

	static InputChannel getSystemInChannel() {
		return getChannel(SYSTEM);
	}

	int getIntValue();

	String getStringValue();
}
