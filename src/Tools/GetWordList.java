package Tools;

import java.util.*;

public class GetWordList {
    private Set<String> storyWords;
    private Map<String, String> wordList;
    private Scanner scanner;


    public GetWordList(List<String> story) {
        wordList = new LinkedHashMap<>();
        scanner = new Scanner(System.in);
        storyWords = new LinkedHashSet<>();
        for (String word : story) {
            word.trim();
            word.replace("\n", "").replace("\r", "");
            if (word.charAt(0) == '*') {
                storyWords.add(word);
            }
        }
    }

    public Map<String, String> playerAddWords() {
        String userWord = null;
        for (String key : storyWords) {
            String libWord = key.substring(1, key.length() - 2);
            do {
                System.out.print(libWord + ": ");
                userWord = scanner.nextLine();
                if (userWord.isEmpty()) {
                    System.out.println("Please enter word.");
                }


            } while (userWord.isEmpty());
            userWord = "*" + userWord;
            wordList.put(key, userWord);
        }
        return wordList;
    }

}
