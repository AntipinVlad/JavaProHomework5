import phonebook.PhoneBook;
import phonebook.Record;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>(List.of("bird", "cat", "dog", "bird", "fox", "cat", "bird",
                "bird", "dog", "cat", "bird", "dog", "cat", "fox", "bird"));
        countOccurrence(animals, "bird");

        Character[] letters = {'o', 'c', 'c', 'u', 'r', 'r', 'e', 'n', 'c', 'e'};
        toList(letters);

        List<Integer> numbers = new ArrayList<>(List.of(8, 18, 88, -8, 0, 28, 8, 8));
        findUnique(numbers);

        calcOccurrence(animals);

        System.out.println(findOccurrence(animals));
        System.out.println();

        PhoneBook odessaPhoneBook = new PhoneBook();
        odessaPhoneBook.add(new Record("Record1", "+380632546866"));
        odessaPhoneBook.add(new Record("Record2", "+380982058711"));
        odessaPhoneBook.add(new Record("Record1", "+380973688366"));
        odessaPhoneBook.add(new Record("Record3", "+38089652008"));
        odessaPhoneBook.add(new Record("Record2", "+38089652008"));
        odessaPhoneBook.add(new Record("Record4", "+38089652008"));
        odessaPhoneBook.add(new Record("Record5", "+38089652008"));


        findRecord("Record2", odessaPhoneBook);
        findAllRecords("Record1", odessaPhoneBook);
    }

    public static void countOccurrence(List<String> words, String word){
        int counter = 0;
        for (String currentWord: words) {
            if (currentWord.equals(word)) counter++;
        }
        System.out.printf("%s occurs %d times. \n\n", word, counter);
    }

    public static <T> void toList(T[] array){
        List<T> lettersList = new ArrayList<>(Arrays.asList(array));
        System.out.println(Arrays.toString(array) + " (class: " + array.getClass() + ")");
        System.out.println(lettersList + " (class: " + lettersList.getClass() + ")\n");
    }

    public static void findUnique(List<Integer> numbers){
        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number: numbers){
            if (!uniqueNumbers.contains(number)) uniqueNumbers.add(number);
        }
        System.out.println("All numbers: " + numbers);
        System.out.println("Unique numbers: " + uniqueNumbers + "\n");
    }

    public static void calcOccurrence(List<String> words) {
        List<String> occurrences = new ArrayList<>();
        for (String currentWord : words) {
            if (!occurrences.contains(currentWord)) {
                occurrences.add(currentWord);
                int counter = 0;
                for (String compareWord : words) {
                    if (currentWord.equals(compareWord)) counter++;
                }
                System.out.printf("%s occurs %d times \n", currentWord, counter);
            }
        }
        System.out.println();
    }

    public static List<Occurrence> findOccurrence(List<String> words){
        List<Occurrence> occurrences = new ArrayList<>();
        for (String word: words){
            boolean inList = false;
            for (Occurrence object: occurrences){
                if (word.equals(object.getName())){
                    inList = true;
                    object.incrementOccurrence();
                }
            }
            if (!inList){
                occurrences.add(new Occurrence(word));
            }
        }
        return occurrences;
    }

    private static void findRecord(String name, PhoneBook phoneBook) {
        Record foundRecord = phoneBook.find(name);
        if (foundRecord != null)
            System.out.println("Record found by name " + foundRecord.getName() + foundRecord + "\n");
        else
            System.out.println("There are no records for name " + name + ".\n");
    }

    private static void findAllRecords(String name, PhoneBook phoneBook) {
        List<Record> foundRecords = phoneBook.findAll(name);
        if (!foundRecords.isEmpty()) {
            System.out.println("Records found by name " + name + " (all): ");
            for (Record currentRecord : foundRecords)
                System.out.println(currentRecord);
        } else
            System.out.println("There are no records for name " + name + ".\n");
    }
}