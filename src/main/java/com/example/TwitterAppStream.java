package com.example;

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
	public void onStatus(Status status) {
		System.out.println(status.getText());
	}
}