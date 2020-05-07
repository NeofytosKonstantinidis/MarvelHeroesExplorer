package gr.codehub.app;

import java.util.Date;

public class mp4Material extends Material{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public mp4Material(int id, String filename, String duration, String title, String description, String creator, Date dateOfArchive, int size, String quality, String sd) {
        super(id, filename, duration, title, description, creator, dateOfArchive, size, quality);
        this.type = sd;
    }
    @Override
    public String toString() {
        return super.toString()+ "mp4Materials{" +
                "type='"+ type +"'}";
    }
}
