public class Occurrence {
    private String name;
    private int occurrence;

    public Occurrence(String name) {
        this.name = name;
        this.occurrence = 1;
    }

    public void incrementOccurrence(){
        occurrence++;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{name: \"" + name + "\", occurrence: " + occurrence + "}";
    }
}
