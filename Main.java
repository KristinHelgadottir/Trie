package JE;

import helpers.FileUtility;
import java.io.IOException;

public class Main
{
        public static void main(String[] args) throws IOException
        {
            String[] words = FileUtility.toStringArray("/Users/Kristin/Documents/NetBeansProjects/TriesOnTheAlphab/src/helpers/shak.txt", "[^A-Za-z]");
            // I have all words in here
            SimpleTrie tries = new SimpleTrie();
            // I insert them into my Trie
            for (String word : words)
            {
                tries.put(word, word);
            }

            System.out.println("Find " + tries.get("OR"));
            tries.print(System.out);

//        SortingAlgorithms obj1 = new SortingAlgorithms(10);
//        SortingAlgorithms obj2 = new SortingAlgorithms(100);
//        SortingAlgorithms obj3 = new SortingAlgorithms(1000);
    }
}
