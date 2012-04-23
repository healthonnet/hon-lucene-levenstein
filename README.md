HON Lucene Levenstein Distance
=========================

Custom patch of the default Lucene Levenstein Distance that uses a more "normalized" measure.

The problem with regular Lucene Levenstein distance is that it prefers additions to swaps in certain cases.  For instance, 
Lucene gives a similarity of 0.83 between "candi" and "candid," but 0.8 between "candi" and "candy," because distances 
are normalized over the length of the longer string. A traditional Levenstein distance calculation would give the same distance for both.

This implementation attempts to give a more "classic" Levenstein distance by normalizing over the length of the target word, rather than
the max length of the two words.  This means that, in the example above, the similarity score would be 0.8 for both "candid" and "candy."

This improves spellchecking results in Lucene/Solr because it ensures that results are sorted according to their true edit distance.  Without it,
"candid" would always be preferred to "candy" as a correction for "candi," even though they should be equally likely in terms of edit distance.


Installation
----------

Download the code and do:

```
mvn install
```

Then copy the target/hon-lucene-levenstein-1.0.jar into your Solr war's lib directory.

Then, for every spellchecker that you want to use this Levenstein distance for, add the following to the solrconfig.xml:

```xml
<lst name="spellchecker">
   ...
   <str name="distanceMeasure">org.healthonnet.spellcheck.levenstein.NormalizedLevensteinDistance</str>
   ...
</lst>

Developer
-----------

Nolan Lawson

Health on the Net Foundation

License
-----------

[Apache 2.0][1].

[1]: http://www.apache.org/licenses/LICENSE-2.0.html
