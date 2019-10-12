package com.codecool.filepartreader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    private List<String> split() throws IOException {
        String originalText = filePartReader.readLines().replaceAll("[.]*[,]*\\n*", "");
        return Arrays.asList(originalText.split("\\W"));
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        List<String> textByWords = split();
        textByWords.sort(String::compareToIgnoreCase);

        return textByWords;
    }

    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        List<String> textByWords = split();

        return textByWords.stream()
                .filter(word -> word.contains(subString))
                .collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() throws IOException {
        List<String> textByWords = split();

        return textByWords.stream()
                .filter(FileWordAnalyzer::isPalindrome)
                .collect(Collectors.toList());
    }

    private static boolean isPalindrome(String word) {
        return word.equals(new StringBuilder(word).reverse().toString());
    }
}
