package lab3.task1;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Shirt ID: " + id +
                "\nDescription: " + description +
                "\nColor: " + color +
                "\nSize: " + size + "\n";
    }
}