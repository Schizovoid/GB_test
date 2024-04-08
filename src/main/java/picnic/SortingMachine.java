package picnic;

import java.io.*;
import java.util.*;

public class SortingMachine {
    String[] wordsArr;
    public SortingMachine(File file){
    try(FileReader fr = new FileReader(file)) {
        try(BufferedReader br = new BufferedReader(fr)) {
            String wordsString = br.readLine();
            wordsArr = wordsString.split(" ");
            findLongestWord(wordsArr);
            countTheWords(wordsArr);
            countWordInstances(wordsArr);
        }
    } catch (IOException e){
        System.out.println("Не найден файл!");
    }
    }

    public void findLongestWord(String[] wordsArr){
    String longestWord = wordsArr[0];
        for (int i = 1; i < wordsArr.length; i++) {
            char[] chars = wordsArr[i].toCharArray();
            char[] charsPrev = wordsArr[i - 1].toCharArray();
            if (chars.length > charsPrev.length){
                longestWord = wordsArr[i];
            }
        }
        System.out.println("Самое длинное слово в файле: " + longestWord);
    }
    public void countTheWords(String[] wordsArr){
    int length = wordsArr.length;
        System.out.println(String.format("Всего слов в файле: %d", length));
    }
    public void countWordInstances(String[] wordsArr){
        Map<String,Integer> wordsCount = new HashMap<String, Integer>();
        for (String word : wordsArr)
        {
            if(wordsCount.containsKey(word) & !Objects.equals(word, ""))
            {
                wordsCount.put(word, wordsCount.get(word)+1);
            }
            else
            {
                wordsCount.put(word, 1);
            }

        }
        for (Map.Entry entry : wordsCount.entrySet())
        {
            System.out.println("Слово: " + entry.getKey() + "; Встречается: " + entry.getValue() + " раз(а).");
        }
    }
}
