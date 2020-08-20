package lotto.ui.output;

import lotto.ui.ChannelTypes;

import static lotto.ui.ChannelTypes.SYSTEM;

public interface OutputChannel {

	static OutputChannel getChannel(ChannelTypes channelTypes) {
		return channelTypes.getOutputChannel();
	}

	static OutputChannel getSystemOutChannel() {
		return getChannel(SYSTEM);
	}

	void printLine(String input);
}
