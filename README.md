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
  <tr><th>Commit</th><th>Alphabet</th><th>#increasing words</th><th>Notes</th></tr>
  <tr><td><a href="https://github.com/dvberkel/letter-soup/blob/2ce42220ec8ef0001e89db2461ef0754069d11ad/increasing.txt">2ce4222</a></td><td>JQMPBFCUWHOVATRLKIZNEXDGSY</td><td>3203</td><td></td></tr>
  <tr><td><a href="https://github.com/dvberkel/letter-soup/blob/febdf9500d333c70a2a2b0e28c03c6e9872e0eba/increasing.txt">febdf95</a></td><td>JQMPBFCUWHOVA<strong>RLT</strong>KIZNEXDGSY</td><td>3248</td><td></td></tr>
  <tr><td><a href="https://github.com/dvberkel/letter-soup/blob/f6a8c3276dcaad87b5bf63a92c013d48769544e6/increasing.txt">f6a8c32</a></td><td>JQMPBFCUWHOVA<strong>RTL</strong>KIZNEXDGSY</td><td>3248</td><td></td></tr>
  <tr><td><a href="https://github.com/dvberkel/letter-soup/blob/f6ce2bc42d72a96fdf5ceab4f66ccfd23c173645/increasing.txt">f6ce2bc</a></td><td>JQMPBFC<strong>WHOVAUR</strong>TLKI<strong>NZXE</strong>DG<strong>YS</strong></td><td>3660</td><td>local maximum</td></tr>
</table>

Methods
-------

### Steepest Ascent

[Steepest ascent][ascent] is an optimalisation technique that only
needs local information. Basically it tries all "directions" for an
improvement and picks the one with the greatest improvement.


run the following command and it will take a random permutation of the
alphabet and start a steeperst ascend from there.

```shell
./steepest_ascend.rb
```

<table>
  <tr><th>Start</th><th>Finish</th><th>#increasing words</th><th>Notes</th></tr>
  <tr><td>JQMPBFCUWHOVARTLKIZNEXDGSY</td><td>JQMPBFCWHOVAURTLKINZXEDGYS</td><td>3660</td><td>Record</td></tr>
  <tr><td>ABCDEFGHIJKLMNOPQRSTUVWXYZ</td><td>ABCDFGHJKELMOINPQURTVWSXZY</td><td>1488</td><td></td></tr>
  <tr><td>SCIWYUNVDLGBTREMJFKXZHPAQO</td><td>SCWYUINVDBGTLERMJAKFXZPHQO</td><td>679</td><td></td></tr>
  <tr><td>KVPLGYFWBUHORQTMSAIJCXEDZN</td><td>KVPGFLWYBHOURQATMINSJCEXDZ</td><td>1812</td><td></td></tr>
  <tr><td>PKCYVTNQGDMAESXUJOBFRIHLWZ</td><td>PKCYVNTQADGMESXJURBOWFHILZ</td><td>702</td><td></td></tr>
  <tr><td>NVKUHMPBJWDRLIYSCGXQAEFZOT</td><td>NVKHMPBJWURIDLSCGXYQEAFZOT</td><td>858</td><td></td></tr>
  <tr><td>PAEHSCINMWZVKJGRTOQFYXULDB</td><td>PSECWHAINMZVKGJORTQFXYULDB</td><td>1019</td><td></td></tr>
  <tr><td>KMWRHNJGZCYBAIULDPOFXETQVS</td><td>KMWGRHNJZCAYUBILODPFXETQVS</td><td>1655</td><td></td></tr>
  <tr><td>YSXOGKQCAHPULWEJNDFIZBVMRT</td><td>YSXGKQCPOWHAULJINEDFZRBVMT</td><td>1388</td><td></td></tr>
  <tr><td>FDBGUMHWTOYIZARKECLQJPNSXV</td><td>FDBGMUTWHORAYIZCKLEQJPNSXV</td><td>1959</td><td></td></tr>
  <tr><td>SITYLRPQJDAWFMCVGUXBZENKOH</td><td>STPLYRIQJADWMFCVUGXBONZKHE</td><td>900</td><td></td></tr>
  <tr><td>ZLBOPVMKHWFXUREIDGYTQCASNJ</td><td>ZBPVLMOKWHUFXRIEDTGYQCANSJ</td><td>1580</td><td></td></tr>
  <tr><td>HYEVIPUQJGNTWLSOKBXFDZMCAR</td><td>HVYPEQJUINGTOWLKBSXFDZMCAR</td><td>751</td><td></td></tr>
  <tr><td>GMCJUILWDXNOTSQHFBARYZEPKV</td><td>GMCJLWUDOINXSTQHARFBZEPKVY</td><td>1229</td><td></td></tr>
  <tr><td>DLEQVTZOJKUFSAWBNMRGCXIYHP</td><td>DLEQVTZJKFSOWBURAMNGCXHIPY</td><td>860</td><td></td></tr>
  <tr><td>OEAQPYIFXCWBZHLVKNGMDURTJS</td><td>OEQFPYXCWBZLHAVURINKGMDTJS</td><td>1359</td><td></td></tr>
  <tr><td>BDGLCZFRIYJATXMEQNKHSOPUWV</td><td>BDGCLZFYRJAXITMEQNKHOWUPVS</td><td>1342</td><td></td></tr>
  <tr><td>CUJTBVLYWMRODGXPAKZNSEFQIH</td><td>CJTBVLWYUMOARDGXPKZENFSQHI</td><td>1422</td><td></td></tr>
  <tr><td>ZTBKXCJOYVPRQWIAUFDENLSGHM</td><td>ZTBKXCJVOYPRAQWUFINDGLESHM</td><td>1998</td><td></td></tr>
  <tr><td>XRPIHOBEJTUQYMNAKGDCSFLZWV</td><td>XPBRHJOUTEQMAYINKGLDCFZWVS</td><td>1645</td><td></td></tr>
</table>

[words]: https://raw.github.com/dvberkel/letter-soup/master/words.txt
[ascent]: http://en.wikipedia.org/wiki/Gradient_descent
