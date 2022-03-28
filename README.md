# README

## Project Description

We are developing a conversational agent named Serenity that talks to the user about their feelings and understands their emotional state, offers information and advice regarding their mental health. Depending on the user's detected emotional state, the bot will also alter how it talks to the user.

## How to run the code

1. Import this repository into Eclipse or IDE of your choice
2. Add the specified files as indicated in  ["required files.txt" ](https://github.com/COSC-310-Team-13/Assignment3/blob/main/required%20files.txt) to the classpath (files not included due to size constraint)
3. Run GUI

## Classes used

1. Bot : responsible for the agent's functionality, sets current input and sets current output based on input
2. GUI: creates the Graphical User Interface and uses the bot object to facilitate conversation
3. Optimizer: uses Lemmatization from CoreNLP Stanford toolkit to create an optimized search string by reducing to lemma and removes punctuation
4. LevenshteinDistance: Used as appears from Apache Lucene Search library, returns Levenshtein distance between two strings. Used to handle spelling errors
5. PoSTagger: uses Parts of Speech tagging from CoreNLP Stanford toolkit to retreive required part of speech
6. SentimentScorer: Uses Sentiment analysis from Stanford CoreNLP to extract mood score of the input
7. ReadFromFile: Used for reading values from a text file into a HashMap using specified delimiter





