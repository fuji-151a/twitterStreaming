package com.example.twitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import twitter4j.Status;
import twitter4j.StatusAdapter;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;

public class TwitterAppStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TwitterStreamのインスタンス作成
		TwitterStreamFactory factory = new TwitterStreamFactory();
		TwitterStream twitterStream = factory.getInstance();

		// Listenerを登録
		twitterStream.addListener(new Listener());

		// 実行
		twitterStream.sample();
	}
	
	
}
/** Tweetを出力するだけのListener */
class Listener extends StatusAdapter {
	// Tweetを受け取るたびにこのメソッドが呼び出される
	@Override
	public void onStatus(Status status) {
		if(isJapanese(status.getText())) {
			System.out.printf("%d\t%s\t%s\n", status.getId(), status.getUser().getScreenName(), status.getText());
		}
	}
	
	public boolean isJapanese(String text) {
		Matcher m = Pattern.compile("([\\p{InHiragana}\\p{InKatakana}])").matcher(text);
		return m.find();
	}
}