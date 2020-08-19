package step2.ui.input;

import step2.ui.ChannelTypes;

import static step2.ui.ChannelTypes.SYSTEM;

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
