import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //map with eng(value) and ru(key) words
        HashMap<String, String> words = new HashMap<>();

        //lists with ru/eng words
        ArrayList<String> engList = new ArrayList<>();
        ArrayList<String> ruList = new ArrayList<>();

        //importing files with ru/eng words
        File engFile = new File("eng.txt");
        File ruFile = new File("ru.txt");

        //adding ru/eng words to ru/eng lists
        fullList(engList, engFile);
        fullList(ruList, ruFile);

        //adding eng/ru words to map
        for (int i = 0; i < 60; i++) {
            words.put(ruList.get(i), engList.get(i));
        }

        //scanner for words from console, random for generating random indexes for ruList
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            //index for random ru word
            int index = random.nextInt(words.size());

            //random ru word got by index upper
            String randomRussianWord = ruList.get(index);

            //the right answer got by random ru word
            String correctEnglishTranslation = words.get(randomRussianWord);

            //asking question, scanning the answer
            System.out.println("Translate the word: " + randomRussianWord);
            String userTranslation = scanner.nextLine();

            //checking if user wants to stop the training
            if (userTranslation.equals("0")) {
                System.out.println("Exiting program...");
                break;
            }

            //checking the answer
            if (userTranslation.trim().equalsIgnoreCase(correctEnglishTranslation)) {
                System.out.println("Correct!");
                System.out.println("--------------------------------------------------------------------");
            } else {
                System.out.println("Incorrect. The correct translation is: " + correctEnglishTranslation);
                System.out.println("--------------------------------------------------------------------");
            }

        }
    }

    //adding words from file to list
    private static void fullList(ArrayList<String> list, File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            list.add(sc.nextLine());
        }
    }
}
