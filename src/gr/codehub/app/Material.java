package gr.codehub.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Material {
    int id;
    String filename;
    String duration;
    String title;
    String description;
    String creator;
    Date dateOfArchive;
    int size;
    String quality;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDateOfArchive() {
        return dateOfArchive;
    }

    public void setDateOfArchive(Date dateOfArchive) {
        this.dateOfArchive = dateOfArchive;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Material(int id, String filename, String duration, String title, String description, String creator, Date dateOfArchive, int size, String quality) {
        this.id = id;
        this.filename = filename;
        this.duration = duration;
        this.title = title;
        this.description = description;
        this.creator = creator;
        this.dateOfArchive = dateOfArchive;
        this.size = size;
        this.quality = quality;
    }

    public Material() {
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "material{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", duration='" + duration + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                ", dateOfArchive=" + dateFormat.format(dateOfArchive) +
                ", size=" + size +
                "mb , quality='" + quality + '\'' +
                '}';
    }
}
