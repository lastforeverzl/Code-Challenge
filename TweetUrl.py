import tweepy
from tweepy import OAuthHandler
from tweepy.streaming import StreamListener
from tweepy import Stream
import time
import json
import sys

consumer_key="1OUJYFdmFXQjOzIn4480ZA"
consumer_secret="LeEmIC7h7V8zOzCFnU28yf701FWnVN54WU2Mcq38w"
access_token="928154652-W2P0CcI6qzuuK6exl2adM8QJiK3wvYP1VEkB2g2B"
access_token_secret="25v3sxAe0rKetNXCcE2lsqzJLR9YNM013ap2ORLRT8c"

auth = OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)

class StdOutListener(StreamListener):
	def __init__(self):
		self.tweets = []
		self.starttime = time.strftime("%d_%H_%M",time.localtime())
	def on_data(self, data):
		tweet = json.loads(data)
		if tweet['entities']['urls']:
			i = tweet['entities']['urls'][0]['expanded_url']
			print i
		else:
			return True

def main():
	lis = StdOutListener()
	auth = OAuthHandler(consumer_key, consumer_secret)
	auth.set_access_token(access_token, access_token_secret)
	hashtag = raw_input('Please input a hashtag: ')
	stream = Stream(auth, lis)
	stream.filter(track=['#'+hashtag])

if __name__ == '__main__':
	main()
