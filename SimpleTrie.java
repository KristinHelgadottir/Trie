package JE;

import java.io.PrintStream;

/**
 * Created by Kristin on 26-05-2017.
 */

    // Reading in the shakaspear liturature and sorting it in alphabettical order in Tries.
    // TODO - Count the occurence of each word

    public class SimpleTrie
    {
        public static int SIZE = indexOf('Z') + 2;

        private WordCounter data = null;
        private SimpleTrie[] tries = null;

        public class WordCounter
        {
            String word;
            int count;

            WordCounter(String word)
            {
                this.word = word;
                this.count = 1;
            }
        }

        private static int indexOf(char letter)
        {
            if (letter == '\'') return 26;
            return (int)(letter - 'A');
        }

        public void put(String word, String data)
        {
            if (word.isEmpty()) {
                if (this.data == null)
                {
                    this.data = new WordCounter(data);
                }
                else
                {
                    this.data.count++;
                }
            }else{
                char letter = word.charAt(0);
                int index = indexOf(letter);
                if (tries == null) tries = new SimpleTrie[SIZE];
                if (tries[index] == null) tries[index] = new SimpleTrie();

                SimpleTrie trie = tries[index];
                trie.put(word.substring(1), data);
            }
        }

        public WordCounter get(String word)
        {
            if (word.isEmpty())
            {
                return data;
            }
            if (tries == null)
            {
                return null;
            }
            char letter = word.charAt(0);
            int index = indexOf(letter);

            SimpleTrie trie = tries[index];
            if (trie == null)
            {
                return null;
            }
            return trie.get(word.substring(1));
        }

        public void print(PrintStream out)
        {
           // SimpleTrie.WordCounter bla = new SimpleTrie.WordCounter(data.word+ "Hej fra SimpleTrie");
            if (data != null)
            {
                out.println(data.word + " Occures: " + data.count + " Times");
            }
            if (tries != null)
            {
                for (SimpleTrie trie : tries)
                {
                   // System.out.println("inside print"); // prentast endalaust á milli allra orda, kannski ætti ég ad telja hérna.
                    if (trie == null) continue; // af hverju ætti eithvad af trie i tries ad vera null???
                    trie.print(out);
                }
            }
        }
//
//  public static void main(String[] args) {
////    SimpleTrie trie = new SimpleTrie();
////    trie.put("ANNA", "Anna");
////    trie.put("AND", "And");
////    trie.put("ANDERS", "Anders");
////
////    System.out.println(trie.get("ANNA"));
////    System.out.println(trie.get("ANDERS"));
////    System.out.println(trie.get("ANDERSINE"));
////
////    trie.print(System.out);
//    }

    }

