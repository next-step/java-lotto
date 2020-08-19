package step2.ui.output;

import step2.ui.ChannelTypes;

import static step2.ui.ChannelTypes.SYSTEM;

public interface OutputChannel {

	static OutputChannel getChannel(ChannelTypes channelTypes) {
		return channelTypes.getOutputChannel();
	}

	static OutputChannel getSystemOutChannel() {
		return getChannel(SYSTEM);
	}

	void printLine(String input);
}
