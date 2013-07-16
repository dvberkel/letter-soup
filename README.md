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

[words]: https://raw.github.com/dvberkel/letter-soup/master/words.txt
