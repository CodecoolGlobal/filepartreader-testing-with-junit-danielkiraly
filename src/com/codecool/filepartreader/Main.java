package com.codecool.filepartreader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("/Users/mac/Documents/My-projects/FilePart/src/resources/text.txt", 1, 10);

        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
        System.out.println(fileWordAnalyzer.getWordsContainingSubstring("en"));
        System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
    }
}
