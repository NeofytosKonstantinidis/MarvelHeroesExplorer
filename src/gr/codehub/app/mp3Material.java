package gr.codehub.app;

import java.util.Date;

public class mp3Material extends Material{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public mp3Material(int id, String filename, String duration, String title, String description, String creator, Date dateOfArchive, int size, String quality, String type) {
        super(id, filename, duration, title, description, creator, dateOfArchive, size, quality);
        this.type = type;
    }
    @Override
    public String toString() {
        return super.toString()+ "mp3Materials{" +
                "type='"+ type +"'}";
    }
}
