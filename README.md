Letter Soup
===========

This repository contains a project to solve the Letter Soup
problem. I.e.

> What permutation of alphabet gives rise to the largest set of
> increasing words.

### Example

With the standard alphabet *ABCD...Z* an example of a increasing word
is _ABBOT_.

Observations
------------

Below are some characteristics of increasing words

* *Same letters occur consecutively*. Proof: If in a word the
   following letters occur, _..X...Y...X.._, then `X <= Y <= X`. Hence
   `X == Y`.

Library
-------

We will use the words of International Scrabble tournaments. Words
that could never by an increasing word for any alphabet are
removed. It contains a total of 67230 words.

It can be download from
[bit.ly/alphasoep](bit.ly/alphasoep "Link to the words"). A [copy][words] can
be found in this repository.

Usage
-----

Use the following command to recreate the alphabet

```shell
cat words.txt | ./count-pairs.pl | ./construct-alphabet.py > alphabet.txt
```

Once created the alphabet.txt is used to filter all the increasing
words with the following command

```shell
cat words.txt | ./increasing-words.rb
```

Records
-------

<table>
  <tr><th>Commit</th><th>Alphabet</th><th>#increasing words</th></tr>
  <tr><td>[2ce4222][]</td><td>JQMPBFCUWHOVATRLKIZNEXDGSY</td><td>3203</td></tr>
</table>

[words]: https://raw.github.com/dvberkel/letter-soup/master/words.txt
[2ce4222]: https://github.com/dvberkel/letter-soup/blob/2ce42220ec8ef0001e89db2461ef0754069d11ad/increasing.txt