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
  <tr><td>OUAGLWSMKRDITHQCZPYXJBFVNE</td><td>OGSWLMAURKIDTHQCZPXYJBFVEN</td><td>893</td><td></td></tr>
  <tr><td>LNKITFWUYHGPRQOBAVEMDSZXJC</td><td>LKINFTWHUGYPRQOAMBVEDSZXJC</td><td>1164</td><td></td></tr>
  <tr><td>BWXAYCPZIJFHSNTDKLQGUMVREO</td><td>BWXCPYAZJFINDSTHOLKQUGMVER</td><td>1224</td><td></td></tr>
  <tr><td>WHERVXIJSNFPDOYULMKBZQCGTA</td><td>WRHVEXJINDFSPOYULMKBZQACGT</td><td>789</td><td></td></tr>
  <tr><td>HQJPZUCKYFWSXGMOINRTBAELDV</td><td>HQJPCUZFSKWYXGMOARINTBLVED</td><td>1623</td><td></td></tr>
  <tr><td>WJMGSYIXBZNROLFKHCEPQTUAVD</td><td>WJMGSYIXBRZONFCKPLHEQAUTVD</td><td>974</td><td></td></tr>
  <tr><td>DZQLBMRUYJNCWAKEFSGVOITHXP</td><td>DZQBLMURJANYCWKGEFVOITSHXP</td><td>1374</td><td></td></tr>
  <tr><td>KSYBPQWAICZRMFGTELVDXHJUON</td><td>KSBPYQWAICZRGMFLTVEDXHJOUN</td><td>1035</td><td></td></tr>
  <tr><td>DKATJPMOIEWYZBNLXCVSFRHUQG</td><td>DKTJAMOWPZBYINXLERCVFSHUQG</td><td>1445</td><td></td></tr>
  <tr><td>ESCMPUFGZANJXQKOVWDITLBYRH</td><td>ESCMPFUGAZNJXQOKVWRILDTBHY</td><td>1048</td><td></td></tr>
  <tr><td>ZSDRQJMAWXYNHLVTGKBOIPCFEU</td><td>ZDSRQJMWAXNHYOUTLVGIKBPCEF</td><td>950</td><td></td></tr>
  <tr><td>GLVICBXTRYEHUNZJOMSDQPWFAK</td><td>GVLICBXTHUYRENZJOMDSQAWPFK</td><td>1017</td><td></td></tr>
  <tr><td>TRPGDMJXUNYKHLOZFWAIVBEQCS</td><td>TPGDRMJUXNYKHOAWIZFLVBEQCS</td><td>1385</td><td></td></tr>
  <tr><td>TVYWKQEAGMNXZJRSDBCHFIPOLU</td><td>TVWKYEQGMANXZJRDBSCHOUILFP</td><td>839</td><td></td></tr>
  <tr><td>VKSYQOWAZTFRMJELPXIHCDGBUN</td><td>VSKYQWZFORATMJIPLEXCHUDGBN</td><td>1008</td><td></td></tr>
  <tr><td>PRBLEXFDTHIGAUZKYSMQJCOWNV</td><td>PBRLEXDFTHAUIGZMKYSQJCOWVN</td><td>930</td><td></td></tr>
  <tr><td>WSYNCHKXOBIJMPLDZQVUFTRAEG</td><td>WSYNCHOKXBJIMPALDZQUVFTERG</td><td>1328</td><td></td></tr>
  <tr><td>HLBVZWUIQTOCGANEMDKSRXJPFY</td><td>HBVZLWQUICOANTGMERDKSXJPFY</td><td>1970</td><td></td></tr>
  <tr><td>RASJVYDQHPWOXTNGCIKFLZMEBU</td><td>RSJVDYQPHOWANXGUTICKFZLMBE</td><td>1153</td><td></td></tr>
  <tr><td>SFUXTGZAPMVDWYEJBLONKQHRCI</td><td>SFXTGUMZPAVWDYJBOLNKEQHIRC</td><td>929</td><td></td></tr>
  <tr><td>OVFSMLXYJWPRZDQUATEINKCGHB</td><td>OVFSMLXYJWPARDZQUETINCKGHB</td><td>1026</td><td></td></tr>
  <tr><td>MUCSZXETPKYDVNLWOARBJGHIQF</td><td>MCUZSXPTKYEDVOWLARNBJGHQIF</td><td>794</td><td></td></tr>
  <tr><td>IHRTFPQZBYVNKMOWSJAXDLECUG</td><td>ITHFPRQZBOVAWYNKMSJUXDCGLE</td><td>963</td><td></td></tr>
  <tr><td>QMHUFNOJCZAWGRVIELDSKPXYTB</td><td>QMHFUNJCOWAZGRILVEDKPSXTBY</td><td>2113</td><td></td></tr>
  <tr><td>CJHPISANGVKEBUQLWZYORXDFMT</td><td>CJSPHAUINGKBVEQWZLORXDMFTY</td><td>1665</td><td></td></tr>
  <tr><td>TKOHDWRBPVYFIAZGJXMNQLEUSC</td><td>TKDHOWPBRAVFYIZGJXMNQUCLES</td><td>1725</td><td></td></tr>
  <tr><td>WTFSJRDVCXHYINELUQBGKAPZOM</td><td>WTFSDJVCRXHYUELINQBGKAPZOM</td><td>821</td><td></td></tr>
  <tr><td>MPAOQYZCVWKNDTGJLHEXIFBSRU</td><td>MPOQCZVWYANKDTGLJHEXURIFBS</td><td>1414</td><td></td></tr>
  <tr><td>QHJEXAGZKTLYPCNMSWUFVIDBRO</td><td>QHJEXGAZLKTYPCWUMNFVORIDBS</td><td>906</td><td></td></tr>
  <tr><td>IOPFRJASEKLUXGBTVWNMQZCHYD</td><td>IPFRSJLOAUKEXGTBVWNMQZCDHY</td><td>979</td><td></td></tr>
  <tr><td>JKUZLCVFPRTGYXNBEHIQDMSAWO</td><td>JKZCLUVPFTGYRNXBHIEQADOWMS</td><td>1056</td><td></td></tr>
  <tr><td>JRGXPKVNOWTQDICSUHLBYZEFAM</td><td>JGRXPKVNOWTQIDCUSHBZLEAFMY</td><td>967</td><td></td></tr>
  <tr><td>BCDJTEHMOXYQFPSKZWVGRLANUI</td><td>BCDJTHEMOXYQPFSKZWVAUIRGLN</td><td>935</td><td></td></tr>
  <tr><td>MALFTGCQXWKROVPEUYISJDNHBZ</td><td>MFLTAGCQXWROUKVPEYISJNDHBZ</td><td>1326</td><td></td></tr>
  <tr><td>GWFNBPJOETRVUXLIKAMDZYHSQC</td><td>GWFNBPJOTVREAUXILKMDZYSHQC</td><td>1568</td><td></td></tr>
  <tr><td>QRKXOYTJZNWVBSCMIPAHDELUFG</td><td>QKRXTYJZOWNVBSCAIMPHULEDFG</td><td>942</td><td></td></tr>
  <tr><td>QPAVLTUDNZGIRYEFCBWKHOXSMJ</td><td>QPVLTAUNDZGYRIEFCBWKHOXMSJ</td><td>1162</td><td></td></tr>
  <tr><td>IDCWEVZNOQLGHXRKBJSAYMUTPF</td><td>IDCWVZONEQGLHXRKBJAYUMPFTS</td><td>1231</td><td></td></tr>
  <tr><td>TPWBDGRLICNKOZAHYEUQJMFXVS</td><td>TWPBDGRICOANKZHLEYUQJMFXVS</td><td>1759</td><td></td></tr>
  <tr><td>UISRPWXTMJBZKLHONCEFVQGYAD</td><td>USPWRIXTMJBZLKHONCFVEQADGY</td><td>1044</td><td></td></tr>
  <tr><td>YGRLFDNHCOUIMAXSQBZPKJVEWT</td><td>YGFRLDNCHOAUIMXSQBZPKJVEWT</td><td>1096</td><td></td></tr>
  <tr><td>ECOFVWJXMBKINQGLSTHDZARYUP</td><td>ECFVWJOXMKBINQGLTSHARDZYUP</td><td>899</td><td></td></tr>
  <tr><td>UMYRKANOGBLJDVEWQZPXFTIHCS</td><td>UMKRYANGBJLODVWEQZPXIFTCHS</td><td>1196</td><td></td></tr>
  <tr><td>VKUSEANGQDZPOHBMXYFLTCWJIR</td><td>VSKNUGEQADZPHMBOXWFLCTYJIR</td><td>733</td><td></td></tr>
  <tr><td>HKPWDMAIJEOTYQULFGBVNZRXSC</td><td>HKPWADMJOITYEQULFGBVNZRXCS</td><td>1209</td><td></td></tr>
  <tr><td>KETJQXGRUOBNILVSCMZWFPDAYH</td><td>KTJEQXGBROUINLVCAWMSZFPDHY</td><td>1189</td><td></td></tr>
  <tr><td>YURLQXPIGDNAHFTJSVOZKEMWCB</td><td>YRLQUXPDIGANHFTJOVZKMEWCBS</td><td>976</td><td></td></tr>
  <tr><td>NLPGYZFMEOKHUDRCBIWJQVSTAX</td><td>NPGLZFYMOKHUREDCBWJQIVATSX</td><td>1149</td><td></td></tr>
  <tr><td>PNJVLQHMUZYGCSRTODWEAKBFIX</td><td>PNJVLQMHUZGYCOWTEARIDBKFSX</td><td>1422</td><td></td></tr>
  <tr><td>DWTGUJRNEPHXQLYMAFVCSKZIOB</td><td>DTWGJURENPHAXQLMFVYICKZOBS</td><td>1208</td><td></td></tr>
  <tr><td>SZBLFEOTJXWVUKDMHCIPYRQGNA</td><td>SZBFLTJOEXWVDUCMPKHRYQAING</td><td>1319</td><td></td></tr>
  <tr><td>YBTIPKXNWSAGHZMLDEJRQFVOCU</td><td>YBTPKIXNWAGZSHLMEDJRQFVCOU</td><td>661</td><td></td></tr>
  <tr><td>RQUVPSXLMIFDECYWTOGKBZJNHA</td><td>RQVSPXLUIMFEDCYOWTGKBZJANH</td><td>779</td><td></td></tr>
  <tr><td>FPONGEYSCKXHBMAWULQDRIJZVT</td><td>FPGNOSYECKXHMBAWULQIRDJZVT</td><td>856</td><td></td></tr>
  <tr><td>WKBYZCLUSAIHTJDQVFMEXNRGPO</td><td>WKBCZLYUSHADTJQIVMFEXRONGP</td><td>1144</td><td></td></tr>
  <tr><td>OJKZRBTSFQDMEVXIHANGLWCYUP</td><td>OJKZBFRSTQEDMVXHAINGWLCYUP</td><td>806</td><td></td></tr>
  <tr><td>MSCPAVJWYIKHFEGDUONBLXRQTZ</td><td>MSCPAVJWKHYIGFEDOULNBXRQTZ</td><td>1124</td><td></td></tr>
  <tr><td>PHQIKDLYNUBTCOSZXJMAVEFGWR</td><td>PHQKDILYUNBCOTZSXJAMVFGWER</td><td>997</td><td></td></tr>
  <tr><td>YQPDARCESXVUMIHTBNJFKZWGOL</td><td>YQPDARESCXVUMTHBINJFKZOWGL</td><td>831</td><td></td></tr>
  <tr><td>LMRETUOFGNDYXWVZJSHPAKICBQ</td><td>LMTFOREUNDGYXWVZJSHAIPCBKQ</td><td>822</td><td></td></tr>
  <tr><td>WVKFBLHUITRMCYDXQZAPENJGOS</td><td>WKVFBLHUITRMCDYXQAZPENJGOS</td><td>1327</td><td></td></tr>
  <tr><td>FOPJCBYMUNAIHDQWXTSGEKLZRV</td><td>FPJCBYMOAUINDHQWXTGLKZERVS</td><td>2489</td><td></td></tr>
  <tr><td>SAKHBLEGPRITFCJMVXUYZDNOQW</td><td>SKBGPHARIFCLTJUMVEXZONDYQW</td><td>1586</td><td></td></tr>
  <tr><td>JRCWKGQVMZFLSHEPOXBNYIUDTA</td><td>JCWKGRQVMZFSHOPLEAUNXBYIDT</td><td>1177</td><td></td></tr>
  <tr><td>DTOPQWUCNFKHIAEZRLSBXJMGYV</td><td>DPTOQWUNCFKHAIZERBLSXJGMVY</td><td>1571</td><td></td></tr>
  <tr><td>HWLAYCMPKZJUDXREVGTNSOFIBQ</td><td>HCLWYAMPKZJUDEXRVIGONFBTSQ</td><td>1563</td><td></td></tr>
  <tr><td>AZHTJUSDMGCEOQLRYVFNKWPIXB</td><td>AZTHJDSUMGCOEQRLYVWNFKIPXB</td><td>723</td><td></td></tr>
  <tr><td>TWHCMVSRUZFYBIJNDKQLOAEPGX</td><td>TCWHMVSURZBFJYINDKQOAPGLEX</td><td>1018</td><td></td></tr>
  <tr><td>WJNGLHKVQFOPIRETMXCZUDBASY</td><td>WGJNLKHVQFOPRITMEXCUZADBYS</td><td>1334</td><td></td></tr>
  <tr><td>VGMIODJFXKBTLPZAWUHYCQSERN</td><td>VGMDJFOIXKBPLATZWHUCYQERNS</td><td>1700</td><td></td></tr>
  <tr><td>BGCYHIXNKPDAJLREFUQZTOVSMW</td><td>BGCHXKAYINDPJURLEFQZOTVWMS</td><td>1703</td><td></td></tr>
  <tr><td>PGEBMYWVFROLIUSKTHNADJZCXQ</td><td>PGBMWYVFOURILKTESHANDJZCXQ</td><td>1530</td><td></td></tr>
  <tr><td>VGXNZEDUQITBCMPJLWKFSHOYAR</td><td>VGXNDZEQBUITCMPJWLKFSHOARY</td><td>802</td><td></td></tr>
  <tr><td>BLVSGHRPIDMZOWNQYATEFJCKUX</td><td>BVSGPHLRIMDZOWNQATEFYJUCKX</td><td>1061</td><td></td></tr>
  <tr><td>LSWCTXHODYQKZFGMVAIBRPJENU</td><td>LSCTWXHOADYQKZFGIMVBRPJUEN</td><td>1056</td><td></td></tr>
  <tr><td>SOFKNXVZIRLTJBHCYAGMQPEUDW</td><td>SFKNOXVRITZLJBCHAGYMQUPWED</td><td>1147</td><td></td></tr>
  <tr><td>AEFRGLVPCDSOIXJHMKBQUYTWZN</td><td>AFGVPRLECOIDSXJHUMKBQWNTZY</td><td>1118</td><td></td></tr>
  <tr><td>LTZYNGJUXRDBIHFCEMVQSWKPOA</td><td>LTZGYNJUXDBHRIEFCMVQOAWKPS</td><td>1056</td><td></td></tr>
  <tr><td>LEFZBJNVXSHYUPIKCMTGWROQDA</td><td>LFZBJVENXSPHYUICKMOTGWRQAD</td><td>649</td><td></td></tr>
  <tr><td>LVISRTMDJGHOFYKCZEBWPUXQAN</td><td>LVSTRIMDGJHOFYUCKZBEWPXQAN</td><td>791</td><td></td></tr>
  <tr><td>FZTQSLYNPIRDVWCEUMOGKXJBAH</td><td>FZSTQLYPINDVEROWUCGMKXJABH</td><td>816</td><td></td></tr>
  <tr><td>SVZTLEFWGIOHDXRNPQAJCMUYKB</td><td>SVZTFLWEGHIDOXRNPQJAUCMBKY</td><td>1053</td><td></td></tr>
  <tr><td>QIDOTRSEWMJNKLCZPVYFAHXBUG</td><td>QDTRISOWMNJECAKZPVFHLYUXBG</td><td>880</td><td></td></tr>
  <tr><td>VFGDCSOYURZNMPHXJBWKLIEQAT</td><td>VFGDSCYOURZNMPHXBJWILKEQAT</td><td>988</td><td></td></tr>
  <tr><td>DFKRGEQVWJLHUYPZTCIXOMBNAS</td><td>DFKGREQVWJLHYUIPZCOXTMABNS</td><td>1253</td><td></td></tr>
  <tr><td>CTGAWHLPEOKJSBIDNVRYZXMQFU</td><td>CTGWHALOPKJUBINERDVZYSXMQF</td><td>2174</td><td></td></tr>
  <tr><td>YGXRDFECPNOIWMTZVJABHQLSKU</td><td>YGXDFRECPOWMINTZVJABHQULKS</td><td>1266</td><td></td></tr>
  <tr><td>KNPIFMWZEXUHCOLRJVABQDYTSG</td><td>KNPFMWIZEXCHOURLJVABQDTGYS</td><td>1545</td><td></td></tr>
  <tr><td>YZFRBKXGLQWUPMTSNCDIJVHOEA</td><td>YZFBKRXGLQWUMPINTSCDJVHOAE</td><td>712</td><td></td></tr>
  <tr><td>VELUQXPTHOJSYFRWMZKBGICDNA</td><td>VLEQXPTHFJSWOURMZBKYIGCAND</td><td>776</td><td></td></tr>
  <tr><td>ANJZCHOBQXDMPGSEWULKIYFRTV</td><td>ANJZBCHOQXWDMPUIGFLKERTVYS</td><td>1962</td><td></td></tr>
  <tr><td>XPYALRKSBHUGOMTIEZDFQWVCJN</td><td>XPLYRASKBHOUGMITZEDFQWVCNJ</td><td>979</td><td></td></tr>
  <tr><td>PCXZLJDKVMHAYRGNQSETWIBUFO</td><td>PCXZLJDKVMHARNGYOEQWUBIFTS</td><td>1446</td><td></td></tr>
  <tr><td>GAMUDYCTPQSJBNOKLIXRFVEHWZ</td><td>GMDCYAPUTQSJBONKILXRFVHEWZ</td><td>871</td><td></td></tr>
  <tr><td>MIPWYQCKOSZVHNGATUFEJLRDXB</td><td>MPWYIQCOSKZVHAUNGFTJERLDXB</td><td>1380</td><td></td></tr>
  <tr><td>PFGVCWBELXRSIJODYZHANQUTMK</td><td>PFGVCWBLEXRISJODZHANYUQTMK</td><td>1072</td><td></td></tr>
  <tr><td>ACLTBKDPSRNYJWEVHUZXMOIFGQ</td><td>ACLTBKDSPYRNJEWVHUIZOXMFGQ</td><td>570</td><td></td></tr>
  <tr><td>ULRJEWMVPBIHKOZXQNGYCAFDST</td><td>ULRJWEMVPBHOKIZAXQNGCFDTYS</td><td>1461</td><td></td></tr>
  <tr><td>CATXMDPUVKHJRSQZBFIYEGNOLW</td><td>CTAXDMPVUKHJRSQZBFYINEGOWL</td><td>921</td><td></td></tr>
  <tr><td>QXBASGRMYCULZNIKETDJWHVOPF</td><td>QXBSGRMAYCULINZKTEDJWHVOPF</td><td>1094</td><td></td></tr>
  <tr><td>ACYMPKQDBHGZUTRFSVOWINJEXL</td><td>ACYMPKQDBGZHOURFTVWINSJEXL</td><td>1305</td><td></td></tr>
  <tr><td>PGUWAKMLNIHJTYFBCERZSOVQDX</td><td>PGKWMULAINHJFTBYCERZVOSQDX</td><td>1438</td><td></td></tr>
  <tr><td>MSRYJOPCBNALFUIHGWTDXEZKVQ</td><td>MSRJPYCBOAUINGWFLTHEDXZKVQ</td><td>1606</td><td></td></tr>
  <tr><td>HZAXQFUWNSGPEDVRCMJKLIBOTY</td><td>HZAXQWFUNGSPEDRVCMJOKBILTY</td><td>1025</td><td></td></tr>
  <tr><td>BEVYKUMJGLXZFPIWATSNCOHDRQ</td><td>BKVMYJEGULXZPFAWINCTHORDSQ</td><td>1452</td><td></td></tr>
  <tr><td>NWYMEGTLXIUKZJRSOVHFBPADCQ</td><td>NWMGYELXUKITZJORVSHAFBPDCQ</td><td>629</td><td></td></tr>
  <tr><td>NAXWRGJCBIQVMFSZUDEHKTOLYP</td><td>NAXGWRJBCQUIVMFZEDSHOLKPTY</td><td>1189</td><td></td></tr>
  <tr><td>JLYAUHWXSIGFBKROVPEMNQTZCD</td><td>JLWHYAUXGFBORISKMVPENQTZCD</td><td>1384</td><td></td></tr>
  <tr><td>KWFBTHLRIGJAMESDCZNUYOPVXQ</td><td>KWFBTHLRIGJAMEDSCZOUNPVXYQ</td><td>1128</td><td></td></tr>
  <tr><td>XPOKRLEBSQYGCDZIFMJHATUNVW</td><td>XPKBROLESQGCDZYIFMJHAUNTVW</td><td>802</td><td></td></tr>
  <tr><td>XLBQSDURYFZOGKEWHNIAVMPCJT</td><td>XBSLQDUFRZYOGKWHVEAMINPCJT</td><td>959</td><td></td></tr>
  <tr><td>AVBYGIWPOQUHMCXLFZEKJSRTDN</td><td>ABVGWPYOICQHMUXFZLKJERNDTS</td><td>1742</td><td></td></tr>
  <tr><td>LKUBCANTSFYIVWGHRMODPJZQXE</td><td>LKBCAUNFSTVYWIGHORMDPJZQEX</td><td>895</td><td></td></tr>
  <tr><td>GYQJFOUXIEBSHLWZCMDVTAPKNR</td><td>GYQJFOXBUSWHICZLMEDVARPNKT</td><td>1225</td><td></td></tr>
  <tr><td>GSRCAIFJOKDLEBNQUVHTWXYPMZ</td><td>GSCFRJOAUDKBILENQVWTHXMPZY</td><td>1450</td><td></td></tr>
  <tr><td>BALWCMFEOGYXDKPRZTJUNHQSVI</td><td>BCLWAMFGOXDKYPERTZJHUNQVIS</td><td>1338</td><td></td></tr>
  <tr><td>LGHCERDSMJYKWONUFTPBQZVIXA</td><td>LGCRHEDSMJYOWUNKPBFTQIZVAX</td><td>711</td><td></td></tr>
  <tr><td>REKYHPZMXTOFGLAIVCNSWQUJDB</td><td>RKHYMPZEXFTGOALVICWNSQJUDB</td><td>921</td><td></td></tr>
  <tr><td>BJAXUMVHNKFLWDPCSEGIRQYOZT</td><td>BJAXMVHUNKFWPIDCGLERSQOTZY</td><td>1543</td><td></td></tr>
  <tr><td>FYXCHDSTPUEZLRQANVKOJMWBGI</td><td>FXCHYDSPUTZERLQANVOKJWIMBG</td><td>821</td><td></td></tr>
  <tr><td>PWCKMBHRTLVZXOYGNQEIUSDAJF</td><td>PCWKMBTHORLVZYNXGQUIEADSJF</td><td>1498</td><td></td></tr>
  <tr><td>ROUADKXGHIYVZTPECSJBMLQNWF</td><td>RDOAUKXGHVZYIPCTESJLMBQWNF</td><td>788</td><td></td></tr>
  <tr><td>MKFXLRZQIHNYVBSDAJEPCUOTGW</td><td>MKFXLRZQHYINVBAPDSJCOUTGEW</td><td>828</td><td></td></tr>
  <tr><td>TNDGLOKAYXWFURCPZEVBHIQMJS</td><td>TNDGKLYOAXWFURCPZVBHIEQMJS</td><td>1218</td><td></td></tr>
  <tr><td>TGFPDOILVQHWXEJYKSNMBACURZ</td><td>TGFPDOLIVQWHXJNKEMBACYURZS</td><td>1283</td><td></td></tr>
  <tr><td>MZYJSPCXEIDGNHQTABUKORFVLW</td><td>MZYJSPECXDINGHQTBAUROKFVWL</td><td>857</td><td></td></tr>
  <tr><td>FPUGIZDSTLNJAWCOVXHQMYEKBR</td><td>FPGDUZSINLTJAWCOVXHQMKBERY</td><td>1331</td><td></td></tr>
  <tr><td>VOEBJXUAYCHGQIKLRPNDZWMFTS</td><td>VBJOEXGCHYQAURKILPNDZWMFTS</td><td>1501</td><td></td></tr>
  <tr><td>EVIRCTJDQNGWHLPSFBKMOAXYUZ</td><td>EVRICTJDQNGWHOAUPFBLMKSXZY</td><td>1096</td><td></td></tr>
  <tr><td>TJSVHGZKNYWXLAFECIQUMBDPRO</td><td>TJSVGZKHYNWAIXFCLEQUMBORDP</td><td>978</td><td></td></tr>
  <tr><td>NZVTXROMPKWJUYDBFQCGLIEAHS</td><td>NZVTXRMPOKWJUDBFYQICGLEASH</td><td>1184</td><td></td></tr>
  <tr><td>PXAEZKHTYFSBJQCOGWNRIDMVUL</td><td>PEAXZKTHFBYSJQCGOWURINDMVL</td><td>698</td><td></td></tr>
  <tr><td>DFYLXSKARQOUNETCZGVHBIMPJW</td><td>DFLXSKYAROQUNETCZGVHIMBPJW</td><td>754</td><td></td></tr>
  <tr><td>CMSNGADQZXBULYFOIRVWJKHTPE</td><td>CSMGANDQZXBUFLOYIRVWJKPTHE</td><td>1009</td><td></td></tr>
  <tr><td>YBMEXHQROKSLVZPGAJTWIUFNDC</td><td>YBMEXHQRLOKSVAZPGJWUTIFNDC</td><td>791</td><td></td></tr>
  <tr><td>REWHFXPYLNACGQZDJSTVMBUOIK</td><td>RWHFEXPLYANCGQDZJTVOUIMBKS</td><td>1095</td><td></td></tr>
  <tr><td>DKWHCYRQJONVUEMFLIBTZAGSPX</td><td>DKCWRHYQJOUMINVFBLETZAGPSX</td><td>1926</td><td></td></tr>
  <tr><td>LQTNPSFEBZADMYUJGHKCRVXWIO</td><td>LQSNPFTBEADZMYJUGCHRKVXWIO</td><td>618</td><td></td></tr>
  <tr><td>PFHZMOTGUQEDSRABCNXIKWLJYV</td><td>PFMZHOTGQUDBERANCSXWKILJVY</td><td>1374</td><td></td></tr>
  <tr><td>INVGBKWQAMTZULCYSDXEJHRPFO</td><td>INVGKBWQMAUTZCYLEDSXJHORPF</td><td>909</td><td></td></tr>
  <tr><td>WZUNJVQTCAMGYDPSLXRKBOFEHI</td><td>WZUNJVQTCMADGYPOLSXRBKEFHI</td><td>740</td><td></td></tr>
  <tr><td>SYGLMWIRNXCAZKHVDOUTJEFPBQ</td><td>SGLYMWARINXCZKHOUVDTJEFPBQ</td><td>1000</td><td></td></tr>
  <tr><td>WJNZMFREDVBTYQGUXKPSHIOACL</td><td>WJMNZFREDVTBYQUGXKPSHOICAL</td><td>637</td><td></td></tr>
  <tr><td>JTLSUZHARPIBKFONQVYCEWDMXG</td><td>JSTLZPBHAUROFKINQVWCEDMXGY</td><td>1805</td><td></td></tr>
  <tr><td>VYTMONJXAESQLZURFHBGCDWPIK</td><td>VTMYONJAXSEQLUZRFHBGCDWIPK</td><td>619</td><td></td></tr>
  <tr><td>DQLAVYBKOIMRTUJEXFSCNZGWPH</td><td>DQKVBALMYOURTJXIEFNCZGWPHS</td><td>1624</td><td></td></tr>
  <tr><td>OIEDKUHLVYBTNAPWRZQCFSGMXJ</td><td>ODKHULIVBYENTWARPZQCFGMSXJ</td><td>874</td><td></td></tr>
  <tr><td>OVHSJTFLQYBWMCXKPEUADIZGRN</td><td>OVSHJFTLQBWYUMCXPKEADZRING</td><td>1120</td><td></td></tr>
  <tr><td>VTNYGASOFRQJILPWUMEKHXZDCB</td><td>VTGSYNFAROQJWUIPLMKHEXDZCB</td><td>1106</td><td></td></tr>
  <tr><td>XJOFKYRUICDBSMATPNHVGWEZLQ</td><td>XFJKCYOURDBISMPANTHVGWZLEQ</td><td>1120</td><td></td></tr>
  <tr><td>QAXOYLMIPKGTUZVCWJNSFHEDRB</td><td>QAXLYMPOKGUITZVWCJNFSHERDB</td><td>1077</td><td></td></tr>
  <tr><td>VLKGNYWOCFSAHDEXUZBMRJIQTP</td><td>VKGLYNCOWFSHEAUDXZRMBJQIPT</td><td>951</td><td></td></tr>
  <tr><td>MJRWYLTZXBDSKEOGCFIUNPHQVA</td><td>MJWRLTZYXBODSKEUIGCFNPHQVA</td><td>616</td><td></td></tr>
  <tr><td>FHCQPOWSUYNDXAIGJZBETVMKRL</td><td>FSCHQPOWYAUNDXGJMIZBKTVERL</td><td>1595</td><td></td></tr>
  <tr><td>ZVIWQDSETOAJBCHMYPGLURKFNX</td><td>ZVWQDISTJBOECHAMPURGLKFNXY</td><td>1197</td><td></td></tr>
  <tr><td>KICVULYFQRWZDBMTJHEXGSAONP</td><td>KCVFLYIQWDURMTZBJHEAXGONPS</td><td>1234</td><td></td></tr>
  <tr><td>ZWXBAVSIREUTYKGDLPHFQOJCNM</td><td>ZWXBVSAURITKGLYPEDHQFJONCM</td><td>927</td><td></td></tr>
  <tr><td>RHQCEZTKMYUOFVJBDAWLINXGSP</td><td>RHEQCZTKYMOUFVJBAWLDINXGPS</td><td>1452</td><td></td></tr>
  <tr><td>NTGDHBLPJROSVQAXEKIFYCZMWU</td><td>NTGDHBPLJOVRSQAIXKEFCWZMYU</td><td>816</td><td></td></tr>
  <tr><td>BDLYRJGPUXQTMEKWSOCVZINFAH</td><td>BDLRYJUPGXQOTMKEAWCVIZNFSH</td><td>1251</td><td></td></tr>
  <tr><td>WOPEKIDNTCZRYFUBXGAHSJLVMQ</td><td>WPOKDINCTZERYUFBAXGSHJLVMQ</td><td>983</td><td></td></tr>
  <tr><td>EMPTRLJZNHOXCGVDSQWABIUFYK</td><td>EMPTRLJZHONXCAGVDSQWUIBFKY</td><td>760</td><td></td></tr>
  <tr><td>ZSROIYCPBXEMFTDHJLAKGNVWQU</td><td>ZSRYOICPBXMFTEDHJALNKGVWUQ</td><td>658</td><td></td></tr>
  <tr><td>VUIBFJQTEORCKLPNGMAWYXSHZD</td><td>VBFJQTURICPOKLEANGWMXDZYSH</td><td>1982</td><td></td></tr>
  <tr><td>WTJEMKUIDFNLRZXCQOYBGSVPAH</td><td>WTJMKDFUREINZLXCQOBGVAPYSH</td><td>1320</td><td></td></tr>
  <tr><td>EGALZXWSQPCDHVJYKMONIFTUBR</td><td>EGLAZXSWQPCDHVJKMYOURINFBT</td><td>799</td><td></td></tr>
  <tr><td>DFWOLQNXSYJCVURAHKTIBGMZEP</td><td>DFWLOQNXYSJCURVHABKITGMZPE</td><td>952</td><td></td></tr>
  <tr><td>DSGELHFVNWOMCPJIYUXTBRAZQK</td><td>DSGHFLENVOWMCPJAYUIXRBTZQK</td><td>929</td><td></td></tr>
  <tr><td>DPHMCTLKQISBRYXGWJAVEUZFON</td><td>DPHMCTKALQBRYISXGWJOUVNZEF</td><td>913</td><td></td></tr>
  <tr><td>CBITWDHQKLSNVXZMGRYJOUAEFP</td><td>CBTDWHQINLSKVXMZGRYJOAUEFP</td><td>703</td><td></td></tr>
  <tr><td>QFHGOKSWVIPZYBRNJTCUMDEXLA</td><td>QFGSWHOKVPIZBRNYJCUTMEALDX</td><td>1255</td><td></td></tr>
  <tr><td>TWLIRKQZMAFYCVGBSJDEXOUPNH</td><td>TWKLRQZIMFAYCVGBSJOUEDXPHN</td><td>846</td><td></td></tr>
  <tr><td>QCDYRZUMJBGAPHSLINTKFVWEXO</td><td>QCDRZYUMJBAPGSHOLINTKFVEWX</td><td>1224</td><td></td></tr>
  <tr><td>QCMDNFTRKAVWHOBLEJZGUIPYXS</td><td>QCMDNFTRAKVWHOBJUIZGPXLEYS</td><td>1877</td><td></td></tr>
  <tr><td>HFKQDTJMGBNIXPRLOCSWAEYUZV</td><td>HFKQDTJMOGBINAXRPCLEWUZVYS</td><td>1420</td><td></td></tr>
  <tr><td>QRCAFXOEJWHBUVMZGKDPITYSNL</td><td>QCFRAXJOWBHVUMZGKEDPINLTYS</td><td>2004</td><td></td></tr>
  <tr><td>AKRHCJUOXYZGNMTBWPLVEIFSDQ</td><td>ACKRHJOUXZYNGMTWIBPLVFEDSQ</td><td>1761</td><td></td></tr>
  <tr><td>PFJVZWSNYBOQGHALRTUMDIXKCE</td><td>PFJVZSWYNBOQGLHAURITMDXCKE</td><td>1152</td><td></td></tr>
  <tr><td>ZIREHQKFJVYASBNMTDOCXGWUPL</td><td>ZRHEQKFJVMYBAINDTSCOXGWULP</td><td>889</td><td></td></tr>
  <tr><td>KVFUWTXJEANOQRSBYDHLZIGPCM</td><td>KVFTWUXJEANOQRBDYSHILZGPCM</td><td>826</td><td></td></tr>
  <tr><td>GNAOTMZVRIJLEKFPDWQXUHCBSY</td><td>GNTMOAZRVJWIFLKPEDQUXCHBYS</td><td>1458</td><td></td></tr>
  <tr><td>CAMHUDEIYQTXZSRVLBGKPFNOWJ</td><td>CMHAUDYIEQXTZRVBGLOWKPNFSJ</td><td>1341</td><td></td></tr>
  <tr><td>DFJRASZVXHYMWLPTIKQBOENCUG</td><td>DFSJRAZVXWHYMPILTKQBOUNCGE</td><td>1021</td><td></td></tr>
  <tr><td>BREMYDWCJNTPGIUVSLZXAKHOFQ</td><td>BRMYDWECJUNPITGVALZSXKHOQF</td><td>1003</td><td></td></tr>
  <tr><td>UPTGWXYQISEZOLKACVFRBDJNMH</td><td>UPTGWYXQOSIZLECKVARFBDJNHM</td><td>747</td><td></td></tr>
  <tr><td>SVZRYJQKDMLHXFTGCWINABEUOP</td><td>SVZRYJQKDHMLXFAGCOUWINBPTE</td><td>898</td><td></td></tr>
  <tr><td>VYAXOBHDCWINZKRMJSQLPTEUGF</td><td>VYAXBDCHOWINZRKMJSQULEPTGF</td><td>1056</td><td></td></tr>
  <tr><td>XGOZMVQRDWCBJPHIYAUENLKTFS</td><td>XGMZVQDOWCBRJPHAYUINLKEFTS</td><td>2160</td><td></td></tr>
</table>

[words]: https://raw.github.com/dvberkel/letter-soup/master/words.txt
[ascent]: http://en.wikipedia.org/wiki/Gradient_descent
