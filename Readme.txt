===DESCRIPTION===
This small project is used for generating word puns for English words.
The algorithm has two features which improves the data quality of the generated puns
1. duplicate words with same pun substrings are not include in final result e.g. CAT(cate) and CATe(cate) for CAT
2. duplicate puns with different original words are not included in final result. e.g. DOGS(dogs) and DOGS(docs) for DOG

===Tools and Libraries used===
Java 1.8, Apache Commons Codec, Apache Commons lang, Junit 4

===Instruction for deploy, execute and test this project===
1. How to deploy
- This is a java project built in Eclipse. To deploy, you can simply unzip the file, open eclipse, click File->import, then in the popped up dialog, select 'Existing Projects into Workspace', click next, click 'Browse' and navigate to the root directory of the unzipped file, then click finish. 
- Of course you can also import these project if you are using IntelliJ IDEA.

2. How to run
In this code we support pun generation for single target word or a list of words.
- To generate pun words for a single target word, open MainTest.java in directory io/sample/www/test and uncomment 'print' sentence in function test1(locate in line 52). Then run MainTest.java as a JUnit Test. It will show results for target word "DOG". If you want to change target word, go to function test1 and change this sentence 

String target = "DOG";

- To generate pun words for all the target words in file "DICTIONARY", open MainTest.java in directory io/sample/www/test and uncomment 'print' sentence in function test2(locate in line 79). Then run MainTest.java as a JUnit Test. It will show results for all target words.

3. How to test
Besides MainTest.java, we have other three Junit test classes for testing classes PunGenerator, PunFilter, PunEvaluator. They are located in directory io/sample/www/test.
- To test PunGenerator, go to PunGeneratorTest.java and uncomment output sentences in function testparseWords(locate from line 36 to 41) Then run PunGeneratorTest.java as a JUnit Test.

- To test PunFilter, go to PunFilterTest.java and uncomment output sentences in function testFindPun(locate from line 50 to 53) Then run PunGeneratorTest.java as a JUnit Test.

- To test PunEvaluator, go to PunEvaluatorTest.java and uncomment output sentences in function testParseQueue(locate from line 47 to 49) Then run PunGeneratorTest.java as a JUnit Test.

===Basic Algorithm===
Basically my algorithm is divided into three steps. 
1. PunGenerator: scans the dictionary, puts potential candidates in a potential candidate queue.
2. For each potential candidates in this queue, sends candidate to PunFilter.java
to filter candidates. In PunFilter.java, we use Apache Metaphone library to encode possible substring of candidate words and get their Metaphone value, and we also encode target word and get its Metaphone value, if a substring is a pun of target word, then we should have Metaphone(substring) equals Metaphone(target). After we find candidate puns, we remove unqualified puns which is duplicate, as mentioned above in description. Qualified puns will be store in a sorted queue;
3. After obtain all the qualified puns stored in the sorted queue, convert this sorted priority queue to a result list.