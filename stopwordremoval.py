import re,string
stop_sent=open("stopwords_en.txt").read()
stop_words=re.split('\r\n',stop_sent)
text=open("write.txt").read()
text=text.lower()
feed=text.translate(None, string.punctuation)
feed=feed.replace('\n',' ')
word=feed.split(' ')
print word
line=''
for i in range(len(word)):
	if word[i] in stop_words:
		pass
	else:
		line=line+word[i]+' '
text_file = open("modified_text.txt", "w")
text_file.write("%s"%line)
text_file.close()
