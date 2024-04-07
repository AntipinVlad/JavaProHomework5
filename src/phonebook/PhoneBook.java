package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Record> records = new ArrayList<>();

    public void add(Record record) {
        records.add(record);
        System.out.println("Record " + record.toString() + " was add successfully");
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equals(name)) return record;
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();

        for (Record record : records) {
            if (record.getName().equals(name)) foundRecords.add(record);
        }

        return foundRecords.isEmpty() ? null : foundRecords;
    }
}
