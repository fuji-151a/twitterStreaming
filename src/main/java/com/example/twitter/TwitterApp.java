package com.example.twitter;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.User;

public class TwitterApp {

	/**
	 * @param args
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
		User user = twitter.verifyCredentials();
		
		// ユーザ情報を取得
		System.out.println("名前			：" + user.getName());
		System.out.println("表示名		：" + user.getScreenName());
		System.out.println("フォロー数		：" + user.getFriendsCount());
		System.out.println("フォロワー数	：" + user.getFollowersCount());
		
		// ツイートしてみる
		//Status status = twitter.updateStatus("my tweet. test.");
	}

}
